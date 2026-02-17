package com.shortreels.presentation.ui.feed

import android.os.Bundle
import androidx.navigation.NavDirections
import com.shortreels.R
import kotlin.Int
import kotlin.String

public class FeedFragmentDirections private constructor() {
  private data class ActionFeedToPlayer(
    public val videoId: String,
    public val seriesId: String = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_feed_to_player

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("videoId", this.videoId)
        result.putString("seriesId", this.seriesId)
        return result
      }
  }

  public companion object {
    public fun actionFeedToPlayer(videoId: String, seriesId: String = ""): NavDirections =
        ActionFeedToPlayer(videoId, seriesId)
  }
}
