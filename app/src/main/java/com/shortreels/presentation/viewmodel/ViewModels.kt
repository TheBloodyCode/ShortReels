package com.shortreels.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shortreels.data.repository.VideoRepository
import com.shortreels.data.repository.SeriesRepository
import com.shortreels.domain.model.Video
import com.shortreels.domain.model.Series
import com.shortreels.domain.model.Genre
import com.shortreels.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * FeedViewModel - Manages vertical video feed state.
 * Handles video loading, pagination, like/bookmark actions.
 */
@HiltViewModel
class FeedViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    private val _feedState = MutableStateFlow<FeedUiState>(FeedUiState.Loading)
    val feedState: StateFlow<FeedUiState> = _feedState.asStateFlow()

    private val _currentVideoIndex = MutableStateFlow(0)
    val currentVideoIndex: StateFlow<Int> = _currentVideoIndex.asStateFlow()

    private val _selectedGenre = MutableStateFlow<Genre?>(null)
    val selectedGenre: StateFlow<Genre?> = _selectedGenre.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    private var currentPage = 1
    private var isLoadingMore = false
    private val videoList = mutableListOf<Video>()

    init {
        loadFeed()
    }

    fun loadFeed(refresh: Boolean = false) {
        if (refresh) {
            currentPage = 1
            videoList.clear()
            _isRefreshing.value = true
        }

        viewModelScope.launch {
            videoRepository.getFeedVideos(genre = _selectedGenre.value?.name)
                .collect { result ->
                    _isRefreshing.value = false
                    when (result) {
                        is NetworkResult.Loading -> {
                            if (videoList.isEmpty()) _feedState.value = FeedUiState.Loading
                        }
                        is NetworkResult.Success -> {
                            if (refresh) videoList.clear()
                            videoList.addAll(result.data)
                            _feedState.value = FeedUiState.Success(videoList.toList())
                        }
                        is NetworkResult.Error -> {
                            _feedState.value = if (videoList.isEmpty()) {
                                FeedUiState.Error(result.message)
                            } else {
                                FeedUiState.Success(videoList.toList()) // Keep existing data
                            }
                        }
                    }
                }
        }
    }

    fun onVideoScrolled(index: Int) {
        _currentVideoIndex.value = index
        // Preload next videos when near end
        val currentVideos = (feedState.value as? FeedUiState.Success)?.videos ?: return
        if (index >= currentVideos.size - 3) {
            loadMoreVideos()
        }
    }

    private fun loadMoreVideos() {
        if (isLoadingMore) return
        isLoadingMore = true
        currentPage++
        viewModelScope.launch {
            videoRepository.getFeedVideos(genre = _selectedGenre.value?.name)
                .collect { result ->
                    isLoadingMore = false
                    if (result is NetworkResult.Success) {
                        videoList.addAll(result.data)
                        _feedState.value = FeedUiState.Success(videoList.toList())
                    }
                }
        }
    }

    fun toggleLike(videoId: String, isLiked: Boolean) {
        viewModelScope.launch {
            // Optimistic update
            updateVideoInList(videoId) { video ->
                val newLikeCount = if (isLiked) video.stats.likes + 1 else video.stats.likes - 1
                video.copy(
                    isLiked = isLiked,
                    stats = video.stats.copy(likes = maxOf(0, newLikeCount))
                )
            }
            videoRepository.toggleLike(videoId, isLiked)
        }
    }

    fun toggleBookmark(videoId: String, isBookmarked: Boolean) {
        viewModelScope.launch {
            updateVideoInList(videoId) { video ->
                video.copy(isBookmarked = isBookmarked)
            }
            videoRepository.toggleBookmark(videoId, isBookmarked)
        }
    }

    fun updateWatchProgress(videoId: String, progress: Float) {
        viewModelScope.launch {
            videoRepository.updateWatchProgress(videoId, progress)
        }
    }

    fun setGenreFilter(genre: Genre?) {
        if (_selectedGenre.value == genre) return
        _selectedGenre.value = genre
        loadFeed(refresh = true)
    }

    private fun updateVideoInList(videoId: String, update: (Video) -> Video) {
        val idx = videoList.indexOfFirst { it.id == videoId }
        if (idx != -1) {
            videoList[idx] = update(videoList[idx])
            _feedState.value = FeedUiState.Success(videoList.toList())
        }
    }

    fun refresh() = loadFeed(refresh = true)
}

sealed class FeedUiState {
    object Loading : FeedUiState()
    data class Success(val videos: List<Video>) : FeedUiState()
    data class Error(val message: String) : FeedUiState()
}

/**
 * ExploreViewModel - Handles discovery/explore screen
 */
@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val videoRepository: VideoRepository,
    private val seriesRepository: SeriesRepository
) : ViewModel() {

    private val _trendingVideos = MutableStateFlow<NetworkResult<List<Video>>>(NetworkResult.Loading)
    val trendingVideos: StateFlow<NetworkResult<List<Video>>> = _trendingVideos.asStateFlow()

    private val _featuredSeries = MutableStateFlow<NetworkResult<List<Series>>>(NetworkResult.Loading)
    val featuredSeries: StateFlow<NetworkResult<List<Series>>> = _featuredSeries.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<SearchResultState>(SearchResultState.Idle)
    val searchResults: StateFlow<SearchResultState> = _searchResults.asStateFlow()

    init {
        loadTrending()
        loadFeaturedSeries()
        // Debounced search
        viewModelScope.launch {
            _searchQuery
                .debounce(400)
                .filter { it.length >= 2 }
                .collect { query -> performSearch(query) }
        }
    }

    fun loadTrending() {
        viewModelScope.launch {
            videoRepository.getTrendingVideos().collect { _trendingVideos.value = it }
        }
    }

    private fun loadFeaturedSeries() {
        viewModelScope.launch {
            seriesRepository.getFeaturedSeries().collect { _featuredSeries.value = it }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        if (query.isEmpty()) {
            _searchResults.value = SearchResultState.Idle
        }
    }

    private suspend fun performSearch(query: String) {
        _searchResults.value = SearchResultState.Loading
        try {
            val videos = videoRepository.searchVideos(query)
            _searchResults.value = SearchResultState.Results(videos)
        } catch (e: Exception) {
            _searchResults.value = SearchResultState.Error(e.localizedMessage ?: "Search error")
        }
    }

    fun clearSearch() {
        _searchQuery.value = ""
        _searchResults.value = SearchResultState.Idle
    }
}

sealed class SearchResultState {
    object Idle : SearchResultState()
    object Loading : SearchResultState()
    data class Results(val videos: List<Video>) : SearchResultState()
    data class Error(val message: String) : SearchResultState()
}

/**
 * AuthViewModel - Handles authentication flows
 */
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: com.shortreels.data.repository.AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val authState: StateFlow<AuthUiState> = _authState.asStateFlow()

    val isLoggedIn: Boolean get() = authRepository.isLoggedIn()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthUiState.Loading
            val result = authRepository.login(email, password)
            _authState.value = when (result) {
                is NetworkResult.Success -> AuthUiState.Success
                is NetworkResult.Error -> AuthUiState.Error(result.message)
                else -> AuthUiState.Error("Unknown error")
            }
        }
    }

    fun register(username: String, email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthUiState.Loading
            val result = authRepository.register(username, email, password)
            _authState.value = when (result) {
                is NetworkResult.Success -> AuthUiState.Success
                is NetworkResult.Error -> AuthUiState.Error(result.message)
                else -> AuthUiState.Error("Unknown error")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
            _authState.value = AuthUiState.LoggedOut
        }
    }

    fun resetState() {
        _authState.value = AuthUiState.Idle
    }
}

sealed class AuthUiState {
    object Idle : AuthUiState()
    object Loading : AuthUiState()
    object Success : AuthUiState()
    object LoggedOut : AuthUiState()
    data class Error(val message: String) : AuthUiState()
}

/**
 * PlayerViewModel - Controls ExoPlayer state
 */
@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    private val _playerState = MutableStateFlow<PlayerUiState>(PlayerUiState.Idle)
    val playerState: StateFlow<PlayerUiState> = _playerState.asStateFlow()

    private val _isMuted = MutableStateFlow(false)
    val isMuted: StateFlow<Boolean> = _isMuted.asStateFlow()

    private val _showControls = MutableStateFlow(false)
    val showControls: StateFlow<Boolean> = _showControls.asStateFlow()

    fun setCurrentVideo(videoId: String) {
        viewModelScope.launch {
            _playerState.value = PlayerUiState.Loading
            when (val result = videoRepository.getVideoById(videoId)) {
                is NetworkResult.Success -> _playerState.value = PlayerUiState.Playing(result.data)
                is NetworkResult.Error -> _playerState.value = PlayerUiState.Error(result.message)
                else -> {}
            }
        }
    }

    fun toggleMute() {
        _isMuted.value = !_isMuted.value
    }

    fun showControls(show: Boolean) {
        _showControls.value = show
    }

    fun saveProgress(videoId: String, progress: Float) {
        viewModelScope.launch {
            videoRepository.updateWatchProgress(videoId, progress)
        }
    }
}

sealed class PlayerUiState {
    object Idle : PlayerUiState()
    object Loading : PlayerUiState()
    data class Playing(val video: com.shortreels.domain.model.Video) : PlayerUiState()
    data class Error(val message: String) : PlayerUiState()
}
