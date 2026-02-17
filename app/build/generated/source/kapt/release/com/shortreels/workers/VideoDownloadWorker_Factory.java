package com.shortreels.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class VideoDownloadWorker_Factory {
  public VideoDownloadWorker_Factory() {
  }

  public VideoDownloadWorker get(Context context, WorkerParameters workerParams) {
    return newInstance(context, workerParams);
  }

  public static VideoDownloadWorker_Factory create() {
    return new VideoDownloadWorker_Factory();
  }

  public static VideoDownloadWorker newInstance(Context context, WorkerParameters workerParams) {
    return new VideoDownloadWorker(context, workerParams);
  }
}
