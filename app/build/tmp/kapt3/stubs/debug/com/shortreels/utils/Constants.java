package com.shortreels.utils;

import android.util.Log;

/**
 * Constants
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/shortreels/utils/Constants;", "", "()V", "FEED_PAGE_SIZE", "", "IMAGE_CACHE_SIZE", "", "LIKE_ANIMATION_DURATION", "MAX_BIO_LENGTH", "MAX_COMMENT_LENGTH", "MIN_SWIPE_DISTANCE", "", "PLAYER_BUFFER_MS", "PLAYER_MIN_BUFFER_MS", "PREF_NAME", "", "PRELOAD_DISTANCE", "SWIPE_VELOCITY_THRESHOLD", "VIDEO_AUTOPLAY_THRESHOLD", "VIDEO_CACHE_SIZE", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_NAME = "shortreels_prefs";
    public static final long VIDEO_CACHE_SIZE = 524288000L;
    public static final long IMAGE_CACHE_SIZE = 52428800L;
    public static final int MAX_COMMENT_LENGTH = 500;
    public static final int MAX_BIO_LENGTH = 150;
    public static final float VIDEO_AUTOPLAY_THRESHOLD = 0.5F;
    public static final long LIKE_ANIMATION_DURATION = 600L;
    public static final float SWIPE_VELOCITY_THRESHOLD = 1000.0F;
    public static final float MIN_SWIPE_DISTANCE = 100.0F;
    public static final int PLAYER_BUFFER_MS = 3000;
    public static final int PLAYER_MIN_BUFFER_MS = 1500;
    public static final int FEED_PAGE_SIZE = 15;
    public static final int PRELOAD_DISTANCE = 2;
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
}