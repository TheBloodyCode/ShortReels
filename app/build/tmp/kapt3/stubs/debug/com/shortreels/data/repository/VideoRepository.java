package com.shortreels.data.repository;

import com.shortreels.data.local.dao.*;
import com.shortreels.data.local.entities.*;
import com.shortreels.data.remote.api.ExtractorApi;
import com.shortreels.data.remote.api.ShortReelsApiService;
import com.shortreels.data.remote.dto.ExtractorVideoDto;
import com.shortreels.data.remote.models.*;
import com.shortreels.domain.model.*;
import com.shortreels.utils.NetworkResult;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * VideoRepository
 * Implements Repository pattern (offline-first):
 * 1. Emit local cached data immediately
 * 2. Fetch from network in background
 * 3. Update local cache and re-emit
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ$\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00100\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00100\fJ\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0018\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0016J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u001e\u0010 \u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/shortreels/data/repository/VideoRepository;", "", "apiService", "Lcom/shortreels/data/remote/api/ShortReelsApiService;", "extractorApi", "Lcom/shortreels/data/remote/api/ExtractorApi;", "videoDao", "Lcom/shortreels/data/local/dao/VideoDao;", "tokenManager", "Lcom/shortreels/data/repository/TokenManager;", "(Lcom/shortreels/data/remote/api/ShortReelsApiService;Lcom/shortreels/data/remote/api/ExtractorApi;Lcom/shortreels/data/local/dao/VideoDao;Lcom/shortreels/data/repository/TokenManager;)V", "getBookmarkedVideos", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/shortreels/domain/model/Video;", "getFeedVideos", "Lcom/shortreels/utils/NetworkResult;", "genre", "", "getTrendingVideos", "getVideoById", "videoId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchVideos", "query", "toggleBookmark", "", "isBookmarked", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleLike", "isLiked", "updateWatchProgress", "progress", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class VideoRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.remote.api.ShortReelsApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.remote.api.ExtractorApi extractorApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.local.dao.VideoDao videoDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.repository.TokenManager tokenManager = null;
    
    @javax.inject.Inject()
    public VideoRepository(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.ShortReelsApiService apiService, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.ExtractorApi extractorApi, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.dao.VideoDao videoDao, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.TokenManager tokenManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Video>>> getFeedVideos(@org.jetbrains.annotations.Nullable()
    java.lang.String genre) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Video>>> getTrendingVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVideoById(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.utils.NetworkResult<com.shortreels.domain.model.Video>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object toggleLike(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, boolean isLiked, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.utils.NetworkResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object toggleBookmark(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, boolean isBookmarked, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.utils.NetworkResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateWatchProgress(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, float progress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.domain.model.Video>> getBookmarkedVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchVideos(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.shortreels.domain.model.Video>> $completion) {
        return null;
    }
}