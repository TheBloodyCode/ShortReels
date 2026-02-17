package com.shortreels.presentation.ui.profile

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class ProfileFragmentArgs(
  public val userId: String = "",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("userId", this.userId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("userId", this.userId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ProfileFragmentArgs {
      bundle.setClassLoader(ProfileFragmentArgs::class.java.classLoader)
      val __userId : String?
      if (bundle.containsKey("userId")) {
        __userId = bundle.getString("userId")
        if (__userId == null) {
          throw IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.")
        }
      } else {
        __userId = ""
      }
      return ProfileFragmentArgs(__userId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ProfileFragmentArgs {
      val __userId : String?
      if (savedStateHandle.contains("userId")) {
        __userId = savedStateHandle["userId"]
        if (__userId == null) {
          throw IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value")
        }
      } else {
        __userId = ""
      }
      return ProfileFragmentArgs(__userId)
    }
  }
}
