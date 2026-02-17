package com.shortreels.di;

import com.shortreels.data.local.dao.VideoDao;
import com.shortreels.data.remote.api.PipedApi;
import com.shortreels.data.remote.api.ShortReelsApiService;
import com.shortreels.data.repository.TokenManager;
import com.shortreels.data.repository.VideoRepository;
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
public final class RepositoryModule_ProvideVideoRepositoryFactory implements Factory<VideoRepository> {
  private final Provider<ShortReelsApiService> apiServiceProvider;

  private final Provider<PipedApi> pipedApiProvider;

  private final Provider<VideoDao> videoDaoProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  public RepositoryModule_ProvideVideoRepositoryFactory(
      Provider<ShortReelsApiService> apiServiceProvider, Provider<PipedApi> pipedApiProvider,
      Provider<VideoDao> videoDaoProvider, Provider<TokenManager> tokenManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.pipedApiProvider = pipedApiProvider;
    this.videoDaoProvider = videoDaoProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public VideoRepository get() {
    return provideVideoRepository(apiServiceProvider.get(), pipedApiProvider.get(), videoDaoProvider.get(), tokenManagerProvider.get());
  }

  public static RepositoryModule_ProvideVideoRepositoryFactory create(
      Provider<ShortReelsApiService> apiServiceProvider, Provider<PipedApi> pipedApiProvider,
      Provider<VideoDao> videoDaoProvider, Provider<TokenManager> tokenManagerProvider) {
    return new RepositoryModule_ProvideVideoRepositoryFactory(apiServiceProvider, pipedApiProvider, videoDaoProvider, tokenManagerProvider);
  }

  public static VideoRepository provideVideoRepository(ShortReelsApiService apiService,
      PipedApi pipedApi, VideoDao videoDao, TokenManager tokenManager) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideVideoRepository(apiService, pipedApi, videoDao, tokenManager));
  }
}
