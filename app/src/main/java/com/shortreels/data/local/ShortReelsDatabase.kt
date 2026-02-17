package com.shortreels.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.shortreels.data.local.dao.*
import com.shortreels.data.local.entities.*

/**
 * ShortReels Room Database
 * Single source of truth for all local persistence.
 * Version bumps require migrations defined in Migrations.kt
 */
@Database(
    entities = [
        VideoEntity::class,
        SeriesEntity::class,
        UserEntity::class,
        CommentEntity::class,
        WatchHistoryEntity::class,
        DownloadEntity::class,
        SearchHistoryEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class ShortReelsDatabase : RoomDatabase() {

    abstract fun videoDao(): VideoDao
    abstract fun seriesDao(): SeriesDao
    abstract fun userDao(): UserDao
    abstract fun commentDao(): CommentDao
    abstract fun watchHistoryDao(): WatchHistoryDao
    abstract fun downloadDao(): DownloadDao
    abstract fun searchHistoryDao(): SearchHistoryDao

    companion object {
        private const val DB_NAME = "shortreels_database.db"

        @Volatile
        private var INSTANCE: ShortReelsDatabase? = null

        fun getInstance(context: Context): ShortReelsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShortReelsDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
