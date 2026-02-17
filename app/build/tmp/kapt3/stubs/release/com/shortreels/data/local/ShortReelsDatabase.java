package com.shortreels.data.local;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;
import com.shortreels.data.local.dao.*;
import com.shortreels.data.local.entities.*;

/**
 * ShortReels Room Database
 * Single source of truth for all local persistence.
 * Version bumps require migrations defined in Migrations.kt
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/shortreels/data/local/ShortReelsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "commentDao", "Lcom/shortreels/data/local/dao/CommentDao;", "downloadDao", "Lcom/shortreels/data/local/dao/DownloadDao;", "searchHistoryDao", "Lcom/shortreels/data/local/dao/SearchHistoryDao;", "seriesDao", "Lcom/shortreels/data/local/dao/SeriesDao;", "userDao", "Lcom/shortreels/data/local/dao/UserDao;", "videoDao", "Lcom/shortreels/data/local/dao/VideoDao;", "watchHistoryDao", "Lcom/shortreels/data/local/dao/WatchHistoryDao;", "Companion", "app_release"})
@androidx.room.Database(entities = {com.shortreels.data.local.entities.VideoEntity.class, com.shortreels.data.local.entities.SeriesEntity.class, com.shortreels.data.local.entities.UserEntity.class, com.shortreels.data.local.entities.CommentEntity.class, com.shortreels.data.local.entities.WatchHistoryEntity.class, com.shortreels.data.local.entities.DownloadEntity.class, com.shortreels.data.local.entities.SearchHistoryEntity.class}, version = 1, exportSchema = true)
@androidx.room.TypeConverters(value = {com.shortreels.data.local.dao.Converters.class})
public abstract class ShortReelsDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DB_NAME = "shortreels_database.db";
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.shortreels.data.local.ShortReelsDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.data.local.ShortReelsDatabase.Companion Companion = null;
    
    public ShortReelsDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.shortreels.data.local.dao.VideoDao videoDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.shortreels.data.local.dao.SeriesDao seriesDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.shortreels.data.local.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.shortreels.data.local.dao.CommentDao commentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.shortreels.data.local.dao.WatchHistoryDao watchHistoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.shortreels.data.local.dao.DownloadDao downloadDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.shortreels.data.local.dao.SearchHistoryDao searchHistoryDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/shortreels/data/local/ShortReelsDatabase$Companion;", "", "()V", "DB_NAME", "", "INSTANCE", "Lcom/shortreels/data/local/ShortReelsDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shortreels.data.local.ShortReelsDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}