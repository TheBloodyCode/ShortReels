package com.shortreels.presentation.ui.player

import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DataSpec
import androidx.media3.datasource.cache.CacheWriter
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.cache.Cache
import androidx.media3.datasource.cache.CacheDataSource
import com.shortreels.data.remote.api.ExtractorApi

@Singleton
class VideoPlayerManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val playerBuilder: ExoPlayer.Builder,
    private val dataSourceFactory: DataSource.Factory,
    private val cache: Cache,
    private val extractorApiProvider: javax.inject.Provider<ExtractorApi>
) {
    private var exoPlayer: ExoPlayer? = null
    private var currentUrl: String? = null
    private var currentPlayerView: PlayerView? = null
    private val scope = CoroutineScope(Dispatchers.IO)
    private var resolveJob: kotlinx.coroutines.Job? = null

    fun getPlayer(): ExoPlayer {
        if (exoPlayer == null) {
            exoPlayer = playerBuilder.build()
            exoPlayer?.repeatMode = Player.REPEAT_MODE_ONE
        }
        return exoPlayer!!
    }

    fun play(url: String, playerView: PlayerView) {
        val player = getPlayer()

        if (currentPlayerView != playerView) {
            currentPlayerView?.player = null
            currentPlayerView = playerView
            playerView.player = player
        }

        if (url == currentUrl) {
            if (!player.isPlaying) {
                player.play()
            }
            return
        }

        currentUrl = url
        resolveJob?.cancel()

        if (url.contains("youtube.com") || url.contains("youtu.be")) {
            resolveJob = scope.launch {
                try {
                    val response = extractorApiProvider.get().getStream(url)
                    if (response.isSuccessful) {
                        val streamInfo = response.body()
                        val finalUrl = streamInfo?.hls ?: streamInfo?.url

                        if (finalUrl != null) {
                            withContext(Dispatchers.Main) {
                                val mediaItem = MediaItem.fromUri(finalUrl)
                                player.setMediaItem(mediaItem)
                                player.prepare()
                                player.playWhenReady = true
                            }
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } else {
            val mediaItem = MediaItem.fromUri(url)
            player.setMediaItem(mediaItem)
            player.prepare()
            player.playWhenReady = true
        }
    }

    fun preCacheVideo(url: String) {
        val videoUri = Uri.parse(url)
        val dataSpec = DataSpec(videoUri, 0, 5 * 1024 * 1024L)
        
        scope.launch {
            try {
                val writeDataSource = CacheDataSource(
                    cache,
                    dataSourceFactory.createDataSource()
                )
                val cacheWriter = CacheWriter(
                    writeDataSource,
                    dataSpec,
                    null,
                    null
                )
                cacheWriter.cache()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun pause() {
        exoPlayer?.pause()
    }

    fun resume() {
        if (currentUrl != null) {
            exoPlayer?.play()
        }
    }
    
    fun stop() {
        exoPlayer?.stop()
        currentUrl = null
    }

    fun release() {
        exoPlayer?.release()
        exoPlayer = null
        currentUrl = null
        currentPlayerView?.player = null
        currentPlayerView = null
    }

    fun mute(muted: Boolean) {
        val volume = if (muted) 0f else 1f
        exoPlayer?.volume = volume
    }

    val isPlaying: Boolean
        get() = exoPlayer?.isPlaying == true
}
