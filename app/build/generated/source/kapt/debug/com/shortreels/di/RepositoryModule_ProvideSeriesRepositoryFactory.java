package com.shortreels.di;

import com.shortreels.data.local.dao.SeriesDao;
import com.shortreels.data.remote.api.ShortReelsApiService;
import com.shortreels.data.repository.SeriesRepository;
import com.shortreels.data.repository.TokenManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class RepositoryModule_ProvideSeriesRepositoryFactory implements Factory<SeriesRepository> {
  private final Provider<ShortReelsApiService> apiServiceProvider;

  private final Provider<SeriesDao> seriesDaoProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  public RepositoryModule_ProvideSeriesRepositoryFactory(
      Provider<ShortReelsApiService> apiServiceProvider, Provider<SeriesDao> seriesDaoProvider,
      Provider<TokenManager> tokenManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.seriesDaoProvider = seriesDaoProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public SeriesRepository get() {
    return provideSeriesRepository(apiServiceProvider.get(), seriesDaoProvider.get(), tokenManagerProvider.get());
  }

  public static RepositoryModule_ProvideSeriesRepositoryFactory create(
      Provider<ShortReelsApiService> apiServiceProvider, Provider<SeriesDao> seriesDaoProvider,
      Provider<TokenManager> tokenManagerProvider) {
    return new RepositoryModule_ProvideSeriesRepositoryFactory(apiServiceProvider, seriesDaoProvider, tokenManagerProvider);
  }

  public static SeriesRepository provideSeriesRepository(ShortReelsApiService apiService,
      SeriesDao seriesDao, TokenManager tokenManager) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideSeriesRepository(apiService, seriesDao, tokenManager));
  }
}
