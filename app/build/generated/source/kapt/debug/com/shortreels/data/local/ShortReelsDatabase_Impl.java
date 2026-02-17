package com.shortreels.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.shortreels.data.local.dao.CommentDao;
import com.shortreels.data.local.dao.CommentDao_Impl;
import com.shortreels.data.local.dao.DownloadDao;
import com.shortreels.data.local.dao.DownloadDao_Impl;
import com.shortreels.data.local.dao.SearchHistoryDao;
import com.shortreels.data.local.dao.SearchHistoryDao_Impl;
import com.shortreels.data.local.dao.SeriesDao;
import com.shortreels.data.local.dao.SeriesDao_Impl;
import com.shortreels.data.local.dao.UserDao;
import com.shortreels.data.local.dao.UserDao_Impl;
import com.shortreels.data.local.dao.VideoDao;
import com.shortreels.data.local.dao.VideoDao_Impl;
import com.shortreels.data.local.dao.WatchHistoryDao;
import com.shortreels.data.local.dao.WatchHistoryDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ShortReelsDatabase_Impl extends ShortReelsDatabase {
  private volatile VideoDao _videoDao;

  private volatile SeriesDao _seriesDao;

  private volatile UserDao _userDao;

  private volatile CommentDao _commentDao;

  private volatile WatchHistoryDao _watchHistoryDao;

  private volatile DownloadDao _downloadDao;

  private volatile SearchHistoryDao _searchHistoryDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `videos` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `videoUrl` TEXT NOT NULL, `thumbnailUrl` TEXT NOT NULL, `hlsUrl` TEXT, `duration` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `season` INTEGER NOT NULL, `seriesId` TEXT NOT NULL, `seriesTitle` TEXT NOT NULL, `genre` TEXT NOT NULL, `tags` TEXT NOT NULL, `likeCount` INTEGER NOT NULL, `commentCount` INTEGER NOT NULL, `shareCount` INTEGER NOT NULL, `viewCount` INTEGER NOT NULL, `bookmarkCount` INTEGER NOT NULL, `isPremium` INTEGER NOT NULL, `isLocked` INTEGER NOT NULL, `coinsRequired` INTEGER NOT NULL, `unlockType` TEXT NOT NULL, `isLiked` INTEGER NOT NULL, `isBookmarked` INTEGER NOT NULL, `isDownloaded` INTEGER NOT NULL, `localPath` TEXT, `watchProgress` REAL NOT NULL, `authorId` TEXT NOT NULL, `authorUsername` TEXT NOT NULL, `authorDisplayName` TEXT NOT NULL, `authorAvatarUrl` TEXT NOT NULL, `authorIsVerified` INTEGER NOT NULL, `authorFollowerCount` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `cachedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `series` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `thumbnailUrl` TEXT NOT NULL, `bannerUrl` TEXT NOT NULL, `genre` TEXT NOT NULL, `tags` TEXT NOT NULL, `totalEpisodes` INTEGER NOT NULL, `authorId` TEXT NOT NULL, `authorUsername` TEXT NOT NULL, `authorDisplayName` TEXT NOT NULL, `authorAvatarUrl` TEXT NOT NULL, `rating` REAL NOT NULL, `reviewCount` INTEGER NOT NULL, `isPremium` INTEGER NOT NULL, `status` TEXT NOT NULL, `releaseSchedule` TEXT NOT NULL, `isFollowing` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `cachedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` TEXT NOT NULL, `username` TEXT NOT NULL, `displayName` TEXT NOT NULL, `email` TEXT NOT NULL, `avatarUrl` TEXT NOT NULL, `bio` TEXT NOT NULL, `followerCount` INTEGER NOT NULL, `followingCount` INTEGER NOT NULL, `isVerified` INTEGER NOT NULL, `subscriptionPlan` TEXT NOT NULL, `coins` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `cachedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `comments` (`id` TEXT NOT NULL, `videoId` TEXT NOT NULL, `userId` TEXT NOT NULL, `userDisplayName` TEXT NOT NULL, `userAvatarUrl` TEXT NOT NULL, `content` TEXT NOT NULL, `likeCount` INTEGER NOT NULL, `isLiked` INTEGER NOT NULL, `isPinned` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `watch_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `videoId` TEXT NOT NULL, `seriesId` TEXT NOT NULL, `episodeNumber` INTEGER NOT NULL, `watchProgress` REAL NOT NULL, `durationWatched` INTEGER NOT NULL, `completed` INTEGER NOT NULL, `watchedAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `downloads` (`videoId` TEXT NOT NULL, `title` TEXT NOT NULL, `seriesTitle` TEXT NOT NULL, `episodeNumber` INTEGER NOT NULL, `thumbnailUrl` TEXT NOT NULL, `localPath` TEXT, `fileSize` INTEGER NOT NULL, `downloadedSize` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `status` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `completedAt` INTEGER NOT NULL, PRIMARY KEY(`videoId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `search_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `query` TEXT NOT NULL, `searchedAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '468a115e33338b8600d9f4a1fce75a59')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `videos`");
        db.execSQL("DROP TABLE IF EXISTS `series`");
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `comments`");
        db.execSQL("DROP TABLE IF EXISTS `watch_history`");
        db.execSQL("DROP TABLE IF EXISTS `downloads`");
        db.execSQL("DROP TABLE IF EXISTS `search_history`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsVideos = new HashMap<String, TableInfo.Column>(36);
        _columnsVideos.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("videoUrl", new TableInfo.Column("videoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("thumbnailUrl", new TableInfo.Column("thumbnailUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("hlsUrl", new TableInfo.Column("hlsUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("episode", new TableInfo.Column("episode", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("season", new TableInfo.Column("season", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("seriesId", new TableInfo.Column("seriesId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("seriesTitle", new TableInfo.Column("seriesTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("genre", new TableInfo.Column("genre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("likeCount", new TableInfo.Column("likeCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("commentCount", new TableInfo.Column("commentCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("shareCount", new TableInfo.Column("shareCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("viewCount", new TableInfo.Column("viewCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("bookmarkCount", new TableInfo.Column("bookmarkCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("isPremium", new TableInfo.Column("isPremium", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("isLocked", new TableInfo.Column("isLocked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("coinsRequired", new TableInfo.Column("coinsRequired", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("unlockType", new TableInfo.Column("unlockType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("isLiked", new TableInfo.Column("isLiked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("isBookmarked", new TableInfo.Column("isBookmarked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("isDownloaded", new TableInfo.Column("isDownloaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("localPath", new TableInfo.Column("localPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("watchProgress", new TableInfo.Column("watchProgress", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("authorId", new TableInfo.Column("authorId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("authorUsername", new TableInfo.Column("authorUsername", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("authorDisplayName", new TableInfo.Column("authorDisplayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("authorAvatarUrl", new TableInfo.Column("authorAvatarUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("authorIsVerified", new TableInfo.Column("authorIsVerified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("authorFollowerCount", new TableInfo.Column("authorFollowerCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVideos.put("cachedAt", new TableInfo.Column("cachedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVideos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVideos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVideos = new TableInfo("videos", _columnsVideos, _foreignKeysVideos, _indicesVideos);
        final TableInfo _existingVideos = TableInfo.read(db, "videos");
        if (!_infoVideos.equals(_existingVideos)) {
          return new RoomOpenHelper.ValidationResult(false, "videos(com.shortreels.data.local.entities.VideoEntity).\n"
                  + " Expected:\n" + _infoVideos + "\n"
                  + " Found:\n" + _existingVideos);
        }
        final HashMap<String, TableInfo.Column> _columnsSeries = new HashMap<String, TableInfo.Column>(20);
        _columnsSeries.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("thumbnailUrl", new TableInfo.Column("thumbnailUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("bannerUrl", new TableInfo.Column("bannerUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("genre", new TableInfo.Column("genre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("totalEpisodes", new TableInfo.Column("totalEpisodes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("authorId", new TableInfo.Column("authorId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("authorUsername", new TableInfo.Column("authorUsername", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("authorDisplayName", new TableInfo.Column("authorDisplayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("authorAvatarUrl", new TableInfo.Column("authorAvatarUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("reviewCount", new TableInfo.Column("reviewCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("isPremium", new TableInfo.Column("isPremium", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("releaseSchedule", new TableInfo.Column("releaseSchedule", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("isFollowing", new TableInfo.Column("isFollowing", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeries.put("cachedAt", new TableInfo.Column("cachedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSeries = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSeries = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSeries = new TableInfo("series", _columnsSeries, _foreignKeysSeries, _indicesSeries);
        final TableInfo _existingSeries = TableInfo.read(db, "series");
        if (!_infoSeries.equals(_existingSeries)) {
          return new RoomOpenHelper.ValidationResult(false, "series(com.shortreels.data.local.entities.SeriesEntity).\n"
                  + " Expected:\n" + _infoSeries + "\n"
                  + " Found:\n" + _existingSeries);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(13);
        _columnsUsers.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("avatarUrl", new TableInfo.Column("avatarUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("bio", new TableInfo.Column("bio", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("followerCount", new TableInfo.Column("followerCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("followingCount", new TableInfo.Column("followingCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("isVerified", new TableInfo.Column("isVerified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("subscriptionPlan", new TableInfo.Column("subscriptionPlan", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("coins", new TableInfo.Column("coins", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("cachedAt", new TableInfo.Column("cachedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.shortreels.data.local.entities.UserEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsComments = new HashMap<String, TableInfo.Column>(10);
        _columnsComments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("videoId", new TableInfo.Column("videoId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("userDisplayName", new TableInfo.Column("userDisplayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("userAvatarUrl", new TableInfo.Column("userAvatarUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("likeCount", new TableInfo.Column("likeCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("isLiked", new TableInfo.Column("isLiked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("isPinned", new TableInfo.Column("isPinned", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComments.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesComments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoComments = new TableInfo("comments", _columnsComments, _foreignKeysComments, _indicesComments);
        final TableInfo _existingComments = TableInfo.read(db, "comments");
        if (!_infoComments.equals(_existingComments)) {
          return new RoomOpenHelper.ValidationResult(false, "comments(com.shortreels.data.local.entities.CommentEntity).\n"
                  + " Expected:\n" + _infoComments + "\n"
                  + " Found:\n" + _existingComments);
        }
        final HashMap<String, TableInfo.Column> _columnsWatchHistory = new HashMap<String, TableInfo.Column>(9);
        _columnsWatchHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("videoId", new TableInfo.Column("videoId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("seriesId", new TableInfo.Column("seriesId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("episodeNumber", new TableInfo.Column("episodeNumber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("watchProgress", new TableInfo.Column("watchProgress", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("durationWatched", new TableInfo.Column("durationWatched", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchHistory.put("watchedAt", new TableInfo.Column("watchedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWatchHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWatchHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWatchHistory = new TableInfo("watch_history", _columnsWatchHistory, _foreignKeysWatchHistory, _indicesWatchHistory);
        final TableInfo _existingWatchHistory = TableInfo.read(db, "watch_history");
        if (!_infoWatchHistory.equals(_existingWatchHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "watch_history(com.shortreels.data.local.entities.WatchHistoryEntity).\n"
                  + " Expected:\n" + _infoWatchHistory + "\n"
                  + " Found:\n" + _existingWatchHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsDownloads = new HashMap<String, TableInfo.Column>(13);
        _columnsDownloads.put("videoId", new TableInfo.Column("videoId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("seriesTitle", new TableInfo.Column("seriesTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("episodeNumber", new TableInfo.Column("episodeNumber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("thumbnailUrl", new TableInfo.Column("thumbnailUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("localPath", new TableInfo.Column("localPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("downloadedSize", new TableInfo.Column("downloadedSize", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("progress", new TableInfo.Column("progress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownloads.put("completedAt", new TableInfo.Column("completedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDownloads = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDownloads = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDownloads = new TableInfo("downloads", _columnsDownloads, _foreignKeysDownloads, _indicesDownloads);
        final TableInfo _existingDownloads = TableInfo.read(db, "downloads");
        if (!_infoDownloads.equals(_existingDownloads)) {
          return new RoomOpenHelper.ValidationResult(false, "downloads(com.shortreels.data.local.entities.DownloadEntity).\n"
                  + " Expected:\n" + _infoDownloads + "\n"
                  + " Found:\n" + _existingDownloads);
        }
        final HashMap<String, TableInfo.Column> _columnsSearchHistory = new HashMap<String, TableInfo.Column>(3);
        _columnsSearchHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSearchHistory.put("query", new TableInfo.Column("query", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSearchHistory.put("searchedAt", new TableInfo.Column("searchedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSearchHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSearchHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSearchHistory = new TableInfo("search_history", _columnsSearchHistory, _foreignKeysSearchHistory, _indicesSearchHistory);
        final TableInfo _existingSearchHistory = TableInfo.read(db, "search_history");
        if (!_infoSearchHistory.equals(_existingSearchHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "search_history(com.shortreels.data.local.entities.SearchHistoryEntity).\n"
                  + " Expected:\n" + _infoSearchHistory + "\n"
                  + " Found:\n" + _existingSearchHistory);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "468a115e33338b8600d9f4a1fce75a59", "9f14e0ed24ad211a381b861427fbae8e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "videos","series","users","comments","watch_history","downloads","search_history");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `videos`");
      _db.execSQL("DELETE FROM `series`");
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `comments`");
      _db.execSQL("DELETE FROM `watch_history`");
      _db.execSQL("DELETE FROM `downloads`");
      _db.execSQL("DELETE FROM `search_history`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(VideoDao.class, VideoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SeriesDao.class, SeriesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CommentDao.class, CommentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WatchHistoryDao.class, WatchHistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DownloadDao.class, DownloadDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SearchHistoryDao.class, SearchHistoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public VideoDao videoDao() {
    if (_videoDao != null) {
      return _videoDao;
    } else {
      synchronized(this) {
        if(_videoDao == null) {
          _videoDao = new VideoDao_Impl(this);
        }
        return _videoDao;
      }
    }
  }

  @Override
  public SeriesDao seriesDao() {
    if (_seriesDao != null) {
      return _seriesDao;
    } else {
      synchronized(this) {
        if(_seriesDao == null) {
          _seriesDao = new SeriesDao_Impl(this);
        }
        return _seriesDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public CommentDao commentDao() {
    if (_commentDao != null) {
      return _commentDao;
    } else {
      synchronized(this) {
        if(_commentDao == null) {
          _commentDao = new CommentDao_Impl(this);
        }
        return _commentDao;
      }
    }
  }

  @Override
  public WatchHistoryDao watchHistoryDao() {
    if (_watchHistoryDao != null) {
      return _watchHistoryDao;
    } else {
      synchronized(this) {
        if(_watchHistoryDao == null) {
          _watchHistoryDao = new WatchHistoryDao_Impl(this);
        }
        return _watchHistoryDao;
      }
    }
  }

  @Override
  public DownloadDao downloadDao() {
    if (_downloadDao != null) {
      return _downloadDao;
    } else {
      synchronized(this) {
        if(_downloadDao == null) {
          _downloadDao = new DownloadDao_Impl(this);
        }
        return _downloadDao;
      }
    }
  }

  @Override
  public SearchHistoryDao searchHistoryDao() {
    if (_searchHistoryDao != null) {
      return _searchHistoryDao;
    } else {
      synchronized(this) {
        if(_searchHistoryDao == null) {
          _searchHistoryDao = new SearchHistoryDao_Impl(this);
        }
        return _searchHistoryDao;
      }
    }
  }
}
