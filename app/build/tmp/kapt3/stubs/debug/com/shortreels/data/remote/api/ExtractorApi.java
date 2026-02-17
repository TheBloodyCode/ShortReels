package com.shortreels.data.remote.api;

import com.shortreels.data.remote.dto.ExtractorStreamResponse;
import com.shortreels.data.remote.dto.ExtractorVideoDto;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\tJ8\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/shortreels/data/remote/api/ExtractorApi;", "", "getStream", "Lretrofit2/Response;", "Lcom/shortreels/data/remote/dto/ExtractorStreamResponse;", "videoUrl", "", "quality", "profile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/shortreels/data/remote/dto/ExtractorVideoDto;", "query", "page", "", "pageSize", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ExtractorApi {
    
    @retrofit2.http.GET(value = "stream")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStream(@retrofit2.http.Query(value = "url")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl, @retrofit2.http.Query(value = "quality")
    @org.jetbrains.annotations.NotNull()
    java.lang.String quality, @retrofit2.http.Query(value = "profile")
    @org.jetbrains.annotations.NotNull()
    java.lang.String profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.dto.ExtractorStreamResponse>> $completion);
    
    @retrofit2.http.GET(value = "search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object search(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "page_size")
    int pageSize, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.shortreels.data.remote.dto.ExtractorVideoDto>>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}