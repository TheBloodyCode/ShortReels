package com.shortreels.data.repository

import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Inject
import javax.inject.Singleton

/**
 * TokenManager - Handles secure JWT token storage using EncryptedSharedPreferences
 */
@Singleton
class TokenManager @Inject constructor(context: Context) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val prefs: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        "shortreels_secure_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveToken(accessToken: String, refreshToken: String, expiresIn: Long) {
        prefs.edit()
            .putString(KEY_ACCESS_TOKEN, accessToken)
            .putString(KEY_REFRESH_TOKEN, refreshToken)
            .putLong(KEY_EXPIRES_AT, System.currentTimeMillis() + (expiresIn * 1000))
            .apply()
    }

    fun getToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, null)

    fun getRefreshToken(): String? = prefs.getString(KEY_REFRESH_TOKEN, null)

    fun isTokenExpired(): Boolean {
        val expiresAt = prefs.getLong(KEY_EXPIRES_AT, 0)
        return System.currentTimeMillis() >= expiresAt - 60_000 // 1 min buffer
    }

    fun clearTokens() {
        prefs.edit()
            .remove(KEY_ACCESS_TOKEN)
            .remove(KEY_REFRESH_TOKEN)
            .remove(KEY_EXPIRES_AT)
            .apply()
    }

    fun hasToken(): Boolean = getToken() != null

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
        private const val KEY_EXPIRES_AT = "expires_at"
    }
}

/**
 * SessionManager - Handles app session state (login status, onboarding, etc.)
 */
@Singleton
class SessionManager @Inject constructor(private val context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("shortreels_session", Context.MODE_PRIVATE)

    fun setLoggedIn(isLoggedIn: Boolean) {
        prefs.edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply()
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    fun setOnboardingCompleted(completed: Boolean) {
        prefs.edit().putBoolean(KEY_ONBOARDING_DONE, completed).apply()
    }

    fun isOnboardingCompleted(): Boolean = prefs.getBoolean(KEY_ONBOARDING_DONE, false)

    fun getDeviceId(): String {
        return prefs.getString(KEY_DEVICE_ID, null) ?: run {
            val id = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
                ?: java.util.UUID.randomUUID().toString()
            prefs.edit().putString(KEY_DEVICE_ID, id).apply()
            id
        }
    }

    fun setCurrentUserId(userId: String) {
        prefs.edit().putString(KEY_USER_ID, userId).apply()
    }

    fun getCurrentUserId(): String? = prefs.getString(KEY_USER_ID, null)

    fun setPreferredGenre(genre: String) {
        prefs.edit().putString(KEY_PREFERRED_GENRE, genre).apply()
    }

    fun getPreferredGenre(): String? = prefs.getString(KEY_PREFERRED_GENRE, null)

    fun setAutoPlay(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_AUTOPLAY, enabled).apply()
    }

    fun isAutoPlay(): Boolean = prefs.getBoolean(KEY_AUTOPLAY, true)

    fun setDataSaverMode(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_DATA_SAVER, enabled).apply()
    }

    fun isDataSaverMode(): Boolean = prefs.getBoolean(KEY_DATA_SAVER, false)

    fun clearSession() {
        prefs.edit()
            .remove(KEY_IS_LOGGED_IN)
            .remove(KEY_USER_ID)
            .apply()
    }

    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_ONBOARDING_DONE = "onboarding_done"
        private const val KEY_DEVICE_ID = "device_id"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_PREFERRED_GENRE = "preferred_genre"
        private const val KEY_AUTOPLAY = "autoplay"
        private const val KEY_DATA_SAVER = "data_saver"
    }
}
