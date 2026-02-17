package com.shortreels.data.repository;

import com.shortreels.data.local.dao.*;
import com.shortreels.data.local.entities.*;
import com.shortreels.data.remote.api.ShortReelsApiService;
import com.shortreels.data.remote.models.*;
import com.shortreels.domain.model.*;
import com.shortreels.utils.NetworkResult;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * SeriesRepository
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nJ$\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/shortreels/data/repository/SeriesRepository;", "", "apiService", "Lcom/shortreels/data/remote/api/ShortReelsApiService;", "seriesDao", "Lcom/shortreels/data/local/dao/SeriesDao;", "tokenManager", "Lcom/shortreels/data/repository/TokenManager;", "(Lcom/shortreels/data/remote/api/ShortReelsApiService;Lcom/shortreels/data/local/dao/SeriesDao;Lcom/shortreels/data/repository/TokenManager;)V", "getFeaturedSeries", "Lkotlinx/coroutines/flow/Flow;", "Lcom/shortreels/utils/NetworkResult;", "", "Lcom/shortreels/domain/model/Series;", "getFollowedSeries", "getSeries", "genre", "", "getSeriesById", "seriesId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleFollow", "", "isFollowing", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class SeriesRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.remote.api.ShortReelsApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.local.dao.SeriesDao seriesDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.repository.TokenManager tokenManager = null;
    
    @javax.inject.Inject()
    public SeriesRepository(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.ShortReelsApiService apiService, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.dao.SeriesDao seriesDao, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.TokenManager tokenManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Series>>> getSeries(@org.jetbrains.annotations.Nullable()
    java.lang.String genre) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSeriesById(@org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.utils.NetworkResult<com.shortreels.domain.model.Series>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object toggleFollow(@org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, boolean isFollowing, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.utils.NetworkResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.domain.model.Series>> getFollowedSeries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.shortreels.utils.NetworkResult<java.util.List<com.shortreels.domain.model.Series>>> getFeaturedSeries() {
        return null;
    }
}