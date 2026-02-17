package com.shortreels.data.repository;

import com.shortreels.data.local.dao.UserDao;
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
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<ShortReelsApiService> apiServiceProvider;

  private final Provider<UserDao> userDaoProvider;

  private final Provider<TokenManager> tokenManagerProvider;

  private final Provider<SessionManager> sessionManagerProvider;

  public AuthRepository_Factory(Provider<ShortReelsApiService> apiServiceProvider,
      Provider<UserDao> userDaoProvider, Provider<TokenManager> tokenManagerProvider,
      Provider<SessionManager> sessionManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.userDaoProvider = userDaoProvider;
    this.tokenManagerProvider = tokenManagerProvider;
    this.sessionManagerProvider = sessionManagerProvider;
  }

  @Override
  public AuthRepository get() {
    return newInstance(apiServiceProvider.get(), userDaoProvider.get(), tokenManagerProvider.get(), sessionManagerProvider.get());
  }

  public static AuthRepository_Factory create(Provider<ShortReelsApiService> apiServiceProvider,
      Provider<UserDao> userDaoProvider, Provider<TokenManager> tokenManagerProvider,
      Provider<SessionManager> sessionManagerProvider) {
    return new AuthRepository_Factory(apiServiceProvider, userDaoProvider, tokenManagerProvider, sessionManagerProvider);
  }

  public static AuthRepository newInstance(ShortReelsApiService apiService, UserDao userDao,
      TokenManager tokenManager, SessionManager sessionManager) {
    return new AuthRepository(apiService, userDao, tokenManager, sessionManager);
  }
}
