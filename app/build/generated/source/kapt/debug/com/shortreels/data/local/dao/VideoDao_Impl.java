package com.shortreels.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.shortreels.data.local.entities.VideoEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VideoDao_Impl implements VideoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<VideoEntity> __insertionAdapterOfVideoEntity;

  private final EntityDeletionOrUpdateAdapter<VideoEntity> __updateAdapterOfVideoEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLikeStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBookmarkStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWatchProgress;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDownloadStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldCache;

  private final SharedSQLiteStatement __preparedStmtOfDeleteVideo;

  public VideoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVideoEntity = new EntityInsertionAdapter<VideoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `videos` (`id`,`title`,`description`,`videoUrl`,`thumbnailUrl`,`hlsUrl`,`duration`,`episode`,`season`,`seriesId`,`seriesTitle`,`genre`,`tags`,`likeCount`,`commentCount`,`shareCount`,`viewCount`,`bookmarkCount`,`isPremium`,`isLocked`,`coinsRequired`,`unlockType`,`isLiked`,`isBookmarked`,`isDownloaded`,`localPath`,`watchProgress`,`authorId`,`authorUsername`,`authorDisplayName`,`authorAvatarUrl`,`authorIsVerified`,`authorFollowerCount`,`createdAt`,`updatedAt`,`cachedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VideoEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getVideoUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getVideoUrl());
        }
        if (entity.getThumbnailUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getThumbnailUrl());
        }
        if (entity.getHlsUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getHlsUrl());
        }
        statement.bindLong(7, entity.getDuration());
        statement.bindLong(8, entity.getEpisode());
        statement.bindLong(9, entity.getSeason());
        if (entity.getSeriesId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getSeriesId());
        }
        if (entity.getSeriesTitle() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getSeriesTitle());
        }
        if (entity.getGenre() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getGenre());
        }
        if (entity.getTags() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTags());
        }
        statement.bindLong(14, entity.getLikeCount());
        statement.bindLong(15, entity.getCommentCount());
        statement.bindLong(16, entity.getShareCount());
        statement.bindLong(17, entity.getViewCount());
        statement.bindLong(18, entity.getBookmarkCount());
        final int _tmp = entity.isPremium() ? 1 : 0;
        statement.bindLong(19, _tmp);
        final int _tmp_1 = entity.isLocked() ? 1 : 0;
        statement.bindLong(20, _tmp_1);
        statement.bindLong(21, entity.getCoinsRequired());
        if (entity.getUnlockType() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getUnlockType());
        }
        final int _tmp_2 = entity.isLiked() ? 1 : 0;
        statement.bindLong(23, _tmp_2);
        final int _tmp_3 = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(24, _tmp_3);
        final int _tmp_4 = entity.isDownloaded() ? 1 : 0;
        statement.bindLong(25, _tmp_4);
        if (entity.getLocalPath() == null) {
          statement.bindNull(26);
        } else {
          statement.bindString(26, entity.getLocalPath());
        }
        statement.bindDouble(27, entity.getWatchProgress());
        if (entity.getAuthorId() == null) {
          statement.bindNull(28);
        } else {
          statement.bindString(28, entity.getAuthorId());
        }
        if (entity.getAuthorUsername() == null) {
          statement.bindNull(29);
        } else {
          statement.bindString(29, entity.getAuthorUsername());
        }
        if (entity.getAuthorDisplayName() == null) {
          statement.bindNull(30);
        } else {
          statement.bindString(30, entity.getAuthorDisplayName());
        }
        if (entity.getAuthorAvatarUrl() == null) {
          statement.bindNull(31);
        } else {
          statement.bindString(31, entity.getAuthorAvatarUrl());
        }
        final int _tmp_5 = entity.getAuthorIsVerified() ? 1 : 0;
        statement.bindLong(32, _tmp_5);
        statement.bindLong(33, entity.getAuthorFollowerCount());
        statement.bindLong(34, entity.getCreatedAt());
        statement.bindLong(35, entity.getUpdatedAt());
        statement.bindLong(36, entity.getCachedAt());
      }
    };
    this.__updateAdapterOfVideoEntity = new EntityDeletionOrUpdateAdapter<VideoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `videos` SET `id` = ?,`title` = ?,`description` = ?,`videoUrl` = ?,`thumbnailUrl` = ?,`hlsUrl` = ?,`duration` = ?,`episode` = ?,`season` = ?,`seriesId` = ?,`seriesTitle` = ?,`genre` = ?,`tags` = ?,`likeCount` = ?,`commentCount` = ?,`shareCount` = ?,`viewCount` = ?,`bookmarkCount` = ?,`isPremium` = ?,`isLocked` = ?,`coinsRequired` = ?,`unlockType` = ?,`isLiked` = ?,`isBookmarked` = ?,`isDownloaded` = ?,`localPath` = ?,`watchProgress` = ?,`authorId` = ?,`authorUsername` = ?,`authorDisplayName` = ?,`authorAvatarUrl` = ?,`authorIsVerified` = ?,`authorFollowerCount` = ?,`createdAt` = ?,`updatedAt` = ?,`cachedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VideoEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getVideoUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getVideoUrl());
        }
        if (entity.getThumbnailUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getThumbnailUrl());
        }
        if (entity.getHlsUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getHlsUrl());
        }
        statement.bindLong(7, entity.getDuration());
        statement.bindLong(8, entity.getEpisode());
        statement.bindLong(9, entity.getSeason());
        if (entity.getSeriesId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getSeriesId());
        }
        if (entity.getSeriesTitle() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getSeriesTitle());
        }
        if (entity.getGenre() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getGenre());
        }
        if (entity.getTags() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTags());
        }
        statement.bindLong(14, entity.getLikeCount());
        statement.bindLong(15, entity.getCommentCount());
        statement.bindLong(16, entity.getShareCount());
        statement.bindLong(17, entity.getViewCount());
        statement.bindLong(18, entity.getBookmarkCount());
        final int _tmp = entity.isPremium() ? 1 : 0;
        statement.bindLong(19, _tmp);
        final int _tmp_1 = entity.isLocked() ? 1 : 0;
        statement.bindLong(20, _tmp_1);
        statement.bindLong(21, entity.getCoinsRequired());
        if (entity.getUnlockType() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getUnlockType());
        }
        final int _tmp_2 = entity.isLiked() ? 1 : 0;
        statement.bindLong(23, _tmp_2);
        final int _tmp_3 = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(24, _tmp_3);
        final int _tmp_4 = entity.isDownloaded() ? 1 : 0;
        statement.bindLong(25, _tmp_4);
        if (entity.getLocalPath() == null) {
          statement.bindNull(26);
        } else {
          statement.bindString(26, entity.getLocalPath());
        }
        statement.bindDouble(27, entity.getWatchProgress());
        if (entity.getAuthorId() == null) {
          statement.bindNull(28);
        } else {
          statement.bindString(28, entity.getAuthorId());
        }
        if (entity.getAuthorUsername() == null) {
          statement.bindNull(29);
        } else {
          statement.bindString(29, entity.getAuthorUsername());
        }
        if (entity.getAuthorDisplayName() == null) {
          statement.bindNull(30);
        } else {
          statement.bindString(30, entity.getAuthorDisplayName());
        }
        if (entity.getAuthorAvatarUrl() == null) {
          statement.bindNull(31);
        } else {
          statement.bindString(31, entity.getAuthorAvatarUrl());
        }
        final int _tmp_5 = entity.getAuthorIsVerified() ? 1 : 0;
        statement.bindLong(32, _tmp_5);
        statement.bindLong(33, entity.getAuthorFollowerCount());
        statement.bindLong(34, entity.getCreatedAt());
        statement.bindLong(35, entity.getUpdatedAt());
        statement.bindLong(36, entity.getCachedAt());
        if (entity.getId() == null) {
          statement.bindNull(37);
        } else {
          statement.bindString(37, entity.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateLikeStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE videos SET isLiked = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBookmarkStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE videos SET isBookmarked = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWatchProgress = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE videos SET watchProgress = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDownloadStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE videos SET isDownloaded = ?, localPath = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOldCache = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM videos WHERE cachedAt < ? AND isDownloaded = 0 AND isBookmarked = 0";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteVideo = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM videos WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertVideo(final VideoEntity video, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVideoEntity.insert(video);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertVideos(final List<VideoEntity> videos,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVideoEntity.insert(videos);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateVideo(final VideoEntity video, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfVideoEntity.handle(video);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLikeStatus(final String videoId, final boolean isLiked,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLikeStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isLiked ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (videoId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, videoId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLikeStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateBookmarkStatus(final String videoId, final boolean isBookmarked,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBookmarkStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isBookmarked ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (videoId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, videoId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateBookmarkStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateWatchProgress(final String videoId, final float progress,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWatchProgress.acquire();
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, progress);
        _argIndex = 2;
        if (videoId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, videoId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateWatchProgress.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateDownloadStatus(final String videoId, final boolean downloaded,
      final String path, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDownloadStatus.acquire();
        int _argIndex = 1;
        final int _tmp = downloaded ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (path == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, path);
        }
        _argIndex = 3;
        if (videoId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, videoId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateDownloadStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteOldCache(final long threshold, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldCache.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, threshold);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteOldCache.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteVideo(final String videoId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteVideo.acquire();
        int _argIndex = 1;
        if (videoId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, videoId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteVideo.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<VideoEntity>> getFeedVideos(final int limit, final int offset) {
    final String _sql = "SELECT * FROM videos ORDER BY createdAt DESC LIMIT ? OFFSET ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    _argIndex = 2;
    _statement.bindLong(_argIndex, offset);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"videos"}, new Callable<List<VideoEntity>>() {
      @Override
      @NonNull
      public List<VideoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfHlsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "hlsUrl");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfEpisode = CursorUtil.getColumnIndexOrThrow(_cursor, "episode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfSeriesId = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesId");
          final int _cursorIndexOfSeriesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesTitle");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfCommentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "commentCount");
          final int _cursorIndexOfShareCount = CursorUtil.getColumnIndexOrThrow(_cursor, "shareCount");
          final int _cursorIndexOfViewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "viewCount");
          final int _cursorIndexOfBookmarkCount = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarkCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
          final int _cursorIndexOfCoinsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "coinsRequired");
          final int _cursorIndexOfUnlockType = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockType");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localPath");
          final int _cursorIndexOfWatchProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "watchProgress");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfAuthorIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "authorIsVerified");
          final int _cursorIndexOfAuthorFollowerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "authorFollowerCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<VideoEntity> _result = new ArrayList<VideoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VideoEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpVideoUrl;
            if (_cursor.isNull(_cursorIndexOfVideoUrl)) {
              _tmpVideoUrl = null;
            } else {
              _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
            }
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpHlsUrl;
            if (_cursor.isNull(_cursorIndexOfHlsUrl)) {
              _tmpHlsUrl = null;
            } else {
              _tmpHlsUrl = _cursor.getString(_cursorIndexOfHlsUrl);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpEpisode;
            _tmpEpisode = _cursor.getInt(_cursorIndexOfEpisode);
            final int _tmpSeason;
            _tmpSeason = _cursor.getInt(_cursorIndexOfSeason);
            final String _tmpSeriesId;
            if (_cursor.isNull(_cursorIndexOfSeriesId)) {
              _tmpSeriesId = null;
            } else {
              _tmpSeriesId = _cursor.getString(_cursorIndexOfSeriesId);
            }
            final String _tmpSeriesTitle;
            if (_cursor.isNull(_cursorIndexOfSeriesTitle)) {
              _tmpSeriesTitle = null;
            } else {
              _tmpSeriesTitle = _cursor.getString(_cursorIndexOfSeriesTitle);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpTags;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmpTags = null;
            } else {
              _tmpTags = _cursor.getString(_cursorIndexOfTags);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final long _tmpCommentCount;
            _tmpCommentCount = _cursor.getLong(_cursorIndexOfCommentCount);
            final long _tmpShareCount;
            _tmpShareCount = _cursor.getLong(_cursorIndexOfShareCount);
            final long _tmpViewCount;
            _tmpViewCount = _cursor.getLong(_cursorIndexOfViewCount);
            final long _tmpBookmarkCount;
            _tmpBookmarkCount = _cursor.getLong(_cursorIndexOfBookmarkCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final boolean _tmpIsLocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocked);
            _tmpIsLocked = _tmp_1 != 0;
            final int _tmpCoinsRequired;
            _tmpCoinsRequired = _cursor.getInt(_cursorIndexOfCoinsRequired);
            final String _tmpUnlockType;
            if (_cursor.isNull(_cursorIndexOfUnlockType)) {
              _tmpUnlockType = null;
            } else {
              _tmpUnlockType = _cursor.getString(_cursorIndexOfUnlockType);
            }
            final boolean _tmpIsLiked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp_2 != 0;
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_4 != 0;
            final String _tmpLocalPath;
            if (_cursor.isNull(_cursorIndexOfLocalPath)) {
              _tmpLocalPath = null;
            } else {
              _tmpLocalPath = _cursor.getString(_cursorIndexOfLocalPath);
            }
            final float _tmpWatchProgress;
            _tmpWatchProgress = _cursor.getFloat(_cursorIndexOfWatchProgress);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorUsername;
            if (_cursor.isNull(_cursorIndexOfAuthorUsername)) {
              _tmpAuthorUsername = null;
            } else {
              _tmpAuthorUsername = _cursor.getString(_cursorIndexOfAuthorUsername);
            }
            final String _tmpAuthorDisplayName;
            if (_cursor.isNull(_cursorIndexOfAuthorDisplayName)) {
              _tmpAuthorDisplayName = null;
            } else {
              _tmpAuthorDisplayName = _cursor.getString(_cursorIndexOfAuthorDisplayName);
            }
            final String _tmpAuthorAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatarUrl)) {
              _tmpAuthorAvatarUrl = null;
            } else {
              _tmpAuthorAvatarUrl = _cursor.getString(_cursorIndexOfAuthorAvatarUrl);
            }
            final boolean _tmpAuthorIsVerified;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAuthorIsVerified);
            _tmpAuthorIsVerified = _tmp_5 != 0;
            final long _tmpAuthorFollowerCount;
            _tmpAuthorFollowerCount = _cursor.getLong(_cursorIndexOfAuthorFollowerCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new VideoEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpVideoUrl,_tmpThumbnailUrl,_tmpHlsUrl,_tmpDuration,_tmpEpisode,_tmpSeason,_tmpSeriesId,_tmpSeriesTitle,_tmpGenre,_tmpTags,_tmpLikeCount,_tmpCommentCount,_tmpShareCount,_tmpViewCount,_tmpBookmarkCount,_tmpIsPremium,_tmpIsLocked,_tmpCoinsRequired,_tmpUnlockType,_tmpIsLiked,_tmpIsBookmarked,_tmpIsDownloaded,_tmpLocalPath,_tmpWatchProgress,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpAuthorIsVerified,_tmpAuthorFollowerCount,_tmpCreatedAt,_tmpUpdatedAt,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<VideoEntity>> getSeriesEpisodes(final String seriesId) {
    final String _sql = "SELECT * FROM videos WHERE seriesId = ? ORDER BY season, episode";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (seriesId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, seriesId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"videos"}, new Callable<List<VideoEntity>>() {
      @Override
      @NonNull
      public List<VideoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfHlsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "hlsUrl");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfEpisode = CursorUtil.getColumnIndexOrThrow(_cursor, "episode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfSeriesId = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesId");
          final int _cursorIndexOfSeriesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesTitle");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfCommentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "commentCount");
          final int _cursorIndexOfShareCount = CursorUtil.getColumnIndexOrThrow(_cursor, "shareCount");
          final int _cursorIndexOfViewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "viewCount");
          final int _cursorIndexOfBookmarkCount = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarkCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
          final int _cursorIndexOfCoinsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "coinsRequired");
          final int _cursorIndexOfUnlockType = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockType");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localPath");
          final int _cursorIndexOfWatchProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "watchProgress");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfAuthorIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "authorIsVerified");
          final int _cursorIndexOfAuthorFollowerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "authorFollowerCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<VideoEntity> _result = new ArrayList<VideoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VideoEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpVideoUrl;
            if (_cursor.isNull(_cursorIndexOfVideoUrl)) {
              _tmpVideoUrl = null;
            } else {
              _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
            }
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpHlsUrl;
            if (_cursor.isNull(_cursorIndexOfHlsUrl)) {
              _tmpHlsUrl = null;
            } else {
              _tmpHlsUrl = _cursor.getString(_cursorIndexOfHlsUrl);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpEpisode;
            _tmpEpisode = _cursor.getInt(_cursorIndexOfEpisode);
            final int _tmpSeason;
            _tmpSeason = _cursor.getInt(_cursorIndexOfSeason);
            final String _tmpSeriesId;
            if (_cursor.isNull(_cursorIndexOfSeriesId)) {
              _tmpSeriesId = null;
            } else {
              _tmpSeriesId = _cursor.getString(_cursorIndexOfSeriesId);
            }
            final String _tmpSeriesTitle;
            if (_cursor.isNull(_cursorIndexOfSeriesTitle)) {
              _tmpSeriesTitle = null;
            } else {
              _tmpSeriesTitle = _cursor.getString(_cursorIndexOfSeriesTitle);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpTags;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmpTags = null;
            } else {
              _tmpTags = _cursor.getString(_cursorIndexOfTags);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final long _tmpCommentCount;
            _tmpCommentCount = _cursor.getLong(_cursorIndexOfCommentCount);
            final long _tmpShareCount;
            _tmpShareCount = _cursor.getLong(_cursorIndexOfShareCount);
            final long _tmpViewCount;
            _tmpViewCount = _cursor.getLong(_cursorIndexOfViewCount);
            final long _tmpBookmarkCount;
            _tmpBookmarkCount = _cursor.getLong(_cursorIndexOfBookmarkCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final boolean _tmpIsLocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocked);
            _tmpIsLocked = _tmp_1 != 0;
            final int _tmpCoinsRequired;
            _tmpCoinsRequired = _cursor.getInt(_cursorIndexOfCoinsRequired);
            final String _tmpUnlockType;
            if (_cursor.isNull(_cursorIndexOfUnlockType)) {
              _tmpUnlockType = null;
            } else {
              _tmpUnlockType = _cursor.getString(_cursorIndexOfUnlockType);
            }
            final boolean _tmpIsLiked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp_2 != 0;
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_4 != 0;
            final String _tmpLocalPath;
            if (_cursor.isNull(_cursorIndexOfLocalPath)) {
              _tmpLocalPath = null;
            } else {
              _tmpLocalPath = _cursor.getString(_cursorIndexOfLocalPath);
            }
            final float _tmpWatchProgress;
            _tmpWatchProgress = _cursor.getFloat(_cursorIndexOfWatchProgress);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorUsername;
            if (_cursor.isNull(_cursorIndexOfAuthorUsername)) {
              _tmpAuthorUsername = null;
            } else {
              _tmpAuthorUsername = _cursor.getString(_cursorIndexOfAuthorUsername);
            }
            final String _tmpAuthorDisplayName;
            if (_cursor.isNull(_cursorIndexOfAuthorDisplayName)) {
              _tmpAuthorDisplayName = null;
            } else {
              _tmpAuthorDisplayName = _cursor.getString(_cursorIndexOfAuthorDisplayName);
            }
            final String _tmpAuthorAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatarUrl)) {
              _tmpAuthorAvatarUrl = null;
            } else {
              _tmpAuthorAvatarUrl = _cursor.getString(_cursorIndexOfAuthorAvatarUrl);
            }
            final boolean _tmpAuthorIsVerified;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAuthorIsVerified);
            _tmpAuthorIsVerified = _tmp_5 != 0;
            final long _tmpAuthorFollowerCount;
            _tmpAuthorFollowerCount = _cursor.getLong(_cursorIndexOfAuthorFollowerCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new VideoEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpVideoUrl,_tmpThumbnailUrl,_tmpHlsUrl,_tmpDuration,_tmpEpisode,_tmpSeason,_tmpSeriesId,_tmpSeriesTitle,_tmpGenre,_tmpTags,_tmpLikeCount,_tmpCommentCount,_tmpShareCount,_tmpViewCount,_tmpBookmarkCount,_tmpIsPremium,_tmpIsLocked,_tmpCoinsRequired,_tmpUnlockType,_tmpIsLiked,_tmpIsBookmarked,_tmpIsDownloaded,_tmpLocalPath,_tmpWatchProgress,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpAuthorIsVerified,_tmpAuthorFollowerCount,_tmpCreatedAt,_tmpUpdatedAt,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<VideoEntity>> getVideosByGenre(final String genre, final int limit) {
    final String _sql = "SELECT * FROM videos WHERE genre = ? ORDER BY viewCount DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (genre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, genre);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"videos"}, new Callable<List<VideoEntity>>() {
      @Override
      @NonNull
      public List<VideoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfHlsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "hlsUrl");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfEpisode = CursorUtil.getColumnIndexOrThrow(_cursor, "episode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfSeriesId = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesId");
          final int _cursorIndexOfSeriesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesTitle");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfCommentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "commentCount");
          final int _cursorIndexOfShareCount = CursorUtil.getColumnIndexOrThrow(_cursor, "shareCount");
          final int _cursorIndexOfViewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "viewCount");
          final int _cursorIndexOfBookmarkCount = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarkCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
          final int _cursorIndexOfCoinsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "coinsRequired");
          final int _cursorIndexOfUnlockType = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockType");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localPath");
          final int _cursorIndexOfWatchProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "watchProgress");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfAuthorIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "authorIsVerified");
          final int _cursorIndexOfAuthorFollowerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "authorFollowerCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<VideoEntity> _result = new ArrayList<VideoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VideoEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpVideoUrl;
            if (_cursor.isNull(_cursorIndexOfVideoUrl)) {
              _tmpVideoUrl = null;
            } else {
              _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
            }
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpHlsUrl;
            if (_cursor.isNull(_cursorIndexOfHlsUrl)) {
              _tmpHlsUrl = null;
            } else {
              _tmpHlsUrl = _cursor.getString(_cursorIndexOfHlsUrl);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpEpisode;
            _tmpEpisode = _cursor.getInt(_cursorIndexOfEpisode);
            final int _tmpSeason;
            _tmpSeason = _cursor.getInt(_cursorIndexOfSeason);
            final String _tmpSeriesId;
            if (_cursor.isNull(_cursorIndexOfSeriesId)) {
              _tmpSeriesId = null;
            } else {
              _tmpSeriesId = _cursor.getString(_cursorIndexOfSeriesId);
            }
            final String _tmpSeriesTitle;
            if (_cursor.isNull(_cursorIndexOfSeriesTitle)) {
              _tmpSeriesTitle = null;
            } else {
              _tmpSeriesTitle = _cursor.getString(_cursorIndexOfSeriesTitle);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpTags;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmpTags = null;
            } else {
              _tmpTags = _cursor.getString(_cursorIndexOfTags);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final long _tmpCommentCount;
            _tmpCommentCount = _cursor.getLong(_cursorIndexOfCommentCount);
            final long _tmpShareCount;
            _tmpShareCount = _cursor.getLong(_cursorIndexOfShareCount);
            final long _tmpViewCount;
            _tmpViewCount = _cursor.getLong(_cursorIndexOfViewCount);
            final long _tmpBookmarkCount;
            _tmpBookmarkCount = _cursor.getLong(_cursorIndexOfBookmarkCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final boolean _tmpIsLocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocked);
            _tmpIsLocked = _tmp_1 != 0;
            final int _tmpCoinsRequired;
            _tmpCoinsRequired = _cursor.getInt(_cursorIndexOfCoinsRequired);
            final String _tmpUnlockType;
            if (_cursor.isNull(_cursorIndexOfUnlockType)) {
              _tmpUnlockType = null;
            } else {
              _tmpUnlockType = _cursor.getString(_cursorIndexOfUnlockType);
            }
            final boolean _tmpIsLiked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp_2 != 0;
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_4 != 0;
            final String _tmpLocalPath;
            if (_cursor.isNull(_cursorIndexOfLocalPath)) {
              _tmpLocalPath = null;
            } else {
              _tmpLocalPath = _cursor.getString(_cursorIndexOfLocalPath);
            }
            final float _tmpWatchProgress;
            _tmpWatchProgress = _cursor.getFloat(_cursorIndexOfWatchProgress);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorUsername;
            if (_cursor.isNull(_cursorIndexOfAuthorUsername)) {
              _tmpAuthorUsername = null;
            } else {
              _tmpAuthorUsername = _cursor.getString(_cursorIndexOfAuthorUsername);
            }
            final String _tmpAuthorDisplayName;
            if (_cursor.isNull(_cursorIndexOfAuthorDisplayName)) {
              _tmpAuthorDisplayName = null;
            } else {
              _tmpAuthorDisplayName = _cursor.getString(_cursorIndexOfAuthorDisplayName);
            }
            final String _tmpAuthorAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatarUrl)) {
              _tmpAuthorAvatarUrl = null;
            } else {
              _tmpAuthorAvatarUrl = _cursor.getString(_cursorIndexOfAuthorAvatarUrl);
            }
            final boolean _tmpAuthorIsVerified;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAuthorIsVerified);
            _tmpAuthorIsVerified = _tmp_5 != 0;
            final long _tmpAuthorFollowerCount;
            _tmpAuthorFollowerCount = _cursor.getLong(_cursorIndexOfAuthorFollowerCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new VideoEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpVideoUrl,_tmpThumbnailUrl,_tmpHlsUrl,_tmpDuration,_tmpEpisode,_tmpSeason,_tmpSeriesId,_tmpSeriesTitle,_tmpGenre,_tmpTags,_tmpLikeCount,_tmpCommentCount,_tmpShareCount,_tmpViewCount,_tmpBookmarkCount,_tmpIsPremium,_tmpIsLocked,_tmpCoinsRequired,_tmpUnlockType,_tmpIsLiked,_tmpIsBookmarked,_tmpIsDownloaded,_tmpLocalPath,_tmpWatchProgress,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpAuthorIsVerified,_tmpAuthorFollowerCount,_tmpCreatedAt,_tmpUpdatedAt,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getVideoById(final String videoId,
      final Continuation<? super VideoEntity> $completion) {
    final String _sql = "SELECT * FROM videos WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (videoId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, videoId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<VideoEntity>() {
      @Override
      @Nullable
      public VideoEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfHlsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "hlsUrl");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfEpisode = CursorUtil.getColumnIndexOrThrow(_cursor, "episode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfSeriesId = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesId");
          final int _cursorIndexOfSeriesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesTitle");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfCommentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "commentCount");
          final int _cursorIndexOfShareCount = CursorUtil.getColumnIndexOrThrow(_cursor, "shareCount");
          final int _cursorIndexOfViewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "viewCount");
          final int _cursorIndexOfBookmarkCount = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarkCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
          final int _cursorIndexOfCoinsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "coinsRequired");
          final int _cursorIndexOfUnlockType = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockType");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localPath");
          final int _cursorIndexOfWatchProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "watchProgress");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfAuthorIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "authorIsVerified");
          final int _cursorIndexOfAuthorFollowerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "authorFollowerCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final VideoEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpVideoUrl;
            if (_cursor.isNull(_cursorIndexOfVideoUrl)) {
              _tmpVideoUrl = null;
            } else {
              _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
            }
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpHlsUrl;
            if (_cursor.isNull(_cursorIndexOfHlsUrl)) {
              _tmpHlsUrl = null;
            } else {
              _tmpHlsUrl = _cursor.getString(_cursorIndexOfHlsUrl);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpEpisode;
            _tmpEpisode = _cursor.getInt(_cursorIndexOfEpisode);
            final int _tmpSeason;
            _tmpSeason = _cursor.getInt(_cursorIndexOfSeason);
            final String _tmpSeriesId;
            if (_cursor.isNull(_cursorIndexOfSeriesId)) {
              _tmpSeriesId = null;
            } else {
              _tmpSeriesId = _cursor.getString(_cursorIndexOfSeriesId);
            }
            final String _tmpSeriesTitle;
            if (_cursor.isNull(_cursorIndexOfSeriesTitle)) {
              _tmpSeriesTitle = null;
            } else {
              _tmpSeriesTitle = _cursor.getString(_cursorIndexOfSeriesTitle);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpTags;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmpTags = null;
            } else {
              _tmpTags = _cursor.getString(_cursorIndexOfTags);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final long _tmpCommentCount;
            _tmpCommentCount = _cursor.getLong(_cursorIndexOfCommentCount);
            final long _tmpShareCount;
            _tmpShareCount = _cursor.getLong(_cursorIndexOfShareCount);
            final long _tmpViewCount;
            _tmpViewCount = _cursor.getLong(_cursorIndexOfViewCount);
            final long _tmpBookmarkCount;
            _tmpBookmarkCount = _cursor.getLong(_cursorIndexOfBookmarkCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final boolean _tmpIsLocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocked);
            _tmpIsLocked = _tmp_1 != 0;
            final int _tmpCoinsRequired;
            _tmpCoinsRequired = _cursor.getInt(_cursorIndexOfCoinsRequired);
            final String _tmpUnlockType;
            if (_cursor.isNull(_cursorIndexOfUnlockType)) {
              _tmpUnlockType = null;
            } else {
              _tmpUnlockType = _cursor.getString(_cursorIndexOfUnlockType);
            }
            final boolean _tmpIsLiked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp_2 != 0;
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_4 != 0;
            final String _tmpLocalPath;
            if (_cursor.isNull(_cursorIndexOfLocalPath)) {
              _tmpLocalPath = null;
            } else {
              _tmpLocalPath = _cursor.getString(_cursorIndexOfLocalPath);
            }
            final float _tmpWatchProgress;
            _tmpWatchProgress = _cursor.getFloat(_cursorIndexOfWatchProgress);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorUsername;
            if (_cursor.isNull(_cursorIndexOfAuthorUsername)) {
              _tmpAuthorUsername = null;
            } else {
              _tmpAuthorUsername = _cursor.getString(_cursorIndexOfAuthorUsername);
            }
            final String _tmpAuthorDisplayName;
            if (_cursor.isNull(_cursorIndexOfAuthorDisplayName)) {
              _tmpAuthorDisplayName = null;
            } else {
              _tmpAuthorDisplayName = _cursor.getString(_cursorIndexOfAuthorDisplayName);
            }
            final String _tmpAuthorAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatarUrl)) {
              _tmpAuthorAvatarUrl = null;
            } else {
              _tmpAuthorAvatarUrl = _cursor.getString(_cursorIndexOfAuthorAvatarUrl);
            }
            final boolean _tmpAuthorIsVerified;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAuthorIsVerified);
            _tmpAuthorIsVerified = _tmp_5 != 0;
            final long _tmpAuthorFollowerCount;
            _tmpAuthorFollowerCount = _cursor.getLong(_cursorIndexOfAuthorFollowerCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _result = new VideoEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpVideoUrl,_tmpThumbnailUrl,_tmpHlsUrl,_tmpDuration,_tmpEpisode,_tmpSeason,_tmpSeriesId,_tmpSeriesTitle,_tmpGenre,_tmpTags,_tmpLikeCount,_tmpCommentCount,_tmpShareCount,_tmpViewCount,_tmpBookmarkCount,_tmpIsPremium,_tmpIsLocked,_tmpCoinsRequired,_tmpUnlockType,_tmpIsLiked,_tmpIsBookmarked,_tmpIsDownloaded,_tmpLocalPath,_tmpWatchProgress,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpAuthorIsVerified,_tmpAuthorFollowerCount,_tmpCreatedAt,_tmpUpdatedAt,_tmpCachedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<VideoEntity>> getBookmarkedVideos() {
    final String _sql = "SELECT * FROM videos WHERE isBookmarked = 1 ORDER BY cachedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"videos"}, new Callable<List<VideoEntity>>() {
      @Override
      @NonNull
      public List<VideoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfHlsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "hlsUrl");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfEpisode = CursorUtil.getColumnIndexOrThrow(_cursor, "episode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfSeriesId = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesId");
          final int _cursorIndexOfSeriesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesTitle");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfCommentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "commentCount");
          final int _cursorIndexOfShareCount = CursorUtil.getColumnIndexOrThrow(_cursor, "shareCount");
          final int _cursorIndexOfViewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "viewCount");
          final int _cursorIndexOfBookmarkCount = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarkCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
          final int _cursorIndexOfCoinsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "coinsRequired");
          final int _cursorIndexOfUnlockType = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockType");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localPath");
          final int _cursorIndexOfWatchProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "watchProgress");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfAuthorIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "authorIsVerified");
          final int _cursorIndexOfAuthorFollowerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "authorFollowerCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<VideoEntity> _result = new ArrayList<VideoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VideoEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpVideoUrl;
            if (_cursor.isNull(_cursorIndexOfVideoUrl)) {
              _tmpVideoUrl = null;
            } else {
              _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
            }
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpHlsUrl;
            if (_cursor.isNull(_cursorIndexOfHlsUrl)) {
              _tmpHlsUrl = null;
            } else {
              _tmpHlsUrl = _cursor.getString(_cursorIndexOfHlsUrl);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpEpisode;
            _tmpEpisode = _cursor.getInt(_cursorIndexOfEpisode);
            final int _tmpSeason;
            _tmpSeason = _cursor.getInt(_cursorIndexOfSeason);
            final String _tmpSeriesId;
            if (_cursor.isNull(_cursorIndexOfSeriesId)) {
              _tmpSeriesId = null;
            } else {
              _tmpSeriesId = _cursor.getString(_cursorIndexOfSeriesId);
            }
            final String _tmpSeriesTitle;
            if (_cursor.isNull(_cursorIndexOfSeriesTitle)) {
              _tmpSeriesTitle = null;
            } else {
              _tmpSeriesTitle = _cursor.getString(_cursorIndexOfSeriesTitle);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpTags;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmpTags = null;
            } else {
              _tmpTags = _cursor.getString(_cursorIndexOfTags);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final long _tmpCommentCount;
            _tmpCommentCount = _cursor.getLong(_cursorIndexOfCommentCount);
            final long _tmpShareCount;
            _tmpShareCount = _cursor.getLong(_cursorIndexOfShareCount);
            final long _tmpViewCount;
            _tmpViewCount = _cursor.getLong(_cursorIndexOfViewCount);
            final long _tmpBookmarkCount;
            _tmpBookmarkCount = _cursor.getLong(_cursorIndexOfBookmarkCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final boolean _tmpIsLocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocked);
            _tmpIsLocked = _tmp_1 != 0;
            final int _tmpCoinsRequired;
            _tmpCoinsRequired = _cursor.getInt(_cursorIndexOfCoinsRequired);
            final String _tmpUnlockType;
            if (_cursor.isNull(_cursorIndexOfUnlockType)) {
              _tmpUnlockType = null;
            } else {
              _tmpUnlockType = _cursor.getString(_cursorIndexOfUnlockType);
            }
            final boolean _tmpIsLiked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp_2 != 0;
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_4 != 0;
            final String _tmpLocalPath;
            if (_cursor.isNull(_cursorIndexOfLocalPath)) {
              _tmpLocalPath = null;
            } else {
              _tmpLocalPath = _cursor.getString(_cursorIndexOfLocalPath);
            }
            final float _tmpWatchProgress;
            _tmpWatchProgress = _cursor.getFloat(_cursorIndexOfWatchProgress);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorUsername;
            if (_cursor.isNull(_cursorIndexOfAuthorUsername)) {
              _tmpAuthorUsername = null;
            } else {
              _tmpAuthorUsername = _cursor.getString(_cursorIndexOfAuthorUsername);
            }
            final String _tmpAuthorDisplayName;
            if (_cursor.isNull(_cursorIndexOfAuthorDisplayName)) {
              _tmpAuthorDisplayName = null;
            } else {
              _tmpAuthorDisplayName = _cursor.getString(_cursorIndexOfAuthorDisplayName);
            }
            final String _tmpAuthorAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatarUrl)) {
              _tmpAuthorAvatarUrl = null;
            } else {
              _tmpAuthorAvatarUrl = _cursor.getString(_cursorIndexOfAuthorAvatarUrl);
            }
            final boolean _tmpAuthorIsVerified;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAuthorIsVerified);
            _tmpAuthorIsVerified = _tmp_5 != 0;
            final long _tmpAuthorFollowerCount;
            _tmpAuthorFollowerCount = _cursor.getLong(_cursorIndexOfAuthorFollowerCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new VideoEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpVideoUrl,_tmpThumbnailUrl,_tmpHlsUrl,_tmpDuration,_tmpEpisode,_tmpSeason,_tmpSeriesId,_tmpSeriesTitle,_tmpGenre,_tmpTags,_tmpLikeCount,_tmpCommentCount,_tmpShareCount,_tmpViewCount,_tmpBookmarkCount,_tmpIsPremium,_tmpIsLocked,_tmpCoinsRequired,_tmpUnlockType,_tmpIsLiked,_tmpIsBookmarked,_tmpIsDownloaded,_tmpLocalPath,_tmpWatchProgress,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpAuthorIsVerified,_tmpAuthorFollowerCount,_tmpCreatedAt,_tmpUpdatedAt,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object searchVideos(final String query, final int limit,
      final Continuation<? super List<VideoEntity>> $completion) {
    final String _sql = "\n"
            + "        SELECT v.* FROM videos v\n"
            + "        WHERE v.title LIKE '%' || ? || '%'\n"
            + "        OR v.description LIKE '%' || ? || '%'\n"
            + "        OR v.seriesTitle LIKE '%' || ? || '%'\n"
            + "        ORDER BY v.viewCount DESC\n"
            + "        LIMIT ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 4;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<VideoEntity>>() {
      @Override
      @NonNull
      public List<VideoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfHlsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "hlsUrl");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfEpisode = CursorUtil.getColumnIndexOrThrow(_cursor, "episode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfSeriesId = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesId");
          final int _cursorIndexOfSeriesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesTitle");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfCommentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "commentCount");
          final int _cursorIndexOfShareCount = CursorUtil.getColumnIndexOrThrow(_cursor, "shareCount");
          final int _cursorIndexOfViewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "viewCount");
          final int _cursorIndexOfBookmarkCount = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarkCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
          final int _cursorIndexOfCoinsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "coinsRequired");
          final int _cursorIndexOfUnlockType = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockType");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localPath");
          final int _cursorIndexOfWatchProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "watchProgress");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfAuthorIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "authorIsVerified");
          final int _cursorIndexOfAuthorFollowerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "authorFollowerCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<VideoEntity> _result = new ArrayList<VideoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VideoEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpVideoUrl;
            if (_cursor.isNull(_cursorIndexOfVideoUrl)) {
              _tmpVideoUrl = null;
            } else {
              _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
            }
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpHlsUrl;
            if (_cursor.isNull(_cursorIndexOfHlsUrl)) {
              _tmpHlsUrl = null;
            } else {
              _tmpHlsUrl = _cursor.getString(_cursorIndexOfHlsUrl);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpEpisode;
            _tmpEpisode = _cursor.getInt(_cursorIndexOfEpisode);
            final int _tmpSeason;
            _tmpSeason = _cursor.getInt(_cursorIndexOfSeason);
            final String _tmpSeriesId;
            if (_cursor.isNull(_cursorIndexOfSeriesId)) {
              _tmpSeriesId = null;
            } else {
              _tmpSeriesId = _cursor.getString(_cursorIndexOfSeriesId);
            }
            final String _tmpSeriesTitle;
            if (_cursor.isNull(_cursorIndexOfSeriesTitle)) {
              _tmpSeriesTitle = null;
            } else {
              _tmpSeriesTitle = _cursor.getString(_cursorIndexOfSeriesTitle);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpTags;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmpTags = null;
            } else {
              _tmpTags = _cursor.getString(_cursorIndexOfTags);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final long _tmpCommentCount;
            _tmpCommentCount = _cursor.getLong(_cursorIndexOfCommentCount);
            final long _tmpShareCount;
            _tmpShareCount = _cursor.getLong(_cursorIndexOfShareCount);
            final long _tmpViewCount;
            _tmpViewCount = _cursor.getLong(_cursorIndexOfViewCount);
            final long _tmpBookmarkCount;
            _tmpBookmarkCount = _cursor.getLong(_cursorIndexOfBookmarkCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final boolean _tmpIsLocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocked);
            _tmpIsLocked = _tmp_1 != 0;
            final int _tmpCoinsRequired;
            _tmpCoinsRequired = _cursor.getInt(_cursorIndexOfCoinsRequired);
            final String _tmpUnlockType;
            if (_cursor.isNull(_cursorIndexOfUnlockType)) {
              _tmpUnlockType = null;
            } else {
              _tmpUnlockType = _cursor.getString(_cursorIndexOfUnlockType);
            }
            final boolean _tmpIsLiked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp_2 != 0;
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_4 != 0;
            final String _tmpLocalPath;
            if (_cursor.isNull(_cursorIndexOfLocalPath)) {
              _tmpLocalPath = null;
            } else {
              _tmpLocalPath = _cursor.getString(_cursorIndexOfLocalPath);
            }
            final float _tmpWatchProgress;
            _tmpWatchProgress = _cursor.getFloat(_cursorIndexOfWatchProgress);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorUsername;
            if (_cursor.isNull(_cursorIndexOfAuthorUsername)) {
              _tmpAuthorUsername = null;
            } else {
              _tmpAuthorUsername = _cursor.getString(_cursorIndexOfAuthorUsername);
            }
            final String _tmpAuthorDisplayName;
            if (_cursor.isNull(_cursorIndexOfAuthorDisplayName)) {
              _tmpAuthorDisplayName = null;
            } else {
              _tmpAuthorDisplayName = _cursor.getString(_cursorIndexOfAuthorDisplayName);
            }
            final String _tmpAuthorAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatarUrl)) {
              _tmpAuthorAvatarUrl = null;
            } else {
              _tmpAuthorAvatarUrl = _cursor.getString(_cursorIndexOfAuthorAvatarUrl);
            }
            final boolean _tmpAuthorIsVerified;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAuthorIsVerified);
            _tmpAuthorIsVerified = _tmp_5 != 0;
            final long _tmpAuthorFollowerCount;
            _tmpAuthorFollowerCount = _cursor.getLong(_cursorIndexOfAuthorFollowerCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new VideoEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpVideoUrl,_tmpThumbnailUrl,_tmpHlsUrl,_tmpDuration,_tmpEpisode,_tmpSeason,_tmpSeriesId,_tmpSeriesTitle,_tmpGenre,_tmpTags,_tmpLikeCount,_tmpCommentCount,_tmpShareCount,_tmpViewCount,_tmpBookmarkCount,_tmpIsPremium,_tmpIsLocked,_tmpCoinsRequired,_tmpUnlockType,_tmpIsLiked,_tmpIsBookmarked,_tmpIsDownloaded,_tmpLocalPath,_tmpWatchProgress,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpAuthorIsVerified,_tmpAuthorFollowerCount,_tmpCreatedAt,_tmpUpdatedAt,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<VideoEntity>> getTrendingVideos() {
    final String _sql = "SELECT * FROM videos WHERE viewCount > 500000 ORDER BY viewCount DESC LIMIT 20";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"videos"}, new Callable<List<VideoEntity>>() {
      @Override
      @NonNull
      public List<VideoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfHlsUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "hlsUrl");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfEpisode = CursorUtil.getColumnIndexOrThrow(_cursor, "episode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfSeriesId = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesId");
          final int _cursorIndexOfSeriesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "seriesTitle");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfCommentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "commentCount");
          final int _cursorIndexOfShareCount = CursorUtil.getColumnIndexOrThrow(_cursor, "shareCount");
          final int _cursorIndexOfViewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "viewCount");
          final int _cursorIndexOfBookmarkCount = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarkCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
          final int _cursorIndexOfCoinsRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "coinsRequired");
          final int _cursorIndexOfUnlockType = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockType");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBookmarked");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localPath");
          final int _cursorIndexOfWatchProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "watchProgress");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfAuthorIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "authorIsVerified");
          final int _cursorIndexOfAuthorFollowerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "authorFollowerCount");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<VideoEntity> _result = new ArrayList<VideoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VideoEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpVideoUrl;
            if (_cursor.isNull(_cursorIndexOfVideoUrl)) {
              _tmpVideoUrl = null;
            } else {
              _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
            }
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpHlsUrl;
            if (_cursor.isNull(_cursorIndexOfHlsUrl)) {
              _tmpHlsUrl = null;
            } else {
              _tmpHlsUrl = _cursor.getString(_cursorIndexOfHlsUrl);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpEpisode;
            _tmpEpisode = _cursor.getInt(_cursorIndexOfEpisode);
            final int _tmpSeason;
            _tmpSeason = _cursor.getInt(_cursorIndexOfSeason);
            final String _tmpSeriesId;
            if (_cursor.isNull(_cursorIndexOfSeriesId)) {
              _tmpSeriesId = null;
            } else {
              _tmpSeriesId = _cursor.getString(_cursorIndexOfSeriesId);
            }
            final String _tmpSeriesTitle;
            if (_cursor.isNull(_cursorIndexOfSeriesTitle)) {
              _tmpSeriesTitle = null;
            } else {
              _tmpSeriesTitle = _cursor.getString(_cursorIndexOfSeriesTitle);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpTags;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmpTags = null;
            } else {
              _tmpTags = _cursor.getString(_cursorIndexOfTags);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final long _tmpCommentCount;
            _tmpCommentCount = _cursor.getLong(_cursorIndexOfCommentCount);
            final long _tmpShareCount;
            _tmpShareCount = _cursor.getLong(_cursorIndexOfShareCount);
            final long _tmpViewCount;
            _tmpViewCount = _cursor.getLong(_cursorIndexOfViewCount);
            final long _tmpBookmarkCount;
            _tmpBookmarkCount = _cursor.getLong(_cursorIndexOfBookmarkCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final boolean _tmpIsLocked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsLocked);
            _tmpIsLocked = _tmp_1 != 0;
            final int _tmpCoinsRequired;
            _tmpCoinsRequired = _cursor.getInt(_cursorIndexOfCoinsRequired);
            final String _tmpUnlockType;
            if (_cursor.isNull(_cursorIndexOfUnlockType)) {
              _tmpUnlockType = null;
            } else {
              _tmpUnlockType = _cursor.getString(_cursorIndexOfUnlockType);
            }
            final boolean _tmpIsLiked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp_2 != 0;
            final boolean _tmpIsBookmarked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_3 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_4 != 0;
            final String _tmpLocalPath;
            if (_cursor.isNull(_cursorIndexOfLocalPath)) {
              _tmpLocalPath = null;
            } else {
              _tmpLocalPath = _cursor.getString(_cursorIndexOfLocalPath);
            }
            final float _tmpWatchProgress;
            _tmpWatchProgress = _cursor.getFloat(_cursorIndexOfWatchProgress);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            final String _tmpAuthorUsername;
            if (_cursor.isNull(_cursorIndexOfAuthorUsername)) {
              _tmpAuthorUsername = null;
            } else {
              _tmpAuthorUsername = _cursor.getString(_cursorIndexOfAuthorUsername);
            }
            final String _tmpAuthorDisplayName;
            if (_cursor.isNull(_cursorIndexOfAuthorDisplayName)) {
              _tmpAuthorDisplayName = null;
            } else {
              _tmpAuthorDisplayName = _cursor.getString(_cursorIndexOfAuthorDisplayName);
            }
            final String _tmpAuthorAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatarUrl)) {
              _tmpAuthorAvatarUrl = null;
            } else {
              _tmpAuthorAvatarUrl = _cursor.getString(_cursorIndexOfAuthorAvatarUrl);
            }
            final boolean _tmpAuthorIsVerified;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAuthorIsVerified);
            _tmpAuthorIsVerified = _tmp_5 != 0;
            final long _tmpAuthorFollowerCount;
            _tmpAuthorFollowerCount = _cursor.getLong(_cursorIndexOfAuthorFollowerCount);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new VideoEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpVideoUrl,_tmpThumbnailUrl,_tmpHlsUrl,_tmpDuration,_tmpEpisode,_tmpSeason,_tmpSeriesId,_tmpSeriesTitle,_tmpGenre,_tmpTags,_tmpLikeCount,_tmpCommentCount,_tmpShareCount,_tmpViewCount,_tmpBookmarkCount,_tmpIsPremium,_tmpIsLocked,_tmpCoinsRequired,_tmpUnlockType,_tmpIsLiked,_tmpIsBookmarked,_tmpIsDownloaded,_tmpLocalPath,_tmpWatchProgress,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpAuthorIsVerified,_tmpAuthorFollowerCount,_tmpCreatedAt,_tmpUpdatedAt,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
