package com.shortreels.presentation.ui.player;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;
import javax.inject.Singleton;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSource;
import com.shortreels.data.remote.api.ExtractorApi;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u001dJ\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/shortreels/presentation/ui/player/VideoPlayerManager;", "", "context", "Landroid/content/Context;", "playerBuilder", "Landroidx/media3/exoplayer/ExoPlayer$Builder;", "dataSourceFactory", "Landroidx/media3/datasource/DataSource$Factory;", "cache", "Landroidx/media3/datasource/cache/Cache;", "extractorApiProvider", "Ljavax/inject/Provider;", "Lcom/shortreels/data/remote/api/ExtractorApi;", "(Landroid/content/Context;Landroidx/media3/exoplayer/ExoPlayer$Builder;Landroidx/media3/datasource/DataSource$Factory;Landroidx/media3/datasource/cache/Cache;Ljavax/inject/Provider;)V", "currentPlayerView", "Landroidx/media3/ui/PlayerView;", "currentUrl", "", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "isPlaying", "", "()Z", "resolveJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getPlayer", "mute", "", "muted", "pause", "play", "url", "playerView", "preCacheVideo", "release", "resume", "stop", "app_debug"})
public final class VideoPlayerManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.media3.exoplayer.ExoPlayer.Builder playerBuilder = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.media3.datasource.DataSource.Factory dataSourceFactory = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.media3.datasource.cache.Cache cache = null;
    @org.jetbrains.annotations.NotNull()
    private final javax.inject.Provider<com.shortreels.data.remote.api.ExtractorApi> extractorApiProvider = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.media3.exoplayer.ExoPlayer exoPlayer;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currentUrl;
    @org.jetbrains.annotations.Nullable()
    private androidx.media3.ui.PlayerView currentPlayerView;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job resolveJob;
    
    @javax.inject.Inject()
    public VideoPlayerManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.media3.exoplayer.ExoPlayer.Builder playerBuilder, @org.jetbrains.annotations.NotNull()
    androidx.media3.datasource.DataSource.Factory dataSourceFactory, @org.jetbrains.annotations.NotNull()
    androidx.media3.datasource.cache.Cache cache, @org.jetbrains.annotations.NotNull()
    javax.inject.Provider<com.shortreels.data.remote.api.ExtractorApi> extractorApiProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.media3.exoplayer.ExoPlayer getPlayer() {
        return null;
    }
    
    public final void play(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    androidx.media3.ui.PlayerView playerView) {
    }
    
    public final void preCacheVideo(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public final void pause() {
    }
    
    public final void resume() {
    }
    
    public final void stop() {
    }
    
    public final void release() {
    }
    
    public final void mute(boolean muted) {
    }
    
    public final boolean isPlaying() {
        return false;
    }
}