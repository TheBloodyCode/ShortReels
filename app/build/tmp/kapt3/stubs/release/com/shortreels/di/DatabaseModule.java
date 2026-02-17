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
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/shortreels/di/DatabaseModule;", "", "()V", "provideCommentDao", "Lcom/shortreels/data/local/dao/CommentDao;", "db", "Lcom/shortreels/data/local/ShortReelsDatabase;", "provideDatabase", "context", "Landroid/content/Context;", "provideDownloadDao", "Lcom/shortreels/data/local/dao/DownloadDao;", "provideSearchHistoryDao", "Lcom/shortreels/data/local/dao/SearchHistoryDao;", "provideSeriesDao", "Lcom/shortreels/data/local/dao/SeriesDao;", "provideUserDao", "Lcom/shortreels/data/local/dao/UserDao;", "provideVideoDao", "Lcom/shortreels/data/local/dao/VideoDao;", "provideWatchHistoryDao", "Lcom/shortreels/data/local/dao/WatchHistoryDao;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.ShortReelsDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.dao.VideoDao provideVideoDao(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.ShortReelsDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.dao.SeriesDao provideSeriesDao(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.ShortReelsDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.ShortReelsDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.dao.CommentDao provideCommentDao(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.ShortReelsDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.dao.WatchHistoryDao provideWatchHistoryDao(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.ShortReelsDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.dao.DownloadDao provideDownloadDao(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.ShortReelsDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.dao.SearchHistoryDao provideSearchHistoryDao(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.ShortReelsDatabase db) {
        return null;
    }
}