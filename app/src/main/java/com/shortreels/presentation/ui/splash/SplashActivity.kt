package com.shortreels.presentation.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope

import com.shortreels.presentation.ui.MainActivity
import com.shortreels.presentation.ui.auth.AuthActivity
import com.shortreels.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * SplashActivity - Entry point with animated logo.
 * Routes to Auth or Main based on session state.
 */
@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition { true }

        lifecycleScope.launch {
            delay(1800) // Splash duration
            splashScreen.setKeepOnScreenCondition { false }
            navigate()
        }
    }

    private fun navigate() {
        val destination = if (authViewModel.isLoggedIn) MainActivity::class.java
                          else AuthActivity::class.java
        startActivity(Intent(this, destination))
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
