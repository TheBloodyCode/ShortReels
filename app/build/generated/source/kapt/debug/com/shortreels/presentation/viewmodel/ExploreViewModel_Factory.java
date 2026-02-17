package com.shortreels.presentation.viewmodel;

import com.shortreels.data.repository.SeriesRepository;
import com.shortreels.data.repository.VideoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ExploreViewModel_Factory implements Factory<ExploreViewModel> {
  private final Provider<VideoRepository> videoRepositoryProvider;

  private final Provider<SeriesRepository> seriesRepositoryProvider;

  public ExploreViewModel_Factory(Provider<VideoRepository> videoRepositoryProvider,
      Provider<SeriesRepository> seriesRepositoryProvider) {
    this.videoRepositoryProvider = videoRepositoryProvider;
    this.seriesRepositoryProvider = seriesRepositoryProvider;
  }

  @Override
  public ExploreViewModel get() {
    return newInstance(videoRepositoryProvider.get(), seriesRepositoryProvider.get());
  }

  public static ExploreViewModel_Factory create(Provider<VideoRepository> videoRepositoryProvider,
      Provider<SeriesRepository> seriesRepositoryProvider) {
    return new ExploreViewModel_Factory(videoRepositoryProvider, seriesRepositoryProvider);
  }

  public static ExploreViewModel newInstance(VideoRepository videoRepository,
      SeriesRepository seriesRepository) {
    return new ExploreViewModel(videoRepository, seriesRepository);
  }
}
