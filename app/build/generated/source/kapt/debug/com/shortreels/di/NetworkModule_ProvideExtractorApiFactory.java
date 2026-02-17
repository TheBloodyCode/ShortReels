package com.shortreels.di;

import com.shortreels.data.remote.api.ExtractorApi;
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
public final class NetworkModule_ProvideExtractorApiFactory implements Factory<ExtractorApi> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_ProvideExtractorApiFactory(Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public ExtractorApi get() {
    return provideExtractorApi(okHttpClientProvider.get());
  }

  public static NetworkModule_ProvideExtractorApiFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_ProvideExtractorApiFactory(okHttpClientProvider);
  }

  public static ExtractorApi provideExtractorApi(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideExtractorApi(okHttpClient));
  }
}
