package com.shortreels.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * SessionManager - Handles app session state (login status, onboarding, etc.)
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/shortreels/data/repository/SessionManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "clearSession", "", "getCurrentUserId", "", "getDeviceId", "getPreferredGenre", "isAutoPlay", "", "isDataSaverMode", "isLoggedIn", "isOnboardingCompleted", "setAutoPlay", "enabled", "setCurrentUserId", "userId", "setDataSaverMode", "setLoggedIn", "setOnboardingCompleted", "completed", "setPreferredGenre", "genre", "Companion", "app_release"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_LOGGED_IN = "is_logged_in";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ONBOARDING_DONE = "onboarding_done";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DEVICE_ID = "device_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PREFERRED_GENRE = "preferred_genre";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_AUTOPLAY = "autoplay";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DATA_SAVER = "data_saver";
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.data.repository.SessionManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public SessionManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setLoggedIn(boolean isLoggedIn) {
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final void setOnboardingCompleted(boolean completed) {
    }
    
    public final boolean isOnboardingCompleted() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceId() {
        return null;
    }
    
    public final void setCurrentUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    public final void setPreferredGenre(@org.jetbrains.annotations.NotNull()
    java.lang.String genre) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPreferredGenre() {
        return null;
    }
    
    public final void setAutoPlay(boolean enabled) {
    }
    
    public final boolean isAutoPlay() {
        return false;
    }
    
    public final void setDataSaverMode(boolean enabled) {
    }
    
    public final boolean isDataSaverMode() {
        return false;
    }
    
    public final void clearSession() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/shortreels/data/repository/SessionManager$Companion;", "", "()V", "KEY_AUTOPLAY", "", "KEY_DATA_SAVER", "KEY_DEVICE_ID", "KEY_IS_LOGGED_IN", "KEY_ONBOARDING_DONE", "KEY_PREFERRED_GENRE", "KEY_USER_ID", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}