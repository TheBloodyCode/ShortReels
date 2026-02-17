package com.shortreels

import android.app.Application
import com.shortreels.utils.AppLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShortReelsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppLogger.init(BuildConfig.DEBUG)
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val downloadChannel = android.app.NotificationChannel(
                CHANNEL_DOWNLOAD,
                "Descargas",
                android.app.NotificationManager.IMPORTANCE_LOW
            )
            val playbackChannel = android.app.NotificationChannel(
                CHANNEL_PLAYBACK,
                "Reproducción",
                android.app.NotificationManager.IMPORTANCE_LOW
            )
            
            val manager = getSystemService(android.app.NotificationManager::class.java)
            manager.createNotificationChannel(downloadChannel)
            manager.createNotificationChannel(playbackChannel)
        }
    }

    companion object {
        const val CHANNEL_DOWNLOAD = "downloads"
        const val CHANNEL_PLAYBACK = "playback"
    }
}
