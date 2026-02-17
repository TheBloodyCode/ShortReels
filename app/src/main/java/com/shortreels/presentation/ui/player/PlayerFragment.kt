package com.shortreels.presentation.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import com.shortreels.databinding.FragmentPlayerBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlayerFragment : Fragment() {

    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var playerManager: VideoPlayerManager

    private val args by lazy {
        PlayerFragmentArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPlayer()
        setupControls()
    }

    private fun setupPlayer() {
        val player = playerManager.getPlayer()
        binding.playerView.player = player

        player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                when (state) {
                    Player.STATE_READY -> binding.progressBar.visibility = View.GONE
                    Player.STATE_BUFFERING -> binding.progressBar.visibility = View.VISIBLE
                    Player.STATE_ENDED -> requireActivity().onBackPressedDispatcher.onBackPressed()
                    else -> {}
                }
            }
        })
    }

    private fun setupControls() {
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btnPlayPause.setOnClickListener {
            if (playerManager.isPlaying) {
                playerManager.pause()
                binding.btnPlayPause.setImageResource(com.shortreels.R.drawable.ic_play)
            } else {
                playerManager.resume()
                binding.btnPlayPause.setImageResource(com.shortreels.R.drawable.ic_pause)
            }
        }

        binding.btnMute.setOnClickListener {
            val muted = playerManager.getPlayer().volume == 0f
            playerManager.mute(!muted)
            binding.btnMute.setImageResource(
                if (!muted) com.shortreels.R.drawable.ic_volume_off else com.shortreels.R.drawable.ic_volume_on
            )
        }
    }

    override fun onResume() {
        super.onResume()
        playerManager.resume()
    }

    override fun onPause() {
        super.onPause()
        playerManager.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
