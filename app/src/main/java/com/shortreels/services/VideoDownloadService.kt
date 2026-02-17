package com.shortreels.services

import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.shortreels.R
import com.shortreels.ShortReelsApp
import kotlinx.coroutines.*
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * VideoDownloadService - Foreground service for downloading videos for offline use.
 * Manages download queue, progress notifications, and local storage.
 */
class VideoDownloadService : Service() {

    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val downloadQueue = mutableListOf<DownloadTask>()
    private var isRunning = false

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_DOWNLOAD -> {
                val videoId = intent.getStringExtra(EXTRA_VIDEO_ID) ?: return START_NOT_STICKY
                val videoUrl = intent.getStringExtra(EXTRA_VIDEO_URL) ?: return START_NOT_STICKY
                val videoTitle = intent.getStringExtra(EXTRA_VIDEO_TITLE) ?: "Video"

                downloadQueue.add(DownloadTask(videoId, videoUrl, videoTitle))
                if (!isRunning) processQueue()
            }
            ACTION_CANCEL -> {
                val videoId = intent.getStringExtra(EXTRA_VIDEO_ID)
                downloadQueue.removeAll { it.videoId == videoId }
            }
        }
        return START_STICKY
    }

    private fun processQueue() {
        if (downloadQueue.isEmpty()) {
            stopSelf()
            return
        }

        isRunning = true
        val task = downloadQueue.removeAt(0)
        startForeground(NOTIFICATION_ID, buildNotification(task.title, 0))

        serviceScope.launch {
            try {
                downloadVideo(task)
                processQueue()
            } catch (e: Exception) {
                // Mark as failed
                isRunning = false
                processQueue()
            }
        }
    }

    private suspend fun downloadVideo(task: DownloadTask) = withContext(Dispatchers.IO) {
        val url = URL(task.url)
        val connection = url.openConnection() as HttpURLConnection
        connection.connect()

        val totalSize = connection.contentLength.toLong()
        val outputFile = File(getExternalFilesDir("downloads"), "${task.videoId}.mp4")

        connection.inputStream.use { input ->
            FileOutputStream(outputFile).use { output ->
                val buffer = ByteArray(8192)
                var downloadedSize = 0L
                var bytesRead: Int

                while (input.read(buffer).also { bytesRead = it } != -1) {
                    output.write(buffer, 0, bytesRead)
                    downloadedSize += bytesRead

                    val progress = if (totalSize > 0) {
                        ((downloadedSize * 100) / totalSize).toInt()
                    } else 0

                    // Update notification
                    updateNotification(task.title, progress)
                }
            }
        }

        connection.disconnect()
    }

    private fun buildNotification(title: String, progress: Int): Notification {
        return NotificationCompat.Builder(this, ShortReelsApp.CHANNEL_DOWNLOAD)
            .setSmallIcon(R.drawable.ic_download)
            .setContentTitle("Descargando")
            .setContentText(title)
            .setProgress(100, progress, progress == 0)
            .setOngoing(true)
            .setSilent(true)
            .build()
    }

    private fun updateNotification(title: String, progress: Int) {
        val notification = buildNotification(title, progress)
        val manager = getSystemService(NotificationManager::class.java)
        manager.notify(NOTIFICATION_ID, notification)
    }

    override fun onDestroy() {
        serviceScope.cancel()
        super.onDestroy()
    }

    data class DownloadTask(
        val videoId: String,
        val url: String,
        val title: String
    )

    companion object {
        const val ACTION_DOWNLOAD = "com.shortreels.DOWNLOAD"
        const val ACTION_CANCEL = "com.shortreels.CANCEL_DOWNLOAD"
        const val EXTRA_VIDEO_ID = "video_id"
        const val EXTRA_VIDEO_URL = "video_url"
        const val EXTRA_VIDEO_TITLE = "video_title"
        private const val NOTIFICATION_ID = 1001

        fun startDownload(context: Context, videoId: String, url: String, title: String) {
            val intent = Intent(context, VideoDownloadService::class.java).apply {
                action = ACTION_DOWNLOAD
                putExtra(EXTRA_VIDEO_ID, videoId)
                putExtra(EXTRA_VIDEO_URL, url)
                putExtra(EXTRA_VIDEO_TITLE, title)
            }
            context.startForegroundService(intent)
        }
    }
}
