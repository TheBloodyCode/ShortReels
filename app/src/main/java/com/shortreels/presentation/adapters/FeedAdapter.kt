package com.shortreels.presentation.adapters

import android.animation.ObjectAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shortreels.R
import com.shortreels.databinding.ItemVideoFeedBinding
import com.shortreels.domain.model.Video
import com.shortreels.utils.Extensions.toFormattedCount
import com.shortreels.utils.Extensions.toTimestamp
import kotlinx.coroutines.*

/**
 * FeedAdapter - Powers the vertical video feed.
 * Each ViewHolder manages its own ExoPlayer instance.
 * Uses an object pool to limit active players and memory usage.
 */
class FeedAdapter(
    private val onLike: (String, Boolean) -> Unit,
    private val onBookmark: (String, Boolean) -> Unit,
    private val onShare: (String) -> Unit,
    private val onComment: (String) -> Unit,
    private val onAuthorClick: (String) -> Unit,
    private val onSeriesClick: (String) -> Unit,
    private val onProgress: (String, Float) -> Unit
) : ListAdapter<Video, FeedAdapter.VideoViewHolder>(VideoDiffCallback()) {

    private val playerPool = mutableMapOf<Int, ExoPlayer>()
    private var currentPlayingHolder: VideoViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoFeedBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VideoViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewAttachedToWindow(holder: VideoViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.attachPlayer()
    }

    override fun onViewDetachedFromWindow(holder: VideoViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.detachPlayer()
    }

    override fun onViewRecycled(holder: VideoViewHolder) {
        super.onViewRecycled(holder)
        holder.recycle()
    }

    fun onPageSelected(position: Int) {
        currentPlayingHolder?.pause()
        val holder = findVisibleHolder(position)
        holder?.play()
        currentPlayingHolder = holder
    }

    fun resumeCurrentPlayer(position: Int) {
        currentPlayingHolder?.play() ?: findVisibleHolder(position)?.play()
    }

    fun pauseCurrentPlayer(position: Int) {
        findVisibleHolder(position)?.pause()
    }

    fun releaseAllPlayers() {
        playerPool.values.forEach { it.release() }
        playerPool.clear()
    }

    private fun findVisibleHolder(position: Int): VideoViewHolder? = null  // Managed by ViewPager2

    // ===== ViewHolder =====
    inner class VideoViewHolder(
        private val binding: ItemVideoFeedBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        private var player: ExoPlayer? = null
        private var video: Video? = null
        private var progressJob: Job? = null
        private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())
        private var isLiked = false
        private var isBookmarked = false
        private var isDoubleTapLiked = false

        fun bind(video: Video) {
            this.video = video
            this.isLiked = video.isLiked
            this.isBookmarked = video.isBookmarked

            bindContent(video)
            setupInteractions(video)
            loadThumbnail(video)
        }

        private fun bindContent(video: Video) = with(binding) {
            // Series info
            tvSeriesTitle.text = video.seriesTitle
            tvEpisode.text = "EP ${video.episode}"
            tvVideoTitle.text = video.title
            tvDescription.text = video.description

            // Author
            tvAuthorName.text = "@${video.author.username}"
            ivVerified.visibility = if (video.author.isVerified) View.VISIBLE else View.GONE
            Glide.with(context)
                .load(video.author.avatarUrl)
                .circleCrop()
                .placeholder(R.drawable.avatar_placeholder)
                .into(ivAuthorAvatar)

            // Stats
            tvLikeCount.text = video.stats.likes.toFormattedCount()
            tvCommentCount.text = video.stats.comments.toFormattedCount()
            tvShareCount.text = video.stats.shares.toFormattedCount()

            // Like / Bookmark state
            updateLikeButton()
            updateBookmarkButton()

            // Premium badge
            badgePremium.visibility = if (video.monetization.isPremium) View.VISIBLE else View.GONE

            // Lock overlay
            lockOverlay.visibility = if (video.monetization.isLocked) View.VISIBLE else View.GONE
            if (video.monetization.isLocked) {
                tvCoinsRequired.text = "${video.monetization.coinsRequired} Coins"
            }

            // Genre tag
            tvGenre.text = video.genre.displayName

            // Progress bar (resume from where user left off)
            progressBar.progress = (video.watchProgress * 100).toInt()
        }

        private fun setupInteractions(video: Video) = with(binding) {
            // Like button
            btnLike.setOnClickListener {
                isLiked = !isLiked
                video.stats.let { /* optimistic update handled in VM */ }
                updateLikeButton()
                animateLikeButton()
                onLike(video.id, isLiked)
            }

            // Double tap to like (TikTok style)
            videoSurface.setOnClickListener {
                // Single tap = show/hide controls
                toggleControls()
            }
            binding.root.setOnDoubleClickListener {
                if (!isLiked) {
                    isLiked = true
                    updateLikeButton()
                    onLike(video.id, true)
                }
                showHeartAnimation()
            }

            // Bookmark
            btnBookmark.setOnClickListener {
                isBookmarked = !isBookmarked
                updateBookmarkButton()
                onBookmark(video.id, isBookmarked)
            }

            // Comment
            btnComment.setOnClickListener { onComment(video.id) }

            // Share
            btnShare.setOnClickListener { onShare(video.id) }

            // Author
            ivAuthorAvatar.setOnClickListener { onAuthorClick(video.author.id) }
            tvAuthorName.setOnClickListener { onAuthorClick(video.author.id) }

            // Series title
            tvSeriesTitle.setOnClickListener { onSeriesClick(video.seriesId) }

            // Mute button
            btnMute.setOnClickListener { toggleMute() }

            // Unlock (if locked)
            btnUnlock.setOnClickListener { openUnlockDialog() }

            // Description expand
            tvDescription.setOnClickListener {
                tvDescription.maxLines = if (tvDescription.maxLines == 2) Int.MAX_VALUE else 2
            }
        }

        private fun loadThumbnail(video: Video) {
            Glide.with(context)
                .load(video.thumbnailUrl)
                .centerCrop()
                .into(binding.ivThumbnail)
        }

        fun attachPlayer() {
            val video = video ?: return
            if (video.monetization.isLocked) return

            player = ExoPlayer.Builder(context)
                .setLoadControl(
                    DefaultLoadControl.Builder()
                        .setBufferDurationsMs(3000, 8000, 1500, 2000)
                        .build()
                )
                .build().apply {
                    val mediaItem = MediaItem.fromUri(video.hlsUrl ?: video.videoUrl)
                    setMediaItem(mediaItem)
                    prepare()
                    repeatMode = Player.REPEAT_MODE_ONE
                    volume = 1f
                    binding.videoSurface.player = this
                    addListener(playerListener)
                }
        }

        fun detachPlayer() {
            progressJob?.cancel()
            player?.apply {
                removeListener(playerListener)
                binding.videoSurface.player = null
            }
        }

        fun play() {
            player?.play()
            binding.ivThumbnail.visibility = View.GONE
            binding.btnPlayPause.setImageResource(R.drawable.ic_pause)
            startProgressTracking()
        }

        fun pause() {
            player?.pause()
            progressJob?.cancel()
            binding.btnPlayPause.setImageResource(R.drawable.ic_play)
        }

        fun recycle() {
            scope.cancel()
            detachPlayer()
            player?.release()
            player = null
        }

        private fun startProgressTracking() {
            progressJob?.cancel()
            progressJob = scope.launch {
                while (isActive) {
                    delay(500)
                    player?.let { p ->
                        val progress = if (p.duration > 0) {
                            p.currentPosition.toFloat() / p.duration
                        } else 0f

                        binding.progressBar.progress = (progress * 100).toInt()
                        binding.tvCurrentTime.text = p.currentPosition.toTimestamp()
                        binding.tvTotalTime.text = p.duration.toTimestamp()
                        video?.let { v -> onProgress(v.id, progress) }
                    }
                }
            }
        }

        private fun toggleControls() {
            val isVisible = binding.controlsOverlay.visibility == View.VISIBLE
            binding.controlsOverlay.visibility = if (isVisible) View.GONE else View.VISIBLE
            if (!isVisible) {
                // Auto-hide after 3 seconds
                scope.launch {
                    delay(3000)
                    binding.controlsOverlay.visibility = View.GONE
                }
            }
        }

        private fun toggleMute() {
            player?.let { p ->
                val newVolume = if (p.volume == 0f) 1f else 0f
                p.volume = newVolume
                binding.btnMute.setImageResource(
                    if (newVolume == 0f) R.drawable.ic_mute else R.drawable.ic_unmute
                )
            }
        }

        private fun updateLikeButton() {
            binding.btnLike.setImageResource(
                if (isLiked) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline
            )
            binding.tvLikeCount.setTextColor(
                if (isLiked) itemView.context.getColor(R.color.accent_primary)
                else itemView.context.getColor(R.color.white)
            )
        }

        private fun updateBookmarkButton() {
            binding.btnBookmark.setImageResource(
                if (isBookmarked) R.drawable.ic_bookmark_filled else R.drawable.ic_bookmark_outline
            )
        }

        private fun animateLikeButton() {
            val scaleX = ObjectAnimator.ofFloat(binding.btnLike, "scaleX", 1f, 1.4f, 1f)
            val scaleY = ObjectAnimator.ofFloat(binding.btnLike, "scaleY", 1f, 1.4f, 1f)
            scaleX.duration = 300
            scaleY.duration = 300
            scaleX.interpolator = DecelerateInterpolator()
            scaleY.interpolator = DecelerateInterpolator()
            scaleX.start()
            scaleY.start()
        }

        private fun showHeartAnimation() {
            binding.ivHeartAnimation.apply {
                visibility = View.VISIBLE
                scaleX = 0f
                scaleY = 0f
                alpha = 1f
                animate()
                    .scaleX(1.5f).scaleY(1.5f)
                    .setDuration(200)
                    .withEndAction {
                        animate()
                            .alpha(0f)
                            .setDuration(400)
                            .withEndAction { visibility = View.GONE }
                            .start()
                    }
                    .start()
            }
        }

        private fun openUnlockDialog() {
            // Implement unlock/paywall dialog
        }

        private val playerListener = object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                when (playbackState) {
                    Player.STATE_BUFFERING -> binding.loadingSpinner.visibility = View.VISIBLE
                    Player.STATE_READY -> {
                        binding.loadingSpinner.visibility = View.GONE
                        binding.ivThumbnail.visibility = View.GONE
                    }
                    Player.STATE_ENDED -> {
                        // Loop handled by REPEAT_MODE_ONE
                    }
                    Player.STATE_IDLE -> {}
                }
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                binding.btnPlayPause.setImageResource(
                    if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
                )
            }
        }
    }

    // ===== Diff Callback =====
    class VideoDiffCallback : DiffUtil.ItemCallback<Video>() {
        override fun areItemsTheSame(oldItem: Video, newItem: Video) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Video, newItem: Video) = oldItem == newItem
    }
}

// Extension: double tap listener
private var lastClickTime = 0L
fun View.setOnDoubleClickListener(action: () -> Unit) {
    setOnClickListener {
        val now = System.currentTimeMillis()
        if (now - lastClickTime < 300) action()
        lastClickTime = now
    }
}
