package com.shortreels.di;

import com.shortreels.data.remote.api.PipedApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class NetworkModule_ProvidePipedApiFactory implements Factory<PipedApi> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_ProvidePipedApiFactory(Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public PipedApi get() {
    return providePipedApi(okHttpClientProvider.get());
  }

  public static NetworkModule_ProvidePipedApiFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_ProvidePipedApiFactory(okHttpClientProvider);
  }

  public static PipedApi providePipedApi(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providePipedApi(okHttpClient));
  }
}
