package com.shortreels.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Core domain models for ShortReels
 * These are clean, framework-independent data classes used across layers.
 */

@Parcelize
data class Video(
    val id: String,
    val title: String,
    val description: String,
    val videoUrl: String,
    val thumbnailUrl: String,
    val hlsUrl: String? = null,
    val duration: Long,            // seconds
    val episode: Int,
    val season: Int = 1,
    val seriesId: String,
    val seriesTitle: String,
    val genre: Genre,
    val tags: List<String>,
    val author: Author,
    val stats: VideoStats,
    val monetization: Monetization,
    val createdAt: Long,
    val updatedAt: Long,
    var isLiked: Boolean = false,
    var isBookmarked: Boolean = false,
    var isDownloaded: Boolean = false,
    var watchProgress: Float = 0f   // 0.0 - 1.0
) : Parcelable

@Parcelize
data class Series(
    val id: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val bannerUrl: String,
    val genre: Genre,
    val tags: List<String>,
    val episodes: List<Video>,
    val totalEpisodes: Int,
    val author: Author,
    val rating: Float,
    val reviewCount: Int,
    val monetization: Monetization,
    val status: SeriesStatus,
    val releaseSchedule: String,
    val createdAt: Long,
    var isFollowing: Boolean = false
) : Parcelable

@Parcelize
data class Author(
    val id: String,
    val username: String,
    val displayName: String,
    val avatarUrl: String,
    val bio: String = "",
    val followerCount: Long,
    val followingCount: Long,
    val isVerified: Boolean,
    var isFollowing: Boolean = false
) : Parcelable

@Parcelize
data class User(
    val id: String,
    val username: String,
    val displayName: String,
    val email: String,
    val avatarUrl: String,
    val bio: String = "",
    val followerCount: Long = 0,
    val followingCount: Long = 0,
    val isVerified: Boolean = false,
    val subscriptionPlan: SubscriptionPlan = SubscriptionPlan.FREE,
    val coins: Int = 0,
    val watchHistory: List<String> = emptyList(),
    val likedVideos: List<String> = emptyList(),
    val bookmarks: List<String> = emptyList(),
    val createdAt: Long = 0
) : Parcelable

@Parcelize
data class Comment(
    val id: String,
    val videoId: String,
    val author: Author,
    val text: String,
    val likes: Long,
    val replyCount: Int,
    val replies: List<Comment> = emptyList(),
    val createdAt: Long,
    var isLiked: Boolean = false,
    val isPinned: Boolean = false
) : Parcelable

@Parcelize
data class VideoStats(
    val views: Long,
    val likes: Long,
    val comments: Long,
    val shares: Long,
    val bookmarks: Long
) : Parcelable

@Parcelize
data class Monetization(
    val isPremium: Boolean,
    val isLocked: Boolean,
    val coinsRequired: Int = 0,
    val unlockType: UnlockType = UnlockType.FREE
) : Parcelable

@Parcelize
data class Category(
    val id: String,
    val name: String,
    val iconUrl: String,
    val color: String,
    val seriesCount: Int
) : Parcelable

@Parcelize
data class Notification(
    val id: String,
    val type: NotificationType,
    val title: String,
    val body: String,
    val imageUrl: String?,
    val actionId: String?,
    val createdAt: Long,
    var isRead: Boolean = false
) : Parcelable

// Enums
enum class Genre(val displayName: String) {
    ROMANCE("Romance"),
    THRILLER("Thriller"),
    FANTASY("Fantasía"),
    DRAMA("Drama"),
    COMEDY("Comedia"),
    ACTION("Acción"),
    HORROR("Terror"),
    MYSTERY("Misterio"),
    SUPERNATURAL("Sobrenatural"),
    HISTORICAL("Histórico"),
    ROYAL("Romance Real"),
    CAMPUS("Campus"),
    CEO("CEO Romance"),
    WEREWOLF("Licantropo"),
    VAMPIRE("Vampiro")
}

enum class SeriesStatus {
    ONGOING, COMPLETED, HIATUS, COMING_SOON
}

enum class SubscriptionPlan(val displayName: String, val price: String) {
    FREE("Gratis", "$0"),
    WEEKLY("Semanal", "$1.99/sem"),
    MONTHLY("Mensual", "$6.99/mes"),
    ANNUAL("Anual", "$49.99/año")
}

enum class UnlockType {
    FREE, SUBSCRIPTION, COINS, AD_WATCH
}

enum class NotificationType {
    NEW_EPISODE, FOLLOW, LIKE, COMMENT, SYSTEM, PROMOTION
}
