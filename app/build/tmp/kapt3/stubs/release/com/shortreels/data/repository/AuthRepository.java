package com.shortreels.data.repository;

import com.shortreels.data.local.dao.*;
import com.shortreels.data.local.entities.*;
import com.shortreels.data.remote.api.ShortReelsApiService;
import com.shortreels.data.remote.models.*;
import com.shortreels.domain.model.*;
import com.shortreels.utils.NetworkResult;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * AuthRepository - Java-friendly with coroutines
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/shortreels/data/repository/AuthRepository;", "", "apiService", "Lcom/shortreels/data/remote/api/ShortReelsApiService;", "userDao", "Lcom/shortreels/data/local/dao/UserDao;", "tokenManager", "Lcom/shortreels/data/repository/TokenManager;", "sessionManager", "Lcom/shortreels/data/repository/SessionManager;", "(Lcom/shortreels/data/remote/api/ShortReelsApiService;Lcom/shortreels/data/local/dao/UserDao;Lcom/shortreels/data/repository/TokenManager;Lcom/shortreels/data/repository/SessionManager;)V", "getCurrentUser", "Lkotlinx/coroutines/flow/Flow;", "Lcom/shortreels/domain/model/User;", "isLoggedIn", "", "login", "Lcom/shortreels/utils/NetworkResult;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "username", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.remote.api.ShortReelsApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.local.dao.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.repository.TokenManager tokenManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.repository.SessionManager sessionManager = null;
    
    @javax.inject.Inject()
    public AuthRepository(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.ShortReelsApiService apiService, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.TokenManager tokenManager, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.SessionManager sessionManager) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.utils.NetworkResult<com.shortreels.domain.model.User>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object register(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.utils.NetworkResult<com.shortreels.domain.model.User>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.shortreels.domain.model.User> getCurrentUser() {
        return null;
    }
}