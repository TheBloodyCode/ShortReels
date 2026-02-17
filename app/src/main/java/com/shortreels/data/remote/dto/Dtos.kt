package com.shortreels.data.remote.dto

import com.google.gson.annotations.SerializedName

// ===== Auth DTOs =====
data class LoginRequest(
    val email: String,
    val password: String,
    @SerializedName("device_token") val deviceToken: String? = null
)

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
    @SerializedName("display_name") val displayName: String
)

data class RefreshTokenRequest(
    @SerializedName("refresh_token") val refreshToken: String
)

data class AuthResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    val user: UserDto
)

// ===== User DTOs =====
data class UserDto(
    val id: String,
    val username: String,
    @SerializedName("display_name") val displayName: String,
    val email: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    val bio: String,
    val verified: Boolean,
    @SerializedName("follower_count") val followerCount: Long,
    @SerializedName("following_count") val followingCount: Long,
    @SerializedName("video_count") val videoCount: Long,
    @SerializedName("like_count") val likeCount: Long,
    @SerializedName("is_premium") val isPremium: Boolean,
    @SerializedName("coin_balance") val coinBalance: Int,
    @SerializedName("is_following") val isFollowing: Boolean = false,
    @SerializedName("created_at") val createdAt: String
)

data class UpdateProfileRequest(
    @SerializedName("display_name") val displayName: String?,
    val bio: String?,
    @SerializedName("avatar_url") val avatarUrl: String?
)

// ===== Video DTOs =====
data class VideoDto(
    val id: String,
    val title: String,
    val description: String,
    @SerializedName("video_url") val videoUrl: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    val duration: Long,
    val episode: Int,
    @SerializedName("series_id") val seriesId: String,
    @SerializedName("series_title") val seriesTitle: String,
    val genre: String,
    val tags: List<String>,
    @SerializedName("like_count") val likeCount: Long,
    @SerializedName("comment_count") val commentCount: Long,
    @SerializedName("share_count") val shareCount: Long,
    @SerializedName("view_count") val viewCount: Long,
    @SerializedName("is_premium") val isPremium: Boolean,
    @SerializedName("is_locked") val isLocked: Boolean,
    @SerializedName("is_liked") val isLiked: Boolean = false,
    @SerializedName("is_saved") val isSaved: Boolean = false,
    val author: AuthorDto,
    @SerializedName("created_at") val createdAt: String
)

data class AuthorDto(
    val id: String,
    val username: String,
    @SerializedName("display_name") val displayName: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    val verified: Boolean,
    @SerializedName("follower_count") val followerCount: Long,
    @SerializedName("is_following") val isFollowing: Boolean = false
)

data class VideoFeedResponse(
    val videos: List<VideoDto>,
    val page: Int,
    @SerializedName("has_more") val hasMore: Boolean,
    val total: Long
)

data class LikeResponse(
    val liked: Boolean,
    val count: Long
)

data class ViewRequest(
    @SerializedName("watch_duration") val watchDuration: Long,
    val completed: Boolean
)

// ===== Series DTOs =====
data class SeriesDto(
    val id: String,
    val title: String,
    val description: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("banner_url") val bannerUrl: String,
    val genre: String,
    @SerializedName("episode_count") val episodeCount: Int,
    val rating: Float,
    @SerializedName("view_count") val viewCount: String,
    val tags: List<String>,
    @SerializedName("is_premium") val isPremium: Boolean,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("is_trending") val isTrending: Boolean,
    val episodes: List<EpisodeDto>? = null
)

data class EpisodeDto(
    val id: String,
    val number: Int,
    val title: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("video_url") val videoUrl: String,
    val duration: Long,
    @SerializedName("is_locked") val isLocked: Boolean,
    @SerializedName("watch_progress") val watchProgress: Float = 0f
)

data class SeriesListResponse(
    val series: List<SeriesDto>,
    val page: Int,
    @SerializedName("has_more") val hasMore: Boolean
)

data class EpisodeListResponse(
    val episodes: List<EpisodeDto>
)

// ===== Comment DTOs =====
data class CommentDto(
    val id: String,
    val text: String,
    val author: AuthorDto,
    @SerializedName("like_count") val likeCount: Long,
    @SerializedName("is_liked") val isLiked: Boolean,
    @SerializedName("reply_count") val replyCount: Int,
    val replies: List<CommentDto>? = null,
    @SerializedName("is_pinned") val isPinned: Boolean = false,
    @SerializedName("created_at") val createdAt: String
)

data class PostCommentRequest(
    val text: String
)

data class CommentsResponse(
    val comments: List<CommentDto>,
    val page: Int,
    @SerializedName("has_more") val hasMore: Boolean,
    val total: Long
)

// ===== Search DTOs =====
data class SearchResponse(
    val videos: List<VideoDto>,
    val series: List<SeriesDto>,
    val authors: List<AuthorDto>
)

data class GenresResponse(
    val genres: List<GenreDto>
)

data class GenreDto(
    val id: String,
    val name: String,
    @SerializedName("icon_url") val iconUrl: String,
    val color: String,
    @SerializedName("video_count") val videoCount: Long
)

// ===== Premium DTOs =====
data class PremiumPlansResponse(
    val plans: List<PremiumPlanDto>
)

data class PremiumPlanDto(
    val id: String,
    val name: String,
    val price: String,
    val period: String,
    val features: List<String>,
    @SerializedName("is_popular") val isPopular: Boolean,
    @SerializedName("original_price") val originalPrice: String?,
    @SerializedName("coins_included") val coinsIncluded: Int = 0
)

data class SubscribeRequest(
    @SerializedName("plan_id") val planId: String,
    @SerializedName("payment_token") val paymentToken: String
)

data class SubscribeResponse(
    val success: Boolean,
    val message: String,
    @SerializedName("expires_at") val expiresAt: String?
)

data class CoinPackagesResponse(
    val packages: List<CoinPackageDto>
)

data class CoinPackageDto(
    val id: String,
    val coins: Int,
    val price: String,
    @SerializedName("bonus_coins") val bonusCoins: Int,
    @SerializedName("is_popular") val isPopular: Boolean,
    @SerializedName("discount_percent") val discountPercent: Int = 0
)

data class PurchaseCoinsRequest(
    @SerializedName("package_id") val packageId: String,
    @SerializedName("payment_token") val paymentToken: String
)

data class PurchaseResponse(
    val success: Boolean,
    @SerializedName("new_balance") val newBalance: Int
)

// ===== Notification DTOs =====
data class NotificationsResponse(
    val notifications: List<NotificationDto>,
    val page: Int,
    @SerializedName("has_more") val hasMore: Boolean,
    @SerializedName("unread_count") val unreadCount: Int
)

data class NotificationDto(
    val id: String,
    val type: String,
    val title: String,
    val body: String,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("target_id") val targetId: String?,
    @SerializedName("is_read") val isRead: Boolean,
    @SerializedName("created_at") val createdAt: String
)
