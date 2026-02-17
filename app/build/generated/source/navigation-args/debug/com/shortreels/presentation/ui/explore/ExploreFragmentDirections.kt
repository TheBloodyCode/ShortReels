package com.shortreels.presentation.ui.explore

import android.os.Bundle
import androidx.navigation.NavDirections
import com.shortreels.R
import kotlin.Int
import kotlin.String

public class ExploreFragmentDirections private constructor() {
  private data class ActionExploreToSeries(
    public val seriesId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_explore_to_series

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("seriesId", this.seriesId)
        return result
      }
  }

  private data class ActionExploreToPlayer(
    public val videoId: String,
    public val seriesId: String = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_explore_to_player

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("videoId", this.videoId)
        result.putString("seriesId", this.seriesId)
        return result
      }
  }

  public companion object {
    public fun actionExploreToSeries(seriesId: String): NavDirections =
        ActionExploreToSeries(seriesId)

    public fun actionExploreToPlayer(videoId: String, seriesId: String = ""): NavDirections =
        ActionExploreToPlayer(videoId, seriesId)
  }
}
