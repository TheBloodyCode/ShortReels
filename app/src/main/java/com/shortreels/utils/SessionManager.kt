package com.shortreels.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        val USER_ID = stringPreferencesKey("user_id")
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val ONBOARDING_DONE = booleanPreferencesKey("onboarding_done")
        val IS_MUTED = booleanPreferencesKey("is_muted")
        val AUTO_PLAY = booleanPreferencesKey("auto_play")
        val DATA_SAVER = booleanPreferencesKey("data_saver")
    }

    val isLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { it[IS_LOGGED_IN] ?: false }

    val accessToken: Flow<String?> = context.dataStore.data
        .map { it[ACCESS_TOKEN] }

    val isMuted: Flow<Boolean> = context.dataStore.data
        .map { it[IS_MUTED] ?: false }

    val onboardingDone: Flow<Boolean> = context.dataStore.data
        .map { it[ONBOARDING_DONE] ?: false }

    suspend fun saveTokens(accessToken: String, refreshToken: String, userId: String) {
        context.dataStore.edit { prefs ->
            prefs[ACCESS_TOKEN] = accessToken
            prefs[REFRESH_TOKEN] = refreshToken
            prefs[USER_ID] = userId
            prefs[IS_LOGGED_IN] = true
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit { prefs ->
            prefs.remove(ACCESS_TOKEN)
            prefs.remove(REFRESH_TOKEN)
            prefs.remove(USER_ID)
            prefs[IS_LOGGED_IN] = false
        }
    }

    suspend fun setOnboardingDone() {
        context.dataStore.edit { it[ONBOARDING_DONE] = true }
    }

    suspend fun setMuted(muted: Boolean) {
        context.dataStore.edit { it[IS_MUTED] = muted }
    }

    suspend fun getAccessToken(): String? {
        var token: String? = null
        context.dataStore.data.map { it[ACCESS_TOKEN] }.collect { token = it }
        return token
    }
}
