package com.shortreels.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import com.shortreels.data.repository.VideoRepository;
import com.shortreels.data.repository.SeriesRepository;
import com.shortreels.domain.model.Video;
import com.shortreels.domain.model.Series;
import com.shortreels.domain.model.Genre;
import com.shortreels.utils.NetworkResult;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

/**
 * FeedViewModel - Manages vertical video feed state.
 * Handles video loading, pagination, like/bookmark actions.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u000bJ\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\rJ\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u000bJ\u0016\u0010(\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u000bJ$\u0010*\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0,H\u0002J\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/shortreels/presentation/viewmodel/FeedViewModel;", "Landroidx/lifecycle/ViewModel;", "videoRepository", "Lcom/shortreels/data/repository/VideoRepository;", "(Lcom/shortreels/data/repository/VideoRepository;)V", "_currentVideoIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_feedState", "Lcom/shortreels/presentation/viewmodel/FeedUiState;", "_isRefreshing", "", "_selectedGenre", "Lcom/shortreels/domain/model/Genre;", "currentPage", "currentVideoIndex", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentVideoIndex", "()Lkotlinx/coroutines/flow/StateFlow;", "feedState", "getFeedState", "isLoadingMore", "isRefreshing", "selectedGenre", "getSelectedGenre", "videoList", "", "Lcom/shortreels/domain/model/Video;", "loadFeed", "", "refresh", "loadMoreVideos", "onVideoScrolled", "index", "setGenreFilter", "genre", "toggleBookmark", "videoId", "", "isBookmarked", "toggleLike", "isLiked", "updateVideoInList", "update", "Lkotlin/Function1;", "updateWatchProgress", "progress", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FeedViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.repository.VideoRepository videoRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shortreels.presentation.viewmodel.FeedUiState> _feedState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.shortreels.presentation.viewmodel.FeedUiState> feedState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _currentVideoIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> currentVideoIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shortreels.domain.model.Genre> _selectedGenre = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.shortreels.domain.model.Genre> selectedGenre = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    private int currentPage = 1;
    private boolean isLoadingMore = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.domain.model.Video> videoList = null;
    
    @javax.inject.Inject()
    public FeedViewModel(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.VideoRepository videoRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shortreels.presentation.viewmodel.FeedUiState> getFeedState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getCurrentVideoIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shortreels.domain.model.Genre> getSelectedGenre() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    public final void loadFeed(boolean refresh) {
    }
    
    public final void onVideoScrolled(int index) {
    }
    
    private final void loadMoreVideos() {
    }
    
    public final void toggleLike(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, boolean isLiked) {
    }
    
    public final void toggleBookmark(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, boolean isBookmarked) {
    }
    
    public final void updateWatchProgress(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, float progress) {
    }
    
    public final void setGenreFilter(@org.jetbrains.annotations.Nullable()
    com.shortreels.domain.model.Genre genre) {
    }
    
    private final void updateVideoInList(java.lang.String videoId, kotlin.jvm.functions.Function1<? super com.shortreels.domain.model.Video, com.shortreels.domain.model.Video> update) {
    }
    
    public final void refresh() {
    }
}