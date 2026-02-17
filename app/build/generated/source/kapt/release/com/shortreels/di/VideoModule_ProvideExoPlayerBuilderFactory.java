package com.shortreels.di;

import android.content.Context;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.ExoPlayer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class VideoModule_ProvideExoPlayerBuilderFactory implements Factory<ExoPlayer.Builder> {
  private final Provider<Context> contextProvider;

  private final Provider<DataSource.Factory> dataSourceFactoryProvider;

  public VideoModule_ProvideExoPlayerBuilderFactory(Provider<Context> contextProvider,
      Provider<DataSource.Factory> dataSourceFactoryProvider) {
    this.contextProvider = contextProvider;
    this.dataSourceFactoryProvider = dataSourceFactoryProvider;
  }

  @Override
  public ExoPlayer.Builder get() {
    return provideExoPlayerBuilder(contextProvider.get(), dataSourceFactoryProvider.get());
  }

  public static VideoModule_ProvideExoPlayerBuilderFactory create(Provider<Context> contextProvider,
      Provider<DataSource.Factory> dataSourceFactoryProvider) {
    return new VideoModule_ProvideExoPlayerBuilderFactory(contextProvider, dataSourceFactoryProvider);
  }

  public static ExoPlayer.Builder provideExoPlayerBuilder(Context context,
      DataSource.Factory dataSourceFactory) {
    return Preconditions.checkNotNullFromProvides(VideoModule.INSTANCE.provideExoPlayerBuilder(context, dataSourceFactory));
  }
}
