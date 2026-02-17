package com.shortreels.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shortreels.R
import com.shortreels.databinding.*
import com.shortreels.domain.model.*
import com.shortreels.utils.Extensions.toFormattedCount
import com.shortreels.utils.Extensions.toRelativeTime
import com.shortreels.utils.Extensions.toTimestamp

// ===== CommentsAdapter =====
class CommentsAdapter(
    private val onLike: (String, Boolean) -> Unit,
    private val onReply: (Comment) -> Unit
) : ListAdapter<Comment, CommentsAdapter.CommentViewHolder>(CommentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CommentViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comment) = with(binding) {
            Glide.with(root.context).load(comment.author.avatarUrl)
                .circleCrop().placeholder(R.drawable.avatar_placeholder).into(ivAvatar)

            tvUsername.text = comment.author.displayName
            tvComment.text = comment.text
            tvTime.text = comment.createdAt.toRelativeTime()
            tvLikeCount.text = comment.likes.toFormattedCount()

            tvPinned.visibility = if (comment.isPinned) View.VISIBLE else View.GONE

            btnLike.setImageResource(
                if (comment.isLiked) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline
            )

            btnLike.setOnClickListener { onLike(comment.id, !comment.isLiked) }
            btnReply.setOnClickListener { onReply(comment) }

            // Show replies count
            if (comment.replyCount > 0) {
                tvReplies.visibility = View.VISIBLE
                tvReplies.text = "Ver ${comment.replyCount} respuestas"
            } else {
                tvReplies.visibility = View.GONE
            }
        }
    }

    class CommentDiffCallback : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Comment, newItem: Comment) = oldItem == newItem
    }
}

// ===== SeriesGridAdapter =====
class SeriesGridAdapter(
    private val onSeriesClick: (String) -> Unit
) : ListAdapter<Series, SeriesGridAdapter.SeriesViewHolder>(SeriesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val binding = ItemSeriesGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SeriesViewHolder(private val binding: ItemSeriesGridBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(series: Series) = with(binding) {
            Glide.with(root.context).load(series.thumbnailUrl)
                .centerCrop().placeholder(R.drawable.placeholder_series).into(ivThumbnail)

            tvTitle.text = series.title
            tvGenre.text = series.genre.displayName
            tvEpisodes.text = "${series.totalEpisodes} eps"
            tvRating.text = "★ ${series.rating}"

            badgePremium.visibility = if (series.monetization.isPremium) View.VISIBLE else View.GONE
            badgeNew.visibility = View.GONE // Set from server

            root.setOnClickListener { onSeriesClick(series.id) }
        }
    }

    class SeriesDiffCallback : DiffUtil.ItemCallback<Series>() {
        override fun areItemsTheSame(oldItem: Series, newItem: Series) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Series, newItem: Series) = oldItem == newItem
    }
}

// ===== EpisodesAdapter =====
class EpisodesAdapter(
    private val onEpisodeClick: (String) -> Unit
) : ListAdapter<Video, EpisodesAdapter.EpisodeViewHolder>(EpisodeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(video: Video) = with(binding) {
            tvEpisodeNumber.text = "EP ${video.episode}"
            tvTitle.text = video.title
            tvDuration.text = video.duration.toTimestamp()

            Glide.with(root.context).load(video.thumbnailUrl)
                .centerCrop().into(ivThumbnail)

            // Progress bar for partially watched
            if (video.watchProgress > 0f) {
                progressWatch.visibility = View.VISIBLE
                progressWatch.progress = (video.watchProgress * 100).toInt()
            } else {
                progressWatch.visibility = View.GONE
            }

            // Lock icon for premium episodes
            ivLock.visibility = if (video.monetization.isLocked) View.VISIBLE else View.GONE

            root.setOnClickListener {
                if (!video.monetization.isLocked) onEpisodeClick(video.id)
            }
        }
    }

    class EpisodeDiffCallback : DiffUtil.ItemCallback<Video>() {
        override fun areItemsTheSame(oldItem: Video, newItem: Video) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Video, newItem: Video) = oldItem == newItem
    }
}

// ===== VideoSearchAdapter =====
class VideoSearchAdapter(
    private val onVideoClick: (String) -> Unit
) : ListAdapter<Video, VideoSearchAdapter.SearchViewHolder>(SearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemVideoSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: ItemVideoSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(video: Video) = with(binding) {
            Glide.with(root.context).load(video.thumbnailUrl)
                .centerCrop().into(ivThumbnail)

            tvTitle.text = video.title
            tvSeries.text = "${video.seriesTitle} • EP ${video.episode}"
            tvViews.text = "${video.stats.views.toFormattedCount()} vistas"
            tvGenre.text = video.genre.displayName

            root.setOnClickListener { onVideoClick(video.id) }
        }
    }

    class SearchDiffCallback : DiffUtil.ItemCallback<Video>() {
        override fun areItemsTheSame(oldItem: Video, newItem: Video) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Video, newItem: Video) = oldItem == newItem
    }
}
