package com.shortreels.presentation.ui.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.shortreels.databinding.FragmentSeriesDetailBinding
import com.shortreels.presentation.adapters.EpisodesAdapter
import com.shortreels.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * SeriesDetailFragment - Full series info page.
 * Shows banner, episodes list, rating, follow button, episode grid.
 */
@AndroidEntryPoint
class SeriesDetailFragment : Fragment() {

    private var _binding: FragmentSeriesDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var episodesAdapter: EpisodesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSeriesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        btnBack.setOnClickListener { findNavController().navigateUp() }

        btnFollow.setOnClickListener {
            // Toggle follow
        }

        episodesAdapter = EpisodesAdapter { videoId ->
            val action = SeriesDetailFragmentDirections
                .actionSeriesDetailFragmentToPlayerFragment(videoId, "")
            findNavController().navigate(action)
        }

        rvEpisodes.apply {
            adapter = episodesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
