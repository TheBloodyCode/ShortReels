package com.shortreels.presentation.ui.player

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class PlayerFragmentArgs(
  public val videoId: String,
  public val seriesId: String = "",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("videoId", this.videoId)
    result.putString("seriesId", this.seriesId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("videoId", this.videoId)
    result.set("seriesId", this.seriesId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): PlayerFragmentArgs {
      bundle.setClassLoader(PlayerFragmentArgs::class.java.classLoader)
      val __videoId : String?
      if (bundle.containsKey("videoId")) {
        __videoId = bundle.getString("videoId")
        if (__videoId == null) {
          throw IllegalArgumentException("Argument \"videoId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"videoId\" is missing and does not have an android:defaultValue")
      }
      val __seriesId : String?
      if (bundle.containsKey("seriesId")) {
        __seriesId = bundle.getString("seriesId")
        if (__seriesId == null) {
          throw IllegalArgumentException("Argument \"seriesId\" is marked as non-null but was passed a null value.")
        }
      } else {
        __seriesId = ""
      }
      return PlayerFragmentArgs(__videoId, __seriesId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): PlayerFragmentArgs {
      val __videoId : String?
      if (savedStateHandle.contains("videoId")) {
        __videoId = savedStateHandle["videoId"]
        if (__videoId == null) {
          throw IllegalArgumentException("Argument \"videoId\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"videoId\" is missing and does not have an android:defaultValue")
      }
      val __seriesId : String?
      if (savedStateHandle.contains("seriesId")) {
        __seriesId = savedStateHandle["seriesId"]
        if (__seriesId == null) {
          throw IllegalArgumentException("Argument \"seriesId\" is marked as non-null but was passed a null value")
        }
      } else {
        __seriesId = ""
      }
      return PlayerFragmentArgs(__videoId, __seriesId)
    }
  }
}
