package com.shortreels.data.repository;

import com.shortreels.data.local.dao.VideoDao;
import com.shortreels.data.remote.api.PipedApi;
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
public final class VideoRepository_Factory implements Factory<VideoRepository> {
  private final Provider<ShortReelsApiService> apiServiceProvider;

  private final Provider<PipedApi> pipedApiProvider;

  private final Provider<VideoDao> videoDaoProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  public VideoRepository_Factory(Provider<ShortReelsApiService> apiServiceProvider,
      Provider<PipedApi> pipedApiProvider, Provider<VideoDao> videoDaoProvider,
      Provider<TokenManager> tokenManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.pipedApiProvider = pipedApiProvider;
    this.videoDaoProvider = videoDaoProvider;
    this.tokenManagerProvider = tokenManagerProvider;
  }

  @Override
  public VideoRepository get() {
    return newInstance(apiServiceProvider.get(), pipedApiProvider.get(), videoDaoProvider.get(), tokenManagerProvider.get());
  }

  public static VideoRepository_Factory create(Provider<ShortReelsApiService> apiServiceProvider,
      Provider<PipedApi> pipedApiProvider, Provider<VideoDao> videoDaoProvider,
      Provider<TokenManager> tokenManagerProvider) {
    return new VideoRepository_Factory(apiServiceProvider, pipedApiProvider, videoDaoProvider, tokenManagerProvider);
  }

  public static VideoRepository newInstance(ShortReelsApiService apiService, PipedApi pipedApi,
      VideoDao videoDao, TokenManager tokenManager) {
    return new VideoRepository(apiService, pipedApi, videoDao, tokenManager);
  }
}
