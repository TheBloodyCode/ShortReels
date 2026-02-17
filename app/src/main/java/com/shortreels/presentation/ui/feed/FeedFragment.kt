package com.shortreels.presentation.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.chip.Chip
import com.shortreels.R
import com.shortreels.databinding.FragmentFeedBinding
import com.shortreels.domain.model.Genre
import com.shortreels.presentation.adapters.FeedAdapter
import com.shortreels.presentation.viewmodel.FeedViewModel
import com.shortreels.presentation.viewmodel.FeedUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * FeedFragment - Full-screen vertical scroll feed (ViewPager2).
 * Each item is a VideoPlayerViewHolder with ExoPlayer.
 * Mimics TikTok/Dramabox/Melolo swipe-up experience.
 */
@AndroidEntryPoint
class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FeedViewModel by viewModels()
    private lateinit var feedAdapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupGenreChips()
        observeViewModel()
    }

    private fun setupViewPager() {
        feedAdapter = FeedAdapter(
            onLike = { videoId, isLiked -> viewModel.toggleLike(videoId, isLiked) },
            onBookmark = { videoId, isBookmarked -> viewModel.toggleBookmark(videoId, isBookmarked) },
            onShare = { videoId -> shareVideo(videoId) },
            onComment = { videoId -> openComments(videoId) },
            onAuthorClick = { authorId -> openProfile(authorId) },
            onSeriesClick = { seriesId -> openSeries(seriesId) },
            onProgress = { videoId, progress -> viewModel.updateWatchProgress(videoId, progress) }
        )

        binding.viewPagerFeed.apply {
            adapter = feedAdapter
            orientation = ViewPager2.ORIENTATION_VERTICAL
            offscreenPageLimit = 2  // Keep 2 pages in memory

            // Reduce overdraw
            (getChildAt(0) as? RecyclerView)?.apply {
                setItemViewCacheSize(4)
                setHasFixedSize(true)
            }

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewModel.onVideoScrolled(position)
                    feedAdapter.onPageSelected(position)
                }
            })
        }
    }

    private fun setupGenreChips() {
        val genres = listOf(null) + Genre.values().toList()
        genres.forEachIndexed { index, genre ->
            val chip = layoutInflater.inflate(R.layout.item_genre_chip, binding.genreChipGroup, false) as Chip
            chip.text = genre?.displayName ?: "Para Ti"
            chip.isChecked = genre == null
            chip.setOnClickListener {
                binding.genreChipGroup.check(chip.id)
                viewModel.setGenreFilter(genre)
            }
            binding.genreChipGroup.addView(chip)
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.feedState.collect { state ->
                when (state) {
                    is FeedUiState.Loading -> showLoading()
                    is FeedUiState.Success -> {
                        hideLoading()
                        feedAdapter.submitList(state.videos)
                    }
                    is FeedUiState.Error -> {
                        hideLoading()
                        showError(state.message)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isRefreshing.collect { isRefreshing ->
                binding.swipeRefresh.isRefreshing = isRefreshing
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    private fun showLoading() {
        binding.shimmerLayout.visibility = View.VISIBLE
        binding.shimmerLayout.startShimmer()
        binding.viewPagerFeed.visibility = View.GONE
    }

    private fun hideLoading() {
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.visibility = View.GONE
        binding.viewPagerFeed.visibility = View.VISIBLE
    }

    private fun showError(message: String) {
        binding.errorLayout.visibility = View.VISIBLE
        binding.tvError.text = message
        binding.btnRetry.setOnClickListener { viewModel.loadFeed() }
    }

    private fun shareVideo(videoId: String) {
        // Share deeplink
    }

    private fun openComments(videoId: String) {
        val sheet = CommentsBottomSheet.newInstance(videoId)
        sheet.show(parentFragmentManager, CommentsBottomSheet.TAG)
    }

    private fun openProfile(authorId: String) {
        // Navigate to profile
    }

    private fun openSeries(seriesId: String) {
        // Navigate to series detail
    }

    override fun onResume() {
        super.onResume()
        feedAdapter.resumeCurrentPlayer(binding.viewPagerFeed.currentItem)
    }

    override fun onPause() {
        super.onPause()
        feedAdapter.pauseCurrentPlayer(binding.viewPagerFeed.currentItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        feedAdapter.releaseAllPlayers()
        _binding = null
    }
}
