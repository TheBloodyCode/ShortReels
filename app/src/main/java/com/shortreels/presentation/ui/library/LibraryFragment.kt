package com.shortreels.presentation.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shortreels.databinding.FragmentLibraryBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * LibraryFragment - User's saved content.
 * Tabs: History | Bookmarks | Downloads | Following
 */
@AndroidEntryPoint
class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabs()
    }

    private fun setupTabs() {
        // Setup ViewPager2 with tab categories
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Historial"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Guardados"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Descargas"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Siguiendo"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
