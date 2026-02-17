package com.shortreels.workers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.net.URL

@HiltWorker
class VideoDownloadWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    companion object {
        const val KEY_VIDEO_ID = "video_id"
        const val KEY_VIDEO_URL = "video_url"
        const val KEY_TITLE = "title"
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val videoId = inputData.getString(KEY_VIDEO_ID) ?: return@withContext Result.failure()
        val videoUrl = inputData.getString(KEY_VIDEO_URL) ?: return@withContext Result.failure()
        val title = inputData.getString(KEY_TITLE) ?: "Video"

        return@withContext try {
            Log.d("DownloadWorker", "Starting download: $title")

            val downloadDir = File(applicationContext.getExternalFilesDir(null), "videos")
            if (!downloadDir.exists()) downloadDir.mkdirs()

            val file = File(downloadDir, "$videoId.mp4")
            if (file.exists()) {
                Log.d("DownloadWorker", "File already exists: $videoId")
                return@withContext Result.success()
            }

            URL(videoUrl).openStream().use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

            Log.d("DownloadWorker", "Download complete: $title")
            Result.success()
        } catch (e: Exception) {
            Log.e("DownloadWorker", "Download failed", e)
            if (runAttemptCount < 3) Result.retry() else Result.failure()
        }
    }
}
