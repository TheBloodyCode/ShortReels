package com.shortreels.presentation.ui.series

import android.os.Bundle
import androidx.navigation.NavDirections
import com.shortreels.R
import kotlin.Int
import kotlin.String

public class SeriesDetailFragmentDirections private constructor() {
  private data class ActionSeriesDetailFragmentToPlayerFragment(
    public val videoId: String,
    public val seriesId: String = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_seriesDetailFragment_to_playerFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("videoId", this.videoId)
        result.putString("seriesId", this.seriesId)
        return result
      }
  }

  public companion object {
    public fun actionSeriesDetailFragmentToPlayerFragment(videoId: String, seriesId: String = ""):
        NavDirections = ActionSeriesDetailFragmentToPlayerFragment(videoId, seriesId)
  }
}
