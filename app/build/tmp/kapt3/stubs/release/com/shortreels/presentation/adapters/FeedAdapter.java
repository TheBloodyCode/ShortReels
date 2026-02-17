package com.shortreels.presentation.adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.shortreels.R;
import com.shortreels.databinding.ItemVideoFeedBinding;
import com.shortreels.domain.model.Video;
import kotlinx.coroutines.*;

/**
 * FeedAdapter - Powers the vertical video feed.
 * Each ViewHolder manages its own ExoPlayer instance.
 * Uses an object pool to limit active players and memory usage.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002&\'B\u00a3\u0001\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0017\u001a\b\u0018\u00010\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u001c\u0010\u0019\u001a\u00020\b2\n\u0010\u001a\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u001c\u0010\u001b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015J\u0014\u0010 \u001a\u00020\b2\n\u0010\u001a\u001a\u00060\u0003R\u00020\u0000H\u0016J\u0014\u0010!\u001a\u00020\b2\n\u0010\u001a\u001a\u00060\u0003R\u00020\u0000H\u0016J\u0014\u0010\"\u001a\u00020\b2\n\u0010\u001a\u001a\u00060\u0003R\u00020\u0000H\u0016J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010$\u001a\u00020\bJ\u000e\u0010%\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0003R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/shortreels/presentation/adapters/FeedAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/shortreels/domain/model/Video;", "Lcom/shortreels/presentation/adapters/FeedAdapter$VideoViewHolder;", "onLike", "Lkotlin/Function2;", "", "", "", "onBookmark", "onShare", "Lkotlin/Function1;", "onComment", "onAuthorClick", "onSeriesClick", "onProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "currentPlayingHolder", "playerPool", "", "", "Landroidx/media3/exoplayer/ExoPlayer;", "findVisibleHolder", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onPageSelected", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "pauseCurrentPlayer", "releaseAllPlayers", "resumeCurrentPlayer", "VideoDiffCallback", "VideoViewHolder", "app_release"})
public final class FeedAdapter extends androidx.recyclerview.widget.ListAdapter<com.shortreels.domain.model.Video, com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Boolean, kotlin.Unit> onLike = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Boolean, kotlin.Unit> onBookmark = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onShare = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onComment = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onAuthorClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onSeriesClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Float, kotlin.Unit> onProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Integer, androidx.media3.exoplayer.ExoPlayer> playerPool = null;
    @org.jetbrains.annotations.Nullable()
    private com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder currentPlayingHolder;
    
    public FeedAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onLike, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onBookmark, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onShare, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onComment, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAuthorClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSeriesClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Float, kotlin.Unit> onProgress) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onViewAttachedToWindow(@org.jetbrains.annotations.NotNull()
    com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder holder) {
    }
    
    @java.lang.Override()
    public void onViewDetachedFromWindow(@org.jetbrains.annotations.NotNull()
    com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder holder) {
    }
    
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder holder) {
    }
    
    public final void onPageSelected(int position) {
    }
    
    public final void resumeCurrentPlayer(int position) {
    }
    
    public final void pauseCurrentPlayer(int position) {
    }
    
    public final void releaseAllPlayers() {
    }
    
    private final com.shortreels.presentation.adapters.FeedAdapter.VideoViewHolder findVisibleHolder(int position) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/shortreels/presentation/adapters/FeedAdapter$VideoDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/shortreels/domain/model/Video;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    public static final class VideoDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.shortreels.domain.model.Video> {
        
        public VideoDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.shortreels.domain.model.Video oldItem, @org.jetbrains.annotations.NotNull()
        com.shortreels.domain.model.Video newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.shortreels.domain.model.Video oldItem, @org.jetbrains.annotations.NotNull()
        com.shortreels.domain.model.Video newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u001a\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/shortreels/presentation/adapters/FeedAdapter$VideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/shortreels/databinding/ItemVideoFeedBinding;", "context", "Landroid/content/Context;", "(Lcom/shortreels/presentation/adapters/FeedAdapter;Lcom/shortreels/databinding/ItemVideoFeedBinding;Landroid/content/Context;)V", "isBookmarked", "", "isDoubleTapLiked", "isLiked", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "playerListener", "Landroidx/media3/common/Player$Listener;", "progressJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "video", "Lcom/shortreels/domain/model/Video;", "animateLikeButton", "", "attachPlayer", "bind", "bindContent", "detachPlayer", "loadThumbnail", "openUnlockDialog", "pause", "play", "recycle", "setupInteractions", "showHeartAnimation", "startProgressTracking", "toggleControls", "toggleMute", "updateBookmarkButton", "updateLikeButton", "app_release"})
    public final class VideoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.shortreels.databinding.ItemVideoFeedBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        @org.jetbrains.annotations.Nullable()
        private androidx.media3.exoplayer.ExoPlayer player;
        @org.jetbrains.annotations.Nullable()
        private com.shortreels.domain.model.Video video;
        @org.jetbrains.annotations.Nullable()
        private kotlinx.coroutines.Job progressJob;
        @org.jetbrains.annotations.NotNull()
        private final kotlinx.coroutines.CoroutineScope scope = null;
        private boolean isLiked = false;
        private boolean isBookmarked = false;
        private boolean isDoubleTapLiked = false;
        @org.jetbrains.annotations.NotNull()
        private final androidx.media3.common.Player.Listener playerListener = null;
        
        public VideoViewHolder(@org.jetbrains.annotations.NotNull()
        com.shortreels.databinding.ItemVideoFeedBinding binding, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.shortreels.domain.model.Video video) {
        }
        
        private final void bindContent(com.shortreels.domain.model.Video video) {
        }
        
        private final void setupInteractions(com.shortreels.domain.model.Video video) {
        }
        
        private final void loadThumbnail(com.shortreels.domain.model.Video video) {
        }
        
        public final void attachPlayer() {
        }
        
        public final void detachPlayer() {
        }
        
        public final void play() {
        }
        
        public final void pause() {
        }
        
        public final void recycle() {
        }
        
        private final void startProgressTracking() {
        }
        
        private final void toggleControls() {
        }
        
        private final void toggleMute() {
        }
        
        private final void updateLikeButton() {
        }
        
        private final void updateBookmarkButton() {
        }
        
        private final void animateLikeButton() {
        }
        
        private final void showHeartAnimation() {
        }
        
        private final void openUnlockDialog() {
        }
    }
}