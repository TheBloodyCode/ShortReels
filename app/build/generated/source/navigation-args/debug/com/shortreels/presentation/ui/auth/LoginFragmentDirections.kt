package com.shortreels.presentation.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.shortreels.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginToRegister(): NavDirections =
        ActionOnlyNavDirections(R.id.action_login_to_register)
  }
}
