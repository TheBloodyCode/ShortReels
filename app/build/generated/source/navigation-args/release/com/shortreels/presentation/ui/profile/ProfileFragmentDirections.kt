package com.shortreels.presentation.ui.profile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.shortreels.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileToPremium(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profile_to_premium)

    public fun actionProfileToSettings(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profile_to_settings)

    public fun actionProfileToAuth(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profile_to_auth)
  }
}
