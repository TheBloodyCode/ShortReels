package com.shortreels.data.repository;

import com.shortreels.data.local.dao.SeriesDao;
import com.shortreels.data.remote.api.ShortReelsApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class SeriesRepository_Factory implements Factory<SeriesRepository> {
  private final Provider<ShortReelsApiService> apiServiceProvider;

  private final Provider<SeriesDao> seriesDaoProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  public SeriesRepository_Factory(Provider<ShortReelsApiService> apiServiceProvider,
      Provider<SeriesDao> seriesDaoProvider, Provider<TokenManager> tokenManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.seriesDaoProvider = seriesDaoProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public SeriesRepository get() {
    return newInstance(apiServiceProvider.get(), seriesDaoProvider.get(), tokenManagerProvider.get());
  }

  public static SeriesRepository_Factory create(Provider<ShortReelsApiService> apiServiceProvider,
      Provider<SeriesDao> seriesDaoProvider, Provider<TokenManager> tokenManagerProvider) {
    return new SeriesRepository_Factory(apiServiceProvider, seriesDaoProvider, tokenManagerProvider);
  }

  public static SeriesRepository newInstance(ShortReelsApiService apiService, SeriesDao seriesDao,
      TokenManager tokenManager) {
    return new SeriesRepository(apiService, seriesDao, tokenManager);
  }
}
