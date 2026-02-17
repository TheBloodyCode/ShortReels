package com.shortreels.presentation.ui.explore

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.shortreels.databinding.FragmentExploreBinding
import com.shortreels.presentation.adapters.SeriesGridAdapter
import com.shortreels.presentation.adapters.VideoSearchAdapter
import com.shortreels.presentation.viewmodel.ExploreViewModel
import com.shortreels.presentation.viewmodel.SearchResultState
import com.shortreels.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch

/**
 * ExploreFragment - Discover new series and videos.
 * Features: Search bar, trending section, category grid, featured series.
 */
@AndroidEntryPoint
class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExploreViewModel by viewModels()
    private lateinit var seriesAdapter: SeriesGridAdapter
    private lateinit var searchAdapter: VideoSearchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearch()
        setupRecyclerViews()
        observeViewModel()
    }

    private fun setupSearch() = with(binding) {
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.onSearchQueryChanged(s.toString())
                btnClear.visibility = if (s.isNullOrEmpty()) View.GONE else View.VISIBLE
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        btnClear.setOnClickListener {
            etSearch.text?.clear()
            viewModel.clearSearch()
        }

        etSearch.setOnFocusChangeListener { _, hasFocus ->
            binding.searchResultsContainer.visibility = if (hasFocus) View.VISIBLE else View.GONE
            binding.discoverContainer.visibility = if (hasFocus) View.GONE else View.VISIBLE
        }
    }

    private fun setupRecyclerViews() {
        // Series grid (2 columns)
        seriesAdapter = SeriesGridAdapter { seriesId ->
            val action = ExploreFragmentDirections.actionExploreToSeries(seriesId)
            findNavController().navigate(action)
        }
        binding.rvSeries.apply {
            adapter = seriesAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        // Search results
        searchAdapter = VideoSearchAdapter { videoId ->
            val action = ExploreFragmentDirections.actionExploreToPlayer(videoId, "")
            findNavController().navigate(action)
        }
        binding.rvSearchResults.apply {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.trendingVideos.collect { result ->
                when (result) {
                    is NetworkResult.Loading -> binding.shimmerTrending.startShimmer()
                    is NetworkResult.Success -> {
                        binding.shimmerTrending.stopShimmer()
                        binding.shimmerTrending.visibility = View.GONE
                        // Populate trending section
                    }
                    is NetworkResult.Error -> {
                        binding.shimmerTrending.stopShimmer()
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.featuredSeries.collect { result ->
                when (result) {
                    is NetworkResult.Success -> seriesAdapter.submitList(result.data)
                    else -> {}
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.searchResults.collect { state ->
                when (state) {
                    is SearchResultState.Idle -> {
                        binding.searchResultsContainer.visibility = View.GONE
                        binding.tvNoResults.visibility = View.GONE
                    }
                    is SearchResultState.Loading -> {
                        binding.searchProgressBar.visibility = View.VISIBLE
                        binding.tvNoResults.visibility = View.GONE
                    }
                    is SearchResultState.Results -> {
                        binding.searchProgressBar.visibility = View.GONE
                        if (state.videos.isEmpty()) {
                            binding.tvNoResults.visibility = View.VISIBLE
                            binding.rvSearchResults.visibility = View.GONE
                        } else {
                            binding.tvNoResults.visibility = View.GONE
                            binding.rvSearchResults.visibility = View.VISIBLE
                            searchAdapter.submitList(state.videos)
                        }
                    }
                    is SearchResultState.Error -> {
                        binding.searchProgressBar.visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
