package com.shortreels.presentation.ui.player;

import android.content.Context;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.exoplayer.ExoPlayer;
import com.shortreels.data.remote.api.ExtractorApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class VideoPlayerManager_Factory implements Factory<VideoPlayerManager> {
  private final Provider<Context> contextProvider;

  private final Provider<ExoPlayer.Builder> playerBuilderProvider;

  private final Provider<DataSource.Factory> dataSourceFactoryProvider;

  private final Provider<Cache> cacheProvider;

  private final Provider<ExtractorApi> extractorApiProvider;

  public VideoPlayerManager_Factory(Provider<Context> contextProvider,
      Provider<ExoPlayer.Builder> playerBuilderProvider,
      Provider<DataSource.Factory> dataSourceFactoryProvider, Provider<Cache> cacheProvider,
      Provider<ExtractorApi> extractorApiProvider) {
    this.contextProvider = contextProvider;
    this.playerBuilderProvider = playerBuilderProvider;
    this.dataSourceFactoryProvider = dataSourceFactoryProvider;
    this.cacheProvider = cacheProvider;
    this.extractorApiProvider = extractorApiProvider;
  }

  @Override
  public VideoPlayerManager get() {
    return newInstance(contextProvider.get(), playerBuilderProvider.get(), dataSourceFactoryProvider.get(), cacheProvider.get(), extractorApiProvider);
  }

  public static VideoPlayerManager_Factory create(Provider<Context> contextProvider,
      Provider<ExoPlayer.Builder> playerBuilderProvider,
      Provider<DataSource.Factory> dataSourceFactoryProvider, Provider<Cache> cacheProvider,
      Provider<ExtractorApi> extractorApiProvider) {
    return new VideoPlayerManager_Factory(contextProvider, playerBuilderProvider, dataSourceFactoryProvider, cacheProvider, extractorApiProvider);
  }

  public static VideoPlayerManager newInstance(Context context, ExoPlayer.Builder playerBuilder,
      DataSource.Factory dataSourceFactory, Cache cache,
      Provider<ExtractorApi> extractorApiProvider) {
    return new VideoPlayerManager(context, playerBuilder, dataSourceFactory, cache, extractorApiProvider);
  }
}
