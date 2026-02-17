package com.shortreels.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class VideoEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val videoUrl: String,
    val thumbnailUrl: String,
    val hlsUrl: String?,
    val duration: Long,
    val episode: Int,
    val season: Int = 1,
    val seriesId: String,
    val seriesTitle: String,
    val genre: String,
    val tags: String,
    val likeCount: Long,
    val commentCount: Long,
    val shareCount: Long,
    val viewCount: Long,
    val bookmarkCount: Long = 0,
    val isPremium: Boolean,
    val isLocked: Boolean,
    val coinsRequired: Int = 0,
    val unlockType: String = "FREE",
    val isLiked: Boolean,
    val isBookmarked: Boolean,
    val isDownloaded: Boolean = false,
    val localPath: String? = null,
    val watchProgress: Float = 0f,
    val authorId: String,
    val authorUsername: String,
    val authorDisplayName: String,
    val authorAvatarUrl: String,
    val authorIsVerified: Boolean,
    val authorFollowerCount: Long,
    val createdAt: Long,
    val updatedAt: Long,
    val cachedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "watch_history")
data class WatchHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userId: String,
    val videoId: String,
    val seriesId: String,
    val episodeNumber: Int,
    val watchProgress: Float,
    val durationWatched: Long,
    val completed: Boolean = false,
    val watchedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "saved_videos")
data class SavedVideoEntity(
    @PrimaryKey val videoId: String,
    val savedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val username: String,
    val displayName: String,
    val email: String,
    val avatarUrl: String,
    val bio: String = "",
    val followerCount: Long = 0,
    val followingCount: Long = 0,
    val isVerified: Boolean = false,
    val subscriptionPlan: String = "FREE",
    val coins: Int = 0,
    val createdAt: Long = 0,
    val cachedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "search_history")
data class SearchHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val query: String,
    val searchedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "downloads")
data class DownloadEntity(
    @PrimaryKey val videoId: String,
    val title: String,
    val seriesTitle: String,
    val episodeNumber: Int,
    val thumbnailUrl: String,
    val localPath: String? = null,
    val fileSize: Long,
    val downloadedSize: Long = 0,
    val duration: Long,
    val progress: Int = 0,
    val status: String,
    val createdAt: Long = System.currentTimeMillis(),
    val completedAt: Long = 0
)

@Entity(tableName = "series")
data class SeriesEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val bannerUrl: String,
    val genre: String,
    val tags: String,
    val totalEpisodes: Int,
    val authorId: String,
    val authorUsername: String,
    val authorDisplayName: String,
    val authorAvatarUrl: String,
    val rating: Float,
    val reviewCount: Int,
    val isPremium: Boolean,
    val status: String,
    val releaseSchedule: String,
    val isFollowing: Boolean,
    val createdAt: Long,
    val cachedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "comments")
data class CommentEntity(
    @PrimaryKey val id: String,
    val videoId: String,
    val userId: String,
    val userDisplayName: String,
    val userAvatarUrl: String,
    val content: String,
    val likeCount: Long,
    val isLiked: Boolean,
    val isPinned: Boolean,
    val createdAt: Long
)
