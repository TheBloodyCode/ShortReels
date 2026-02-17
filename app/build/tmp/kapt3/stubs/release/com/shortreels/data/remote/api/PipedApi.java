package com.shortreels.data.remote.api;

import com.shortreels.data.remote.dto.PipedSearchResult;
import com.shortreels.data.remote.dto.PipedStreamResponse;
import com.shortreels.data.remote.dto.PipedTrendingResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0003\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/shortreels/data/remote/api/PipedApi;", "", "getStream", "Lretrofit2/Response;", "Lcom/shortreels/data/remote/dto/PipedStreamResponse;", "videoId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrending", "", "Lcom/shortreels/data/remote/dto/PipedTrendingResponse;", "region", "search", "Lcom/shortreels/data/remote/dto/PipedSearchResult;", "query", "filter", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface PipedApi {
    
    @retrofit2.http.GET(value = "trending")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTrending(@retrofit2.http.Query(value = "region")
    @org.jetbrains.annotations.NotNull()
    java.lang.String region, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.shortreels.data.remote.dto.PipedTrendingResponse>>> $completion);
    
    @retrofit2.http.GET(value = "search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object search(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "filter")
    @org.jetbrains.annotations.NotNull()
    java.lang.String filter, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.dto.PipedSearchResult>> $completion);
    
    @retrofit2.http.GET(value = "streams/{videoId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStream(@retrofit2.http.Path(value = "videoId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.dto.PipedStreamResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}