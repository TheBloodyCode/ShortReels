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
 * ExploreViewModel - Handles discovery/explore screen
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\rJ\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\rH\u0082@\u00a2\u0006\u0002\u0010#R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/shortreels/presentation/viewmodel/ExploreViewModel;", "Landroidx/lifecycle/ViewModel;", "videoRepository", "Lcom/shortreels/data/repository/VideoRepository;", "seriesRepository", "Lcom/shortreels/data/repository/SeriesRepository;", "(Lcom/shortreels/data/repository/VideoRepository;Lcom/shortreels/data/repository/SeriesRepository;)V", "_featuredSeries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/shortreels/utils/NetworkResult;", "", "Lcom/shortreels/domain/model/Series;", "_searchQuery", "", "_searchResults", "Lcom/shortreels/presentation/viewmodel/SearchResultState;", "_trendingVideos", "Lcom/shortreels/domain/model/Video;", "featuredSeries", "Lkotlinx/coroutines/flow/StateFlow;", "getFeaturedSeries", "()Lkotlinx/coroutines/flow/StateFlow;", "searchQuery", "getSearchQuery", "searchResults", "getSearchResults", "trendingVideos", "getTrendingVideos", "clearSearch", "", "loadFeaturedSeries", "loadTrending", "onSearchQueryChanged", "query", "performSearch", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ExploreViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.repository.VideoRepository videoRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.repository.SeriesRepository seriesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Video>>> _trendingVideos = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Video>>> trendingVideos = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Series>>> _featuredSeries = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Series>>> featuredSeries = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.shortreels.presentation.viewmodel.SearchResultState> _searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.shortreels.presentation.viewmodel.SearchResultState> searchResults = null;
    
    @javax.inject.Inject()
    public ExploreViewModel(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.VideoRepository videoRepository, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.SeriesRepository seriesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Video>>> getTrendingVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Series>>> getFeaturedSeries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.shortreels.presentation.viewmodel.SearchResultState> getSearchResults() {
        return null;
    }
    
    public final void loadTrending() {
    }
    
    private final void loadFeaturedSeries() {
    }
    
    public final void onSearchQueryChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final java.lang.Object performSearch(java.lang.String query, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void clearSearch() {
    }
}