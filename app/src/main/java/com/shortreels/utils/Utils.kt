package com.shortreels.utils

import android.util.Log

/**
 * NetworkResult - Sealed class to represent network operation states.
 * Used across ViewModels to propagate UI state cleanly.
 */
sealed class NetworkResult<out T> {
    object Loading : NetworkResult<Nothing>()
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String, val code: Int? = null) : NetworkResult<Nothing>()

    val isLoading get() = this is Loading
    val isSuccess get() = this is Success
    val isError get() = this is Error

    fun getOrNull(): T? = if (this is Success) data else null
    fun errorMessage(): String? = if (this is Error) message else null
}



/**
 * Extensions and utility functions
 */
object Extensions {

    fun Long.toFormattedCount(): String {
        return when {
            this >= 1_000_000_000 -> String.format("%.1fB", this / 1_000_000_000.0)
            this >= 1_000_000 -> String.format("%.1fM", this / 1_000_000.0)
            this >= 1_000 -> String.format("%.1fK", this / 1_000.0)
            else -> toString()
        }
    }

    fun Long.toTimestamp(): String {
        val seconds = this % 60
        val minutes = (this / 60) % 60
        val hours = this / 3600
        return if (hours > 0) {
            String.format("%d:%02d:%02d", hours, minutes, seconds)
        } else {
            String.format("%d:%02d", minutes, seconds)
        }
    }

    fun Long.toRelativeTime(): String {
        val now = System.currentTimeMillis()
        val diff = now - (this * 1000)
        return when {
            diff < 60_000 -> "Ahora"
            diff < 3_600_000 -> "${diff / 60_000}m"
            diff < 86_400_000 -> "${diff / 3_600_000}h"
            diff < 604_800_000 -> "${diff / 86_400_000}d"
            diff < 2_592_000_000 -> "${diff / 604_800_000}sem"
            else -> "${diff / 2_592_000_000}mes"
        }
    }

    fun String.isValidEmail(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun String.isValidPassword(): Boolean {
        return length >= 8
    }

    fun String.isValidUsername(): Boolean {
        return matches(Regex("^[a-zA-Z0-9_.]{3,30}$"))
    }
}

/**
 * Constants
 */
object Constants {
    const val PREF_NAME = "shortreels_prefs"
    const val VIDEO_CACHE_SIZE = 500L * 1024 * 1024  // 500 MB
    const val IMAGE_CACHE_SIZE = 50L * 1024 * 1024   // 50 MB
    const val MAX_COMMENT_LENGTH = 500
    const val MAX_BIO_LENGTH = 150
    const val VIDEO_AUTOPLAY_THRESHOLD = 0.5f  // 50% visible = autoplay
    const val LIKE_ANIMATION_DURATION = 600L
    const val SWIPE_VELOCITY_THRESHOLD = 1000f
    const val MIN_SWIPE_DISTANCE = 100f
    const val PLAYER_BUFFER_MS = 3000
    const val PLAYER_MIN_BUFFER_MS = 1500
    const val FEED_PAGE_SIZE = 15
    const val PRELOAD_DISTANCE = 2  // Preload 2 videos ahead
}
