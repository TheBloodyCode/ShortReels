package com.shortreels.data.remote.api

import com.shortreels.data.remote.models.*
import retrofit2.Response
import retrofit2.http.*

/**
 * Retrofit API Service Interface
 * All network calls are defined here, using suspend functions for coroutine support.
 */
interface ShortReelsApiService {

    // ===== Videos =====

    @GET("videos/feed")
    suspend fun getFeed(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("genre") genre: String? = null
    ): Response<ApiResponse<List<VideoDto>>>

    @GET("videos/{id}")
    suspend fun getVideoById(
        @Path("id") videoId: String
    ): Response<ApiResponse<VideoDto>>

    @GET("videos/trending")
    suspend fun getTrendingVideos(
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<VideoDto>>>

    @GET("videos/recommended")
    suspend fun getRecommended(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<VideoDto>>>

    @POST("videos/{id}/like")
    suspend fun likeVideo(
        @Path("id") videoId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<LikeResponse>>

    @DELETE("videos/{id}/like")
    suspend fun unlikeVideo(
        @Path("id") videoId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<LikeResponse>>

    @POST("videos/{id}/view")
    suspend fun recordView(
        @Path("id") videoId: String,
        @Body body: ViewRequest
    ): Response<ApiResponse<Unit>>

    @POST("videos/{id}/share")
    suspend fun shareVideo(
        @Path("id") videoId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    // ===== Series =====

    @GET("series")
    suspend fun getSeries(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("genre") genre: String? = null,
        @Query("sort") sort: String = "trending"
    ): Response<ApiResponse<List<SeriesDto>>>

    @GET("series/{id}")
    suspend fun getSeriesById(
        @Path("id") seriesId: String
    ): Response<ApiResponse<SeriesDto>>

    @GET("series/{id}/episodes")
    suspend fun getSeriesEpisodes(
        @Path("id") seriesId: String
    ): Response<ApiResponse<List<VideoDto>>>

    @POST("series/{id}/follow")
    suspend fun followSeries(
        @Path("id") seriesId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    @DELETE("series/{id}/follow")
    suspend fun unfollowSeries(
        @Path("id") seriesId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    @GET("series/featured")
    suspend fun getFeaturedSeries(): Response<ApiResponse<List<SeriesDto>>>

    // ===== Comments =====

    @GET("videos/{id}/comments")
    suspend fun getComments(
        @Path("id") videoId: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 30
    ): Response<ApiResponse<List<CommentDto>>>

    @POST("videos/{id}/comments")
    suspend fun postComment(
        @Path("id") videoId: String,
        @Header("Authorization") token: String,
        @Body body: PostCommentRequest
    ): Response<ApiResponse<CommentDto>>

    @POST("comments/{id}/like")
    suspend fun likeComment(
        @Path("id") commentId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    @DELETE("comments/{id}")
    suspend fun deleteComment(
        @Path("id") commentId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    // ===== Search =====

    @GET("search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String = "all",
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 30
    ): Response<ApiResponse<SearchResultDto>>

    @GET("search/suggestions")
    suspend fun getSearchSuggestions(
        @Query("q") query: String
    ): Response<ApiResponse<List<String>>>

    // ===== Auth =====

    @POST("auth/register")
    suspend fun register(
        @Body body: RegisterRequest
    ): Response<ApiResponse<AuthResponse>>

    @POST("auth/login")
    suspend fun login(
        @Body body: LoginRequest
    ): Response<ApiResponse<AuthResponse>>

    @POST("auth/logout")
    suspend fun logout(
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    @POST("auth/refresh")
    suspend fun refreshToken(
        @Body body: RefreshTokenRequest
    ): Response<ApiResponse<AuthResponse>>

    @POST("auth/google")
    suspend fun loginWithGoogle(
        @Body body: SocialAuthRequest
    ): Response<ApiResponse<AuthResponse>>

    // ===== User =====

    @GET("users/me")
    suspend fun getProfile(
        @Header("Authorization") token: String
    ): Response<ApiResponse<UserDto>>

    @PUT("users/me")
    suspend fun updateProfile(
        @Header("Authorization") token: String,
        @Body body: UpdateProfileRequest
    ): Response<ApiResponse<UserDto>>

    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") userId: String
    ): Response<ApiResponse<UserDto>>

    @POST("users/{id}/follow")
    suspend fun followUser(
        @Path("id") userId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    @DELETE("users/{id}/follow")
    suspend fun unfollowUser(
        @Path("id") userId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    @GET("users/me/bookmarks")
    suspend fun getBookmarks(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 1
    ): Response<ApiResponse<List<VideoDto>>>

    @POST("users/me/bookmarks/{videoId}")
    suspend fun addBookmark(
        @Path("videoId") videoId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    @DELETE("users/me/bookmarks/{videoId}")
    suspend fun removeBookmark(
        @Path("videoId") videoId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>

    // ===== Subscription =====

    @GET("subscription/plans")
    suspend fun getSubscriptionPlans(): Response<ApiResponse<List<SubscriptionPlanDto>>>

    @POST("subscription/subscribe")
    suspend fun subscribe(
        @Header("Authorization") token: String,
        @Body body: SubscribeRequest
    ): Response<ApiResponse<SubscriptionResponse>>

    // ===== Upload =====

    @Multipart
    @POST("videos/upload")
    suspend fun uploadVideo(
        @Header("Authorization") token: String,
        @Part("metadata") metadata: okhttp3.RequestBody,
        @Part video: okhttp3.MultipartBody.Part,
        @Part thumbnail: okhttp3.MultipartBody.Part?
    ): Response<ApiResponse<VideoDto>>

    // ===== Categories =====

    @GET("categories")
    suspend fun getCategories(): Response<ApiResponse<List<CategoryDto>>>

    // ===== Notifications =====

    @GET("notifications")
    suspend fun getNotifications(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 1
    ): Response<ApiResponse<List<NotificationDto>>>

    @POST("notifications/{id}/read")
    suspend fun markNotificationRead(
        @Path("id") notificationId: String,
        @Header("Authorization") token: String
    ): Response<ApiResponse<Unit>>
}

// ===== Generic API Response wrapper =====
data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val message: String?,
    val error: String?,
    val pagination: Pagination?
)

data class Pagination(
    val page: Int,
    val limit: Int,
    val total: Long,
    val totalPages: Int,
    val hasNext: Boolean,
    val hasPrev: Boolean
)
