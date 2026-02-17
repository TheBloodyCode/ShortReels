package com.shortreels.presentation.ui.series

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class SeriesDetailFragmentArgs(
  public val seriesId: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("seriesId", this.seriesId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("seriesId", this.seriesId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SeriesDetailFragmentArgs {
      bundle.setClassLoader(SeriesDetailFragmentArgs::class.java.classLoader)
      val __seriesId : String?
      if (bundle.containsKey("seriesId")) {
        __seriesId = bundle.getString("seriesId")
        if (__seriesId == null) {
          throw IllegalArgumentException("Argument \"seriesId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"seriesId\" is missing and does not have an android:defaultValue")
      }
      return SeriesDetailFragmentArgs(__seriesId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SeriesDetailFragmentArgs {
      val __seriesId : String?
      if (savedStateHandle.contains("seriesId")) {
        __seriesId = savedStateHandle["seriesId"]
        if (__seriesId == null) {
          throw IllegalArgumentException("Argument \"seriesId\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"seriesId\" is missing and does not have an android:defaultValue")
      }
      return SeriesDetailFragmentArgs(__seriesId)
    }
  }
}
