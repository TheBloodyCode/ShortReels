package com.shortreels.data.repository

import com.shortreels.data.local.dao.*
import com.shortreels.data.local.entities.*
import com.shortreels.data.remote.api.ExtractorApi
import com.shortreels.data.remote.api.ShortReelsApiService
import com.shortreels.data.remote.dto.ExtractorVideoDto
import com.shortreels.data.remote.models.*
import com.shortreels.domain.model.*
import com.shortreels.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * VideoRepository
 * Implements Repository pattern (offline-first):
 * 1. Emit local cached data immediately
 * 2. Fetch from network in background
 * 3. Update local cache and re-emit
 */
@Singleton
class VideoRepository @Inject constructor(
    private val apiService: ShortReelsApiService,
    private val extractorApi: ExtractorApi,
    private val videoDao: VideoDao,
    private val tokenManager: TokenManager
) {

    fun getFeedVideos(genre: String? = null): Flow<NetworkResult<List<Video>>> = flow {
        emit(NetworkResult.Loading)
        try {
            val response = apiService.getFeed(genre = genre)
            if (response.isSuccessful && response.body()?.success == true) {
                val videos = response.body()!!.data ?: emptyList()
                videoDao.insertVideos(videos.map { it.toEntity() })
                emit(NetworkResult.Success(videos.map { it.toDomain() }))
            } else {
                emit(NetworkResult.Error("Error al cargar el feed (${response.message()})"))
            }
        } catch (e: Exception) {
            emit(NetworkResult.Error("Sin conexión. Revisa tu internet."))
        }
    }

    fun getTrendingVideos(): Flow<NetworkResult<List<Video>>> = flow {
        emit(NetworkResult.Loading)
        try {
            val internalResponse = apiService.getTrendingVideos()
            if (internalResponse.isSuccessful && internalResponse.body()?.success == true) {
                emit(NetworkResult.Success(internalResponse.body()!!.data!!.map { it.toDomain() }))
            } else {
                emit(NetworkResult.Error("API Error: ${internalResponse.code()}"))
            }
        } catch (e: Exception) {
            emit(NetworkResult.Error("Sin conexión. Revisa tu internet."))
        }
    }

    suspend fun getVideoById(videoId: String): NetworkResult<Video> {
        return try {
            // Check local cache first
            val cached = videoDao.getVideoById(videoId)
            if (cached != null) {
                return NetworkResult.Success(cached.toDomain())
            }
            val response = apiService.getVideoById(videoId)
            if (response.isSuccessful && response.body()?.success == true) {
                val video = response.body()!!.data!!
                videoDao.insertVideo(video.toEntity())
                NetworkResult.Success(video.toDomain())
            } else {
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }

    suspend fun toggleLike(videoId: String, isLiked: Boolean): NetworkResult<Unit> {
        // Optimistic update
        videoDao.updateLikeStatus(videoId, isLiked)
        return try {
            val token = tokenManager.getToken() ?: return NetworkResult.Error("Not authenticated")
            val response = if (isLiked) {
                apiService.likeVideo(videoId, "Bearer $token")
            } else {
                apiService.unlikeVideo(videoId, "Bearer $token")
            }
            if (response.isSuccessful) {
                NetworkResult.Success(Unit)
            } else {
                // Revert on failure
                videoDao.updateLikeStatus(videoId, !isLiked)
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            videoDao.updateLikeStatus(videoId, !isLiked)
            NetworkResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }

    suspend fun toggleBookmark(videoId: String, isBookmarked: Boolean): NetworkResult<Unit> {
        videoDao.updateBookmarkStatus(videoId, isBookmarked)
        return try {
            val token = tokenManager.getToken() ?: return NetworkResult.Error("Not authenticated")
            val response = if (isBookmarked) {
                apiService.addBookmark(videoId, "Bearer $token")
            } else {
                apiService.removeBookmark(videoId, "Bearer $token")
            }
            if (response.isSuccessful) NetworkResult.Success(Unit)
            else {
                videoDao.updateBookmarkStatus(videoId, !isBookmarked)
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            videoDao.updateBookmarkStatus(videoId, !isBookmarked)
            NetworkResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }

    suspend fun updateWatchProgress(videoId: String, progress: Float) {
        videoDao.updateWatchProgress(videoId, progress)
    }

    fun getBookmarkedVideos(): Flow<List<Video>> =
        videoDao.getBookmarkedVideos().map { list -> list.map { it.toDomain() } }

    suspend fun searchVideos(query: String): List<Video> {
        return try {
            val extractorResponse = extractorApi.search(query = query)
            if (extractorResponse.isSuccessful) {
                val results = extractorResponse.body() ?: emptyList()
                results.map { it.toDomain() }
            } else {
                val response = apiService.search(query)
                if (response.isSuccessful && response.body()?.success == true) {
                    response.body()!!.data!!.videos.map { it.toDomain() }
                } else {
                    videoDao.searchVideos(query).map { it.toDomain() }
                }
            }
        } catch (e: Exception) {
            try {
                val response = apiService.search(query)
                if (response.isSuccessful && response.body()?.success == true) {
                    response.body()!!.data!!.videos.map { it.toDomain() }
                } else {
                    videoDao.searchVideos(query).map { it.toDomain() }
                }
            } catch (inner: Exception) {
                videoDao.searchVideos(query).map { it.toDomain() }
            }
        }
    }
}

/**
 * SeriesRepository
 */
@Singleton
class SeriesRepository @Inject constructor(
    private val apiService: ShortReelsApiService,
    private val seriesDao: SeriesDao,
    private val tokenManager: TokenManager
) {

    fun getSeries(genre: String? = null): Flow<NetworkResult<List<Series>>> = flow {
        emit(NetworkResult.Loading)
        try {
            val response = apiService.getSeries(genre = genre)
            if (response.isSuccessful && response.body()?.success == true) {
                val series = response.body()!!.data ?: emptyList()
                seriesDao.insertSeriesList(series.map { it.toEntity() })
                emit(NetworkResult.Success(series.map { it.toDomain() }))
            } else {
                emit(NetworkResult.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.localizedMessage ?: "Unknown error"))
        }
    }

    suspend fun getSeriesById(seriesId: String): NetworkResult<Series> {
        return try {
            val cached = seriesDao.getSeriesById(seriesId)
            if (cached != null) return NetworkResult.Success(cached.toDomain())
            val response = apiService.getSeriesById(seriesId)
            if (response.isSuccessful && response.body()?.success == true) {
                val series = response.body()!!.data!!
                seriesDao.insertSeries(series.toEntity())
                NetworkResult.Success(series.toDomain())
            } else {
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }

    suspend fun toggleFollow(seriesId: String, isFollowing: Boolean): NetworkResult<Unit> {
        seriesDao.updateFollowStatus(seriesId, isFollowing)
        return try {
            val token = tokenManager.getToken() ?: return NetworkResult.Error("Not authenticated")
            val response = if (isFollowing) {
                apiService.followSeries(seriesId, "Bearer $token")
            } else {
                apiService.unfollowSeries(seriesId, "Bearer $token")
            }
            if (response.isSuccessful) NetworkResult.Success(Unit)
            else {
                seriesDao.updateFollowStatus(seriesId, !isFollowing)
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            seriesDao.updateFollowStatus(seriesId, !isFollowing)
            NetworkResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }

    fun getFollowedSeries(): Flow<List<Series>> =
        seriesDao.getFollowedSeries().map { list -> list.map { it.toDomain() } }

    fun getFeaturedSeries(): Flow<NetworkResult<List<Series>>> = flow {
        emit(NetworkResult.Loading)
        try {
            val response = apiService.getFeaturedSeries()
            if (response.isSuccessful && response.body()?.success == true) {
                emit(NetworkResult.Success(response.body()!!.data!!.map { it.toDomain() }))
            } else {
                emit(NetworkResult.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.localizedMessage ?: "Unknown error"))
        }
    }
}

/**
 * AuthRepository - Java-friendly with coroutines
 */
@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ShortReelsApiService,
    private val userDao: UserDao,
    private val tokenManager: TokenManager,
    private val sessionManager: SessionManager
) {

    suspend fun login(email: String, password: String): NetworkResult<User> {
        return try {
            val response = apiService.login(
                LoginRequest(email, password, sessionManager.getDeviceId())
            )
            if (response.isSuccessful && response.body()?.success == true) {
                val auth = response.body()!!.data!!
                tokenManager.saveToken(auth.accessToken, auth.refreshToken, auth.expiresIn)
                val user = auth.user.toDomain()
                userDao.insertUser(auth.user.toEntity())
                sessionManager.setLoggedIn(true)
                NetworkResult.Success(user)
            } else {
                NetworkResult.Error(response.body()?.message ?: "Login failed")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.localizedMessage ?: "Network error")
        }
    }

    suspend fun register(username: String, email: String, password: String): NetworkResult<User> {
        return try {
            val response = apiService.register(
                RegisterRequest(username, email, password, sessionManager.getDeviceId())
            )
            if (response.isSuccessful && response.body()?.success == true) {
                val auth = response.body()!!.data!!
                tokenManager.saveToken(auth.accessToken, auth.refreshToken, auth.expiresIn)
                val user = auth.user.toDomain()
                userDao.insertUser(auth.user.toEntity())
                sessionManager.setLoggedIn(true)
                NetworkResult.Success(user)
            } else {
                NetworkResult.Error(response.body()?.message ?: "Registration failed")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.localizedMessage ?: "Network error")
        }
    }

    suspend fun logout() {
        try {
            val token = tokenManager.getToken()
            if (token != null) apiService.logout("Bearer $token")
        } finally {
            tokenManager.clearTokens()
            userDao.deleteAll()
            sessionManager.setLoggedIn(false)
        }
    }

    fun isLoggedIn(): Boolean = sessionManager.isLoggedIn()

    fun getCurrentUser(): Flow<User?> =
        userDao.getCurrentUser().map { it?.toDomain() }
}

// ===== Mappers (extension functions) =====

fun VideoDto.toEntity() = VideoEntity(
    id = id, title = title, description = description,
    videoUrl = videoUrl, thumbnailUrl = thumbnailUrl, hlsUrl = hlsUrl,
    duration = duration, episode = episode, season = season,
    seriesId = seriesId, seriesTitle = seriesTitle, genre = genre,
    tags = tags.joinToString(","),
    likeCount = stats.likes, commentCount = stats.comments,
    shareCount = stats.shares, viewCount = stats.views,
    bookmarkCount = stats.bookmarks,
    isPremium = monetization.isPremium, isLocked = monetization.isLocked,
    coinsRequired = monetization.coinsRequired, unlockType = monetization.unlockType,
    isLiked = isLiked, isBookmarked = isBookmarked,
    authorId = author.id, authorUsername = author.username,
    authorDisplayName = author.displayName, authorAvatarUrl = author.avatarUrl,
    authorIsVerified = author.isVerified, authorFollowerCount = author.followerCount,
    createdAt = createdAt, updatedAt = updatedAt
)

fun VideoDto.toDomain() = Video(
    id = id, title = title, description = description,
    videoUrl = videoUrl, thumbnailUrl = thumbnailUrl, hlsUrl = hlsUrl,
    duration = duration, episode = episode, season = season,
    seriesId = seriesId, seriesTitle = seriesTitle,
    genre = Genre.values().find { it.name == genre } ?: Genre.DRAMA,
    tags = tags,
    author = Author(author.id, author.username, author.displayName, author.avatarUrl,
        author.bio, author.followerCount, author.followingCount, author.isVerified, author.isFollowing),
    stats = VideoStats(stats.views, stats.likes, stats.comments, stats.shares, stats.bookmarks),
    monetization = Monetization(monetization.isPremium, monetization.isLocked,
        monetization.coinsRequired,
        UnlockType.values().find { it.name == monetization.unlockType } ?: UnlockType.FREE),
    createdAt = createdAt, updatedAt = updatedAt,
    isLiked = isLiked, isBookmarked = isBookmarked
)

fun VideoEntity.toDomain() = Video(
    id = id, title = title, description = description,
    videoUrl = videoUrl, thumbnailUrl = thumbnailUrl, hlsUrl = hlsUrl,
    duration = duration, episode = episode, season = season,
    seriesId = seriesId, seriesTitle = seriesTitle,
    genre = Genre.values().find { it.name == genre } ?: Genre.DRAMA,
    tags = tags.split(",").filter { it.isNotBlank() },
    author = Author(authorId, authorUsername, authorDisplayName, authorAvatarUrl,
        "", authorFollowerCount, 0, authorIsVerified),
    stats = VideoStats(viewCount, likeCount, commentCount, shareCount, bookmarkCount),
    monetization = Monetization(isPremium, isLocked, coinsRequired,
        UnlockType.values().find { it.name == unlockType } ?: UnlockType.FREE),
    createdAt = createdAt, updatedAt = updatedAt,
    isLiked = isLiked, isBookmarked = isBookmarked,
    isDownloaded = isDownloaded,
    watchProgress = watchProgress
)

fun ExtractorVideoDto.toDomain() = Video(
    id = id,
    title = title,
    description = "",
    videoUrl = url,
    thumbnailUrl = thumbnailUrl,
    hlsUrl = null,
    duration = duration,
    episode = 1,
    season = 1,
    seriesId = "yt_$id",
    seriesTitle = "YouTube",
    genre = Genre.DRAMA,
    tags = emptyList(),
    author = Author(
        id = uploaderUrl,
        username = uploader,
        displayName = uploader,
        avatarUrl = uploaderAvatarUrl,
        bio = "",
        followerCount = views,
        followingCount = 0,
        isVerified = false,
        isFollowing = false
    ),
    stats = VideoStats(
        views = views,
        likes = 0,
        comments = 0,
        shares = 0,
        bookmarks = 0
    ),
    monetization = Monetization(
        isPremium = false,
        isLocked = false,
        coinsRequired = 0,
        unlockType = UnlockType.FREE
    ),
    createdAt = System.currentTimeMillis(),
    updatedAt = System.currentTimeMillis(),
    isLiked = false,
    isBookmarked = false,
    isDownloaded = false,
    watchProgress = 0f
)

fun SeriesDto.toEntity() = SeriesEntity(
    id = id, title = title, description = description,
    thumbnailUrl = thumbnailUrl, bannerUrl = bannerUrl, genre = genre,
    tags = tags.joinToString(","),
    totalEpisodes = totalEpisodes, authorId = author.id, authorUsername = author.username,
    authorDisplayName = author.displayName, authorAvatarUrl = author.avatarUrl,
    rating = rating, reviewCount = reviewCount,
    isPremium = monetization.isPremium, status = status,
    releaseSchedule = releaseSchedule, createdAt = createdAt, isFollowing = isFollowing
)

fun SeriesDto.toDomain() = Series(
    id = id, title = title, description = description,
    thumbnailUrl = thumbnailUrl, bannerUrl = bannerUrl,
    genre = Genre.values().find { it.name == genre } ?: Genre.DRAMA,
    tags = tags, episodes = emptyList(), totalEpisodes = totalEpisodes,
    author = Author(author.id, author.username, author.displayName, author.avatarUrl,
        author.bio, author.followerCount, author.followingCount, author.isVerified, author.isFollowing),
    rating = rating, reviewCount = reviewCount,
    monetization = Monetization(monetization.isPremium, monetization.isLocked, monetization.coinsRequired),
    status = SeriesStatus.values().find { it.name == status } ?: SeriesStatus.ONGOING,
    releaseSchedule = releaseSchedule, createdAt = createdAt, isFollowing = isFollowing
)

fun SeriesEntity.toDomain() = Series(
    id = id, title = title, description = description,
    thumbnailUrl = thumbnailUrl, bannerUrl = bannerUrl,
    genre = Genre.values().find { it.name == genre } ?: Genre.DRAMA,
    tags = tags.split(",").filter { it.isNotBlank() },
    episodes = emptyList(), totalEpisodes = totalEpisodes,
    author = Author(authorId, authorUsername, authorDisplayName, authorAvatarUrl,
        "", 0, 0, false),
    rating = rating, reviewCount = reviewCount,
    monetization = Monetization(isPremium, false),
    status = SeriesStatus.values().find { it.name == status } ?: SeriesStatus.ONGOING,
    releaseSchedule = releaseSchedule, createdAt = createdAt, isFollowing = isFollowing
)

fun UserDto.toDomain() = User(
    id = id, username = username, displayName = displayName,
    email = email, avatarUrl = avatarUrl, bio = bio,
    followerCount = followerCount, followingCount = followingCount,
    isVerified = isVerified,
    subscriptionPlan = SubscriptionPlan.values().find { it.name == subscriptionPlan } ?: SubscriptionPlan.FREE,
    coins = coins, createdAt = createdAt
)

fun UserDto.toEntity() = UserEntity(
    id = id, username = username, displayName = displayName,
    email = email, avatarUrl = avatarUrl, bio = bio,
    followerCount = followerCount, followingCount = followingCount,
    isVerified = isVerified, subscriptionPlan = subscriptionPlan,
    coins = coins, createdAt = createdAt
)

fun UserEntity.toDomain() = User(
    id = id, username = username, displayName = displayName,
    email = email, avatarUrl = avatarUrl, bio = bio,
    followerCount = followerCount, followingCount = followingCount,
    isVerified = isVerified,
    subscriptionPlan = SubscriptionPlan.values().find { it.name == subscriptionPlan } ?: SubscriptionPlan.FREE,
    coins = coins, createdAt = createdAt
)
