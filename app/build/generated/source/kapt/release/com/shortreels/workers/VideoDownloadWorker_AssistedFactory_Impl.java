package com.shortreels.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class VideoDownloadWorker_AssistedFactory_Impl implements VideoDownloadWorker_AssistedFactory {
  private final VideoDownloadWorker_Factory delegateFactory;

  VideoDownloadWorker_AssistedFactory_Impl(VideoDownloadWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public VideoDownloadWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<VideoDownloadWorker_AssistedFactory> create(
      VideoDownloadWorker_Factory delegateFactory) {
    return InstanceFactory.create(new VideoDownloadWorker_AssistedFactory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<VideoDownloadWorker_AssistedFactory> createFactoryProvider(
      VideoDownloadWorker_Factory delegateFactory) {
    return InstanceFactory.create(new VideoDownloadWorker_AssistedFactory_Impl(delegateFactory));
  }
}
