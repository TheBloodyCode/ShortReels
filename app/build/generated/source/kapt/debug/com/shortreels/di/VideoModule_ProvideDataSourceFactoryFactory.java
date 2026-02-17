package com.shortreels.di;

import android.content.Context;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.cache.Cache;
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
public final class VideoModule_ProvideDataSourceFactoryFactory implements Factory<DataSource.Factory> {
  private final Provider<Context> contextProvider;

  private final Provider<Cache> cacheProvider;

  public VideoModule_ProvideDataSourceFactoryFactory(Provider<Context> contextProvider,
      Provider<Cache> cacheProvider) {
    this.contextProvider = contextProvider;
    this.cacheProvider = cacheProvider;
  }

  @Override
  public DataSource.Factory get() {
    return provideDataSourceFactory(contextProvider.get(), cacheProvider.get());
  }

  public static VideoModule_ProvideDataSourceFactoryFactory create(
      Provider<Context> contextProvider, Provider<Cache> cacheProvider) {
    return new VideoModule_ProvideDataSourceFactoryFactory(contextProvider, cacheProvider);
  }

  public static DataSource.Factory provideDataSourceFactory(Context context, Cache cache) {
    return Preconditions.checkNotNullFromProvides(VideoModule.INSTANCE.provideDataSourceFactory(context, cache));
  }
}
