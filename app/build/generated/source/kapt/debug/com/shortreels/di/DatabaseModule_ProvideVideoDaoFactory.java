package com.shortreels.di;

import com.shortreels.data.local.ShortReelsDatabase;
import com.shortreels.data.local.dao.VideoDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideVideoDaoFactory implements Factory<VideoDao> {
  private final Provider<ShortReelsDatabase> dbProvider;

  public DatabaseModule_ProvideVideoDaoFactory(Provider<ShortReelsDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public VideoDao get() {
    return provideVideoDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideVideoDaoFactory create(
      Provider<ShortReelsDatabase> dbProvider) {
    return new DatabaseModule_ProvideVideoDaoFactory(dbProvider);
  }

  public static VideoDao provideVideoDao(ShortReelsDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideVideoDao(db));
  }
}
