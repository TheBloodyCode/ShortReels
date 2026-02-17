package com.shortreels.utils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.shortreels.workers.VideoDownloadWorker;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

/**
 * Manages video download scheduling using WorkManager.
 * Written in Java for interoperability demonstration.
 */
@Singleton
public class DownloadManager {

    private static final String TAG = "DownloadManager";
    private static final String KEY_VIDEO_ID = "video_id";
    private static final String KEY_VIDEO_URL = "video_url";
    private static final String KEY_TITLE = "title";

    private final WorkManager workManager;

    @Inject
    public DownloadManager(@ApplicationContext Context context) {
        this.workManager = WorkManager.getInstance(context);
    }

    /**
     * Schedule a video download.
     * @param videoId Unique video identifier
     * @param videoUrl URL of the video to download
     * @param title Display title for notifications
     */
    public void scheduleDownload(
            @NonNull String videoId,
            @NonNull String videoUrl,
            @NonNull String title
    ) {
        Log.d(TAG, "Scheduling download for: " + title);

        Data inputData = new Data.Builder()
                .putString(KEY_VIDEO_ID, videoId)
                .putString(KEY_VIDEO_URL, videoUrl)
                .putString(KEY_TITLE, title)
                .build();

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresStorageNotLow(true)
                .build();

        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(VideoDownloadWorker.class)
                .setInputData(inputData)
                .setConstraints(constraints)
                .addTag("download_" + videoId)
                .build();

        workManager.enqueue(request);
    }

    /**
     * Cancel a pending or running download.
     * @param videoId Video identifier to cancel
     */
    public void cancelDownload(@NonNull String videoId) {
        Log.d(TAG, "Cancelling download for: " + videoId);
        workManager.cancelAllWorkByTag("download_" + videoId);
    }

    /**
     * Cancel all downloads.
     */
    public void cancelAll() {
        workManager.cancelAllWork();
    }
}
