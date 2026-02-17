package com.shortreels.di;

import android.content.Context;
import androidx.room.Room;
import com.shortreels.BuildConfig;
import com.shortreels.data.local.ShortReelsDatabase;
import com.shortreels.data.local.dao.*;
import com.shortreels.data.remote.api.ShortReelsApiService;
import com.shortreels.data.repository.*;
import com.shortreels.utils.NetworkResult;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0007J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/shortreels/di/RepositoryModule;", "", "()V", "provideAuthRepository", "Lcom/shortreels/data/repository/AuthRepository;", "apiService", "Lcom/shortreels/data/remote/api/ShortReelsApiService;", "userDao", "Lcom/shortreels/data/local/dao/UserDao;", "tokenManager", "Lcom/shortreels/data/repository/TokenManager;", "sessionManager", "Lcom/shortreels/data/repository/SessionManager;", "provideSeriesRepository", "Lcom/shortreels/data/repository/SeriesRepository;", "seriesDao", "Lcom/shortreels/data/local/dao/SeriesDao;", "provideVideoRepository", "Lcom/shortreels/data/repository/VideoRepository;", "pipedApi", "Lcom/shortreels/data/remote/api/PipedApi;", "videoDao", "Lcom/shortreels/data/local/dao/VideoDao;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.repository.VideoRepository provideVideoRepository(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.ShortReelsApiService apiService, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.PipedApi pipedApi, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.dao.VideoDao videoDao, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.TokenManager tokenManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.repository.SeriesRepository provideSeriesRepository(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.ShortReelsApiService apiService, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.dao.SeriesDao seriesDao, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.TokenManager tokenManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.repository.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.api.ShortReelsApiService apiService, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.TokenManager tokenManager, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.repository.SessionManager sessionManager) {
        return null;
    }
}