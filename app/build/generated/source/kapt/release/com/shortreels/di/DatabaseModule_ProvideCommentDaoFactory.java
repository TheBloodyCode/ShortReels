package com.shortreels.di;

import com.shortreels.data.local.ShortReelsDatabase;
import com.shortreels.data.local.dao.CommentDao;
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
public final class DatabaseModule_ProvideCommentDaoFactory implements Factory<CommentDao> {
  private final Provider<ShortReelsDatabase> dbProvider;

  public DatabaseModule_ProvideCommentDaoFactory(Provider<ShortReelsDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CommentDao get() {
    return provideCommentDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideCommentDaoFactory create(
      Provider<ShortReelsDatabase> dbProvider) {
    return new DatabaseModule_ProvideCommentDaoFactory(dbProvider);
  }

  public static CommentDao provideCommentDao(ShortReelsDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCommentDao(db));
  }
}
