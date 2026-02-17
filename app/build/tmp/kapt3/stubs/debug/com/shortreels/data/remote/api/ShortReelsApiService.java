package com.shortreels.data.remote.api;

import com.shortreels.data.remote.models.*;
import retrofit2.Response;
import retrofit2.http.*;

/**
 * Retrofit API Service Interface
 * All network calls are defined here, using suspend functions for coroutine support.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ4\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00110\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0018J>\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00110\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001b\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0018J@\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00040\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001b\u001a\u00020\u00142\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0007H\u00a7@\u00a2\u0006\u0002\u0010!J4\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00110\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J$\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010&J4\u0010\'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\u001b\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J*\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00040\u00032\b\b\u0001\u0010)\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010&JJ\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\u00040\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001b\u001a\u00020\u00142\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010+\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010,J$\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010&J*\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010&J \u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00110\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0018J*\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00040\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u00102J$\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010&J$\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010&J.\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ$\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040\u00032\b\b\u0001\u0010:\u001a\u00020;H\u00a7@\u00a2\u0006\u0002\u0010<J$\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040\u00032\b\b\u0001\u0010:\u001a\u00020>H\u00a7@\u00a2\u0006\u0002\u0010?J$\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010&J.\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010B\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ8\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010:\u001a\u00020DH\u00a7@\u00a2\u0006\u0002\u0010EJ.\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010:\u001a\u00020GH\u00a7@\u00a2\u0006\u0002\u0010HJ$\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040\u00032\b\b\u0001\u0010:\u001a\u00020JH\u00a7@\u00a2\u0006\u0002\u0010KJ$\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040\u00032\b\b\u0001\u0010:\u001a\u00020MH\u00a7@\u00a2\u0006\u0002\u0010NJ.\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJB\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\u00040\u00032\b\b\u0001\u0010)\u001a\u00020\u00072\b\b\u0003\u0010R\u001a\u00020\u00072\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001b\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010SJ.\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010:\u001a\u00020WH\u00a7@\u00a2\u0006\u0002\u0010XJ.\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010:\u001a\u00020]H\u00a7@\u00a2\u0006\u0002\u0010^JD\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010`\u001a\u00020a2\b\b\u0001\u0010b\u001a\u00020c2\n\b\u0001\u0010d\u001a\u0004\u0018\u00010cH\u00a7@\u00a2\u0006\u0002\u0010e\u00a8\u0006f"}, d2 = {"Lcom/shortreels/data/remote/api/ShortReelsApiService;", "", "addBookmark", "Lretrofit2/Response;", "Lcom/shortreels/data/remote/api/ApiResponse;", "", "videoId", "", "token", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "commentId", "followSeries", "seriesId", "followUser", "userId", "getBookmarks", "", "Lcom/shortreels/data/remote/models/VideoDto;", "page", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "Lcom/shortreels/data/remote/models/CategoryDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComments", "Lcom/shortreels/data/remote/models/CommentDto;", "limit", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeaturedSeries", "Lcom/shortreels/data/remote/models/SeriesDto;", "getFeed", "genre", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotifications", "Lcom/shortreels/data/remote/models/NotificationDto;", "getProfile", "Lcom/shortreels/data/remote/models/UserDto;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommended", "getSearchSuggestions", "query", "getSeries", "sort", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSeriesById", "getSeriesEpisodes", "getSubscriptionPlans", "Lcom/shortreels/data/remote/models/SubscriptionPlanDto;", "getTrendingVideos", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserById", "getVideoById", "likeComment", "likeVideo", "Lcom/shortreels/data/remote/models/LikeResponse;", "login", "Lcom/shortreels/data/remote/models/AuthResponse;", "body", "Lcom/shortreels/data/remote/models/LoginRequest;", "(Lcom/shortreels/data/remote/models/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginWithGoogle", "Lcom/shortreels/data/remote/models/SocialAuthRequest;", "(Lcom/shortreels/data/remote/models/SocialAuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "markNotificationRead", "notificationId", "postComment", "Lcom/shortreels/data/remote/models/PostCommentRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/shortreels/data/remote/models/PostCommentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordView", "Lcom/shortreels/data/remote/models/ViewRequest;", "(Ljava/lang/String;Lcom/shortreels/data/remote/models/ViewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lcom/shortreels/data/remote/models/RefreshTokenRequest;", "(Lcom/shortreels/data/remote/models/RefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/shortreels/data/remote/models/RegisterRequest;", "(Lcom/shortreels/data/remote/models/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBookmark", "search", "Lcom/shortreels/data/remote/models/SearchResultDto;", "type", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shareVideo", "subscribe", "Lcom/shortreels/data/remote/models/SubscriptionResponse;", "Lcom/shortreels/data/remote/models/SubscribeRequest;", "(Ljava/lang/String;Lcom/shortreels/data/remote/models/SubscribeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unfollowSeries", "unfollowUser", "unlikeVideo", "updateProfile", "Lcom/shortreels/data/remote/models/UpdateProfileRequest;", "(Ljava/lang/String;Lcom/shortreels/data/remote/models/UpdateProfileRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadVideo", "metadata", "Lokhttp3/RequestBody;", "video", "Lokhttp3/MultipartBody$Part;", "thumbnail", "(Ljava/lang/String;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ShortReelsApiService {
    
    @retrofit2.http.GET(value = "videos/feed")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFeed(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "genre")
    @org.jetbrains.annotations.Nullable()
    java.lang.String genre, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.VideoDto>>>> $completion);
    
    @retrofit2.http.GET(value = "videos/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVideoById(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.VideoDto>>> $completion);
    
    @retrofit2.http.GET(value = "videos/trending")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTrendingVideos(@retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.VideoDto>>>> $completion);
    
    @retrofit2.http.GET(value = "videos/recommended")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecommended(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.VideoDto>>>> $completion);
    
    @retrofit2.http.POST(value = "videos/{id}/like")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object likeVideo(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.LikeResponse>>> $completion);
    
    @retrofit2.http.DELETE(value = "videos/{id}/like")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object unlikeVideo(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.LikeResponse>>> $completion);
    
    @retrofit2.http.POST(value = "videos/{id}/view")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object recordView(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.ViewRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.POST(value = "videos/{id}/share")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object shareVideo(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "series")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSeries(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "genre")
    @org.jetbrains.annotations.Nullable()
    java.lang.String genre, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.SeriesDto>>>> $completion);
    
    @retrofit2.http.GET(value = "series/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSeriesById(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.SeriesDto>>> $completion);
    
    @retrofit2.http.GET(value = "series/{id}/episodes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSeriesEpisodes(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.VideoDto>>>> $completion);
    
    @retrofit2.http.POST(value = "series/{id}/follow")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object followSeries(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "series/{id}/follow")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object unfollowSeries(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "series/featured")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFeaturedSeries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.SeriesDto>>>> $completion);
    
    @retrofit2.http.GET(value = "videos/{id}/comments")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComments(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.CommentDto>>>> $completion);
    
    @retrofit2.http.POST(value = "videos/{id}/comments")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object postComment(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.PostCommentRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.CommentDto>>> $completion);
    
    @retrofit2.http.POST(value = "comments/{id}/like")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object likeComment(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String commentId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "comments/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteComment(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String commentId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object search(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "type")
    @org.jetbrains.annotations.NotNull()
    java.lang.String type, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.SearchResultDto>>> $completion);
    
    @retrofit2.http.GET(value = "search/suggestions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSearchSuggestions(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<java.lang.String>>>> $completion);
    
    @retrofit2.http.POST(value = "auth/register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.RegisterRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.AuthResponse>>> $completion);
    
    @retrofit2.http.POST(value = "auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.LoginRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.AuthResponse>>> $completion);
    
    @retrofit2.http.POST(value = "auth/logout")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object logout(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.POST(value = "auth/refresh")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshToken(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.RefreshTokenRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.AuthResponse>>> $completion);
    
    @retrofit2.http.POST(value = "auth/google")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object loginWithGoogle(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.SocialAuthRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.AuthResponse>>> $completion);
    
    @retrofit2.http.GET(value = "users/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProfile(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.UserDto>>> $completion);
    
    @retrofit2.http.PUT(value = "users/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateProfile(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.UpdateProfileRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.UserDto>>> $completion);
    
    @retrofit2.http.GET(value = "users/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserById(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.UserDto>>> $completion);
    
    @retrofit2.http.POST(value = "users/{id}/follow")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object followUser(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "users/{id}/follow")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object unfollowUser(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "users/me/bookmarks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookmarks(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.VideoDto>>>> $completion);
    
    @retrofit2.http.POST(value = "users/me/bookmarks/{videoId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addBookmark(@retrofit2.http.Path(value = "videoId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "users/me/bookmarks/{videoId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeBookmark(@retrofit2.http.Path(value = "videoId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "subscription/plans")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSubscriptionPlans(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.SubscriptionPlanDto>>>> $completion);
    
    @retrofit2.http.POST(value = "subscription/subscribe")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object subscribe(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.SubscribeRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.SubscriptionResponse>>> $completion);
    
    @retrofit2.http.Multipart()
    @retrofit2.http.POST(value = "videos/upload")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadVideo(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Part(value = "metadata")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody metadata, @retrofit2.http.Part()
    @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part video, @retrofit2.http.Part()
    @org.jetbrains.annotations.Nullable()
    okhttp3.MultipartBody.Part thumbnail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<com.shortreels.data.remote.models.VideoDto>>> $completion);
    
    @retrofit2.http.GET(value = "categories")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.CategoryDto>>>> $completion);
    
    @retrofit2.http.GET(value = "notifications")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNotifications(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<java.util.List<com.shortreels.data.remote.models.NotificationDto>>>> $completion);
    
    @retrofit2.http.POST(value = "notifications/{id}/read")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markNotificationRead(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String notificationId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.shortreels.data.remote.api.ApiResponse<kotlin.Unit>>> $completion);
    
    /**
     * Retrofit API Service Interface
     * All network calls are defined here, using suspend functions for coroutine support.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}