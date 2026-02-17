package com.shortreels.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.shortreels.R
import com.shortreels.databinding.FragmentProfileBinding
import com.shortreels.presentation.viewmodel.AuthViewModel
import com.shortreels.utils.Extensions.toFormattedCount
import dagger.hilt.android.AndroidEntryPoint

/**
 * ProfileFragment - User profile screen.
 * Shows avatar, stats (followers/following/videos), bio, and content grid.
 */
@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        // Toolbar actions
        btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_settings)
        }

        btnNotifications.setOnClickListener {
            findNavController().navigate(R.id.notificationsFragment)
        }

        btnEditProfile.setOnClickListener {
            // Open edit profile dialog/fragment
        }

        btnPremium.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_premium)
        }

        btnLogout.setOnClickListener {
            authViewModel.logout()
        }

        // Tab switching: Videos | Liked | Saved
        tabLayout.addOnTabSelectedListener(object : com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: com.google.android.material.tabs.TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> showMyVideos()
                    1 -> showLikedVideos()
                    2 -> showSavedVideos()
                }
            }
            override fun onTabUnselected(tab: com.google.android.material.tabs.TabLayout.Tab?) {}
            override fun onTabReselected(tab: com.google.android.material.tabs.TabLayout.Tab?) {}
        })
    }

    private fun showMyVideos() { /* load user's videos */ }
    private fun showLikedVideos() { /* load liked videos */ }
    private fun showSavedVideos() { /* load bookmarked videos */ }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
