package com.shortreels.di

import android.content.Context
import androidx.room.Room
import com.shortreels.BuildConfig
import com.shortreels.data.local.ShortReelsDatabase
import com.shortreels.data.local.dao.*
import com.shortreels.data.remote.api.ExtractorApi
import com.shortreels.data.remote.api.ShortReelsApiService
import com.shortreels.data.repository.*
import com.shortreels.utils.NetworkResult
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// ===== Database Module =====
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ShortReelsDatabase {
        return Room.databaseBuilder(
            context,
            ShortReelsDatabase::class.java,
            "shortreels_database.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides fun provideVideoDao(db: ShortReelsDatabase): VideoDao = db.videoDao()
    @Provides fun provideSeriesDao(db: ShortReelsDatabase): SeriesDao = db.seriesDao()
    @Provides fun provideUserDao(db: ShortReelsDatabase): UserDao = db.userDao()
    @Provides fun provideCommentDao(db: ShortReelsDatabase): CommentDao = db.commentDao()
    @Provides fun provideWatchHistoryDao(db: ShortReelsDatabase): WatchHistoryDao = db.watchHistoryDao()
    @Provides fun provideDownloadDao(db: ShortReelsDatabase): DownloadDao = db.downloadDao()
    @Provides fun provideSearchHistoryDao(db: ShortReelsDatabase): SearchHistoryDao = db.searchHistoryDao()
}

// ===== Network Module =====
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager =
        TokenManager(context)

    @Provides
    @Singleton
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager =
        SessionManager(context)

    @Provides
    @Singleton
    fun provideOkHttpClient(tokenManager: TokenManager): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
        }

        val authInterceptor = Interceptor { chain ->
            val original = chain.request()
            // Skip if request already has Authorization
            if (original.header("Authorization") != null) {
                return@Interceptor chain.proceed(original)
            }
            val token = tokenManager.getToken()
            val request = if (token != null) {
                original.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build()
            } else original
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ShortReelsApiService {
        return retrofit.create(ShortReelsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideExtractorApi(okHttpClient: OkHttpClient): ExtractorApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.EXTRACTOR_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExtractorApi::class.java)
    }

}

// ===== Repository Module =====
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideVideoRepository(
        apiService: ShortReelsApiService,
        extractorApi: ExtractorApi,
        videoDao: VideoDao,
        tokenManager: TokenManager
    ): VideoRepository = VideoRepository(apiService, extractorApi, videoDao, tokenManager)

    @Provides
    @Singleton
    fun provideSeriesRepository(
        apiService: ShortReelsApiService,
        seriesDao: SeriesDao,
        tokenManager: TokenManager
    ): SeriesRepository = SeriesRepository(apiService, seriesDao, tokenManager)

    @Provides
    @Singleton
    fun provideAuthRepository(
        apiService: ShortReelsApiService,
        userDao: UserDao,
        tokenManager: TokenManager,
        sessionManager: SessionManager
    ): AuthRepository = AuthRepository(apiService, userDao, tokenManager, sessionManager)
}
