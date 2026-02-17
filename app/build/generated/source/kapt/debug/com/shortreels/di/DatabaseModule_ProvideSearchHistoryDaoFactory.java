package com.shortreels.di;

import com.shortreels.data.local.ShortReelsDatabase;
import com.shortreels.data.local.dao.SearchHistoryDao;
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
public final class DatabaseModule_ProvideSearchHistoryDaoFactory implements Factory<SearchHistoryDao> {
  private final Provider<ShortReelsDatabase> dbProvider;

  public DatabaseModule_ProvideSearchHistoryDaoFactory(Provider<ShortReelsDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public SearchHistoryDao get() {
    return provideSearchHistoryDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideSearchHistoryDaoFactory create(
      Provider<ShortReelsDatabase> dbProvider) {
    return new DatabaseModule_ProvideSearchHistoryDaoFactory(dbProvider);
  }

  public static SearchHistoryDao provideSearchHistoryDao(ShortReelsDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideSearchHistoryDao(db));
  }
}
