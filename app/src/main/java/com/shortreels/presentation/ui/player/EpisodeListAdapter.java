package com.shortreels.presentation.ui.player;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shortreels.R;
import com.shortreels.domain.model.Video;
import com.shortreels.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView Adapter for episode list - written in Java.
 * Demonstrates Kotlin/Java interoperability with data models defined in Kotlin.
 */
public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListAdapter.EpisodeViewHolder> {

    public interface OnEpisodeClickListener {
        void onEpisodeClick(Video episode, int position);

        void onUnlockClick(Video episode, int position);
    }

    private List<Video> episodes = new ArrayList<>();
    private final OnEpisodeClickListener listener;
    private int currentEpisodeIndex = 0;

    public EpisodeListAdapter(@NonNull OnEpisodeClickListener listener) {
        this.listener = listener;
    }

    public void setEpisodes(@NonNull List<Video> episodes) {
        this.episodes = new ArrayList<>(episodes);
        notifyDataSetChanged();
    }

    public void setCurrentEpisode(int index) {
        int prev = currentEpisodeIndex;
        currentEpisodeIndex = index;
        notifyItemChanged(prev);
        notifyItemChanged(index);
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_episode, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        Video episode = episodes.get(position);
        holder.bind(episode, position == currentEpisodeIndex);
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    class EpisodeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivThumbnail;
        private final ImageView ivLock;
        private final ImageView ivPlaying;
        private final TextView tvEpisodeNumber;
        private final TextView tvTitle;
        private final TextView tvDuration;
        private final ProgressBar progressWatch;
        private final View nowPlayingIndicator;

        EpisodeViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            ivLock = itemView.findViewById(R.id.iv_lock);
            ivPlaying = itemView.findViewById(R.id.iv_playing);
            tvEpisodeNumber = itemView.findViewById(R.id.tv_episode_number);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDuration = itemView.findViewById(R.id.tv_duration);
            progressWatch = itemView.findViewById(R.id.progress_watch);
            nowPlayingIndicator = itemView.findViewById(R.id.now_playing_indicator);
        }

        void bind(@NonNull Video episode, boolean isCurrentEpisode) {
            // Episode number
            tvEpisodeNumber.setText(itemView.getContext().getString(R.string.episode) + " " + episode.getEpisode());
            tvTitle.setText(episode.getTitle());
            tvDuration.setText(NumberUtils.formatDuration(episode.getDuration()));

            // Thumbnail
            Glide.with(itemView.getContext())
                    .load(episode.getThumbnailUrl())
                    .placeholder(R.drawable.placeholder_thumbnail)
                    .into(ivThumbnail);

            // Watch progress
            float progress = episode.getWatchProgress();
            if (progress > 0) {
                progressWatch.setVisibility(View.VISIBLE);
                progressWatch.setProgress((int) (progress * 100));
            } else {
                progressWatch.setVisibility(View.GONE);
            }

            // Lock state
            if (episode.getMonetization().isLocked()) {
                ivLock.setVisibility(View.VISIBLE);
                ivThumbnail.setAlpha(0.5f);
            } else {
                ivLock.setVisibility(View.GONE);
                ivThumbnail.setAlpha(1.0f);
            }

            // Currently playing
            nowPlayingIndicator.setVisibility(isCurrentEpisode ? View.VISIBLE : View.GONE);
            ivPlaying.setVisibility(isCurrentEpisode ? View.VISIBLE : View.GONE);

            // Highlight current
            itemView.setBackgroundResource(
                    isCurrentEpisode ? R.color.border_subtle : android.R.color.transparent);

            // Click listeners
            itemView.setOnClickListener(v -> {
                int pos = getBindingAdapterPosition();
                if (pos != RecyclerView.NO_ID) {
                    Video ep = episodes.get(pos);
                    if (ep.getMonetization().isLocked()) {
                        listener.onUnlockClick(ep, pos);
                    } else {
                        listener.onEpisodeClick(ep, pos);
                    }
                }
            });
        }
    }
}
