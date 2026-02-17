package com.shortreels.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.shortreels.R
import com.shortreels.databinding.ActivityMainBinding
import com.shortreels.presentation.viewmodel.AuthViewModel
import com.shortreels.presentation.viewmodel.AuthUiState
import com.shortreels.presentation.ui.auth.AuthActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * MainActivity - Root activity hosting the bottom nav and NavHostFragment.
 * Tabs: Feed | Explore | (Add) | Library | Profile
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        observeAuthState()
    }

    private fun setupEdgeToEdge() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(navController)

        // Hide/show bottom nav based on destination
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val showBottomNav = when (destination.id) {
                R.id.feedFragment,
                R.id.exploreFragment,
                R.id.libraryFragment,
                R.id.profileFragment -> true
                else -> false
            }
            binding.bottomNav.visibility = if (showBottomNav) View.VISIBLE else View.GONE
        }

        // Custom handler for upload button (center FAB)
        binding.fabUpload.setOnClickListener {
            navController.navigate(R.id.uploadFragment)
        }
    }

    private fun observeAuthState() {
        lifecycleScope.launch {
            authViewModel.authState.collect { state ->
                if (state is AuthUiState.LoggedOut) {
                    navigateToAuth()
                }
            }
        }
    }

    private fun navigateToAuth() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
