package com.shortreels.presentation.ui.premium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shortreels.databinding.FragmentPremiumBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * PremiumFragment - Subscription paywall screen.
 * Displays plans (Weekly/Monthly/Annual) with features and CTA buttons.
 * Matches Dramabox/Melolo subscription flow.
 */
@AndroidEntryPoint
class PremiumFragment : Fragment() {

    private var _binding: FragmentPremiumBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPremiumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnBack.setOnClickListener { findNavController().navigateUp() }

            // Plan selection
            cardWeekly.setOnClickListener { selectPlan("weekly") }
            cardMonthly.setOnClickListener { selectPlan("monthly") }
            cardAnnual.setOnClickListener { selectPlan("annual") }

            // Start with monthly selected
            selectPlan("monthly")

            btnSubscribe.setOnClickListener {
                // Initiate payment flow (Google Play Billing)
            }

            btnRestore.setOnClickListener {
                // Restore purchase
            }

            tvTerms.setOnClickListener {
                // Open terms URL
            }

            tvPrivacy.setOnClickListener {
                // Open privacy URL
            }
        }
    }

    private fun selectPlan(plan: String) = with(binding) {
        // Reset all card states
        listOf(cardWeekly, cardMonthly, cardAnnual).forEach {
            it.strokeWidth = 0
        }
        badgeBestValue.visibility = View.GONE

        when (plan) {
            "weekly" -> {
                cardWeekly.strokeWidth = 2
                tvSelectedPrice.text = "$1.99/semana"
            }
            "monthly" -> {
                cardMonthly.strokeWidth = 2
                tvSelectedPrice.text = "$6.99/mes"
            }
            "annual" -> {
                cardAnnual.strokeWidth = 2
                tvSelectedPrice.text = "$49.99/año"
                badgeBestValue.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
