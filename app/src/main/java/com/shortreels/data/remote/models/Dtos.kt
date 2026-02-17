package com.shortreels.data.remote.models

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Objects (DTOs) - Remote API models
 * These represent the raw JSON structure from the API.
 * Mappers convert these to domain models.
 */

// ===== Video =====
data class VideoDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("video_url") val videoUrl: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("hls_url") val hlsUrl: String?,
    @SerializedName("duration") val duration: Long,
    @SerializedName("episode") val episode: Int,
    @SerializedName("season") val season: Int = 1,
    @SerializedName("series_id") val seriesId: String,
    @SerializedName("series_title") val seriesTitle: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("author") val author: AuthorDto,
    @SerializedName("stats") val stats: VideoStatsDto,
    @SerializedName("monetization") val monetization: MonetizationDto,
    @SerializedName("created_at") val createdAt: Long,
    @SerializedName("updated_at") val updatedAt: Long,
    @SerializedName("is_liked") val isLiked: Boolean = false,
    @SerializedName("is_bookmarked") val isBookmarked: Boolean = false
)

data class VideoStatsDto(
    @SerializedName("views") val views: Long,
    @SerializedName("likes") val likes: Long,
    @SerializedName("comments") val comments: Long,
    @SerializedName("shares") val shares: Long,
    @SerializedName("bookmarks") val bookmarks: Long
)

data class MonetizationDto(
    @SerializedName("is_premium") val isPremium: Boolean,
    @SerializedName("is_locked") val isLocked: Boolean,
    @SerializedName("coins_required") val coinsRequired: Int = 0,
    @SerializedName("unlock_type") val unlockType: String = "FREE"
)

// ===== Series =====
data class SeriesDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("banner_url") val bannerUrl: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("total_episodes") val totalEpisodes: Int,
    @SerializedName("author") val author: AuthorDto,
    @SerializedName("rating") val rating: Float,
    @SerializedName("review_count") val reviewCount: Int,
    @SerializedName("monetization") val monetization: MonetizationDto,
    @SerializedName("status") val status: String,
    @SerializedName("release_schedule") val releaseSchedule: String,
    @SerializedName("created_at") val createdAt: Long,
    @SerializedName("is_following") val isFollowing: Boolean = false
)

// ===== Author =====
data class AuthorDto(
    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String,
    @SerializedName("display_name") val displayName: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("bio") val bio: String = "",
    @SerializedName("follower_count") val followerCount: Long,
    @SerializedName("following_count") val followingCount: Long,
    @SerializedName("is_verified") val isVerified: Boolean,
    @SerializedName("is_following") val isFollowing: Boolean = false
)

// ===== User =====
data class UserDto(
    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String,
    @SerializedName("display_name") val displayName: String,
    @SerializedName("email") val email: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("bio") val bio: String = "",
    @SerializedName("follower_count") val followerCount: Long = 0,
    @SerializedName("following_count") val followingCount: Long = 0,
    @SerializedName("is_verified") val isVerified: Boolean = false,
    @SerializedName("subscription_plan") val subscriptionPlan: String = "FREE",
    @SerializedName("coins") val coins: Int = 0,
    @SerializedName("created_at") val createdAt: Long = 0
)

// ===== Comment =====
data class CommentDto(
    @SerializedName("id") val id: String,
    @SerializedName("video_id") val videoId: String,
    @SerializedName("author") val author: AuthorDto,
    @SerializedName("text") val text: String,
    @SerializedName("likes") val likes: Long,
    @SerializedName("reply_count") val replyCount: Int,
    @SerializedName("replies") val replies: List<CommentDto> = emptyList(),
    @SerializedName("created_at") val createdAt: Long,
    @SerializedName("is_liked") val isLiked: Boolean = false,
    @SerializedName("is_pinned") val isPinned: Boolean = false
)

// ===== Search =====
data class SearchResultDto(
    @SerializedName("videos") val videos: List<VideoDto>,
    @SerializedName("series") val series: List<SeriesDto>,
    @SerializedName("authors") val authors: List<AuthorDto>,
    @SerializedName("total_results") val totalResults: Int
)

// ===== Category =====
data class CategoryDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("icon_url") val iconUrl: String,
    @SerializedName("color") val color: String,
    @SerializedName("series_count") val seriesCount: Int
)

// ===== Notification =====
data class NotificationDto(
    @SerializedName("id") val id: String,
    @SerializedName("type") val type: String,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("action_id") val actionId: String?,
    @SerializedName("created_at") val createdAt: Long,
    @SerializedName("is_read") val isRead: Boolean = false
)

// ===== Subscription =====
data class SubscriptionPlanDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("duration_days") val durationDays: Int,
    @SerializedName("features") val features: List<String>,
    @SerializedName("is_popular") val isPopular: Boolean = false
)

data class SubscriptionResponse(
    @SerializedName("subscription_id") val subscriptionId: String,
    @SerializedName("plan") val plan: String,
    @SerializedName("expires_at") val expiresAt: Long,
    @SerializedName("coins_granted") val coinsGranted: Int = 0
)

// ===== Requests =====
data class LoginRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("device_id") val deviceId: String
)

data class RegisterRequest(
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("device_id") val deviceId: String
)

data class SocialAuthRequest(
    @SerializedName("token") val token: String,
    @SerializedName("provider") val provider: String,
    @SerializedName("device_id") val deviceId: String
)

data class RefreshTokenRequest(
    @SerializedName("refresh_token") val refreshToken: String
)

data class AuthResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("expires_in") val expiresIn: Long,
    @SerializedName("user") val user: UserDto
)

data class PostCommentRequest(
    @SerializedName("text") val text: String,
    @SerializedName("reply_to_id") val replyToId: String? = null
)

data class ViewRequest(
    @SerializedName("duration_watched") val durationWatched: Long,
    @SerializedName("completed") val completed: Boolean,
    @SerializedName("device_id") val deviceId: String
)

data class UpdateProfileRequest(
    @SerializedName("display_name") val displayName: String?,
    @SerializedName("bio") val bio: String?,
    @SerializedName("avatar_url") val avatarUrl: String?
)

data class SubscribeRequest(
    @SerializedName("plan_id") val planId: String,
    @SerializedName("payment_method") val paymentMethod: String,
    @SerializedName("payment_token") val paymentToken: String
)

data class LikeResponse(
    @SerializedName("liked") val liked: Boolean,
    @SerializedName("like_count") val likeCount: Long
)
