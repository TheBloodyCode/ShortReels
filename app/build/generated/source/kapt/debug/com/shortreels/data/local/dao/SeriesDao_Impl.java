package com.shortreels.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.shortreels.data.local.entities.SeriesEntity;
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
public final class SeriesDao_Impl implements SeriesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SeriesEntity> __insertionAdapterOfSeriesEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFollowStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSeries;

  public SeriesDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSeriesEntity = new EntityInsertionAdapter<SeriesEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `series` (`id`,`title`,`description`,`thumbnailUrl`,`bannerUrl`,`genre`,`tags`,`totalEpisodes`,`authorId`,`authorUsername`,`authorDisplayName`,`authorAvatarUrl`,`rating`,`reviewCount`,`isPremium`,`status`,`releaseSchedule`,`isFollowing`,`createdAt`,`cachedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SeriesEntity entity) {
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
        if (entity.getThumbnailUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getThumbnailUrl());
        }
        if (entity.getBannerUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getBannerUrl());
        }
        if (entity.getGenre() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getGenre());
        }
        if (entity.getTags() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTags());
        }
        statement.bindLong(8, entity.getTotalEpisodes());
        if (entity.getAuthorId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getAuthorId());
        }
        if (entity.getAuthorUsername() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getAuthorUsername());
        }
        if (entity.getAuthorDisplayName() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAuthorDisplayName());
        }
        if (entity.getAuthorAvatarUrl() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getAuthorAvatarUrl());
        }
        statement.bindDouble(13, entity.getRating());
        statement.bindLong(14, entity.getReviewCount());
        final int _tmp = entity.isPremium() ? 1 : 0;
        statement.bindLong(15, _tmp);
        if (entity.getStatus() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getStatus());
        }
        if (entity.getReleaseSchedule() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getReleaseSchedule());
        }
        final int _tmp_1 = entity.isFollowing() ? 1 : 0;
        statement.bindLong(18, _tmp_1);
        statement.bindLong(19, entity.getCreatedAt());
        statement.bindLong(20, entity.getCachedAt());
      }
    };
    this.__preparedStmtOfUpdateFollowStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE series SET isFollowing = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSeries = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM series WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertSeries(final SeriesEntity series,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSeriesEntity.insert(series);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSeriesList(final List<SeriesEntity> seriesList,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSeriesEntity.insert(seriesList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFollowStatus(final String seriesId, final boolean isFollowing,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFollowStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isFollowing ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (seriesId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, seriesId);
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
          __preparedStmtOfUpdateFollowStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSeries(final String seriesId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSeries.acquire();
        int _argIndex = 1;
        if (seriesId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, seriesId);
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
          __preparedStmtOfDeleteSeries.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SeriesEntity>> getAllSeries() {
    final String _sql = "SELECT * FROM series ORDER BY cachedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"series"}, new Callable<List<SeriesEntity>>() {
      @Override
      @NonNull
      public List<SeriesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfBannerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfTotalEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalEpisodes");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReleaseSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseSchedule");
          final int _cursorIndexOfIsFollowing = CursorUtil.getColumnIndexOrThrow(_cursor, "isFollowing");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<SeriesEntity> _result = new ArrayList<SeriesEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SeriesEntity _item;
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
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpBannerUrl;
            if (_cursor.isNull(_cursorIndexOfBannerUrl)) {
              _tmpBannerUrl = null;
            } else {
              _tmpBannerUrl = _cursor.getString(_cursorIndexOfBannerUrl);
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
            final int _tmpTotalEpisodes;
            _tmpTotalEpisodes = _cursor.getInt(_cursorIndexOfTotalEpisodes);
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
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpReleaseSchedule;
            if (_cursor.isNull(_cursorIndexOfReleaseSchedule)) {
              _tmpReleaseSchedule = null;
            } else {
              _tmpReleaseSchedule = _cursor.getString(_cursorIndexOfReleaseSchedule);
            }
            final boolean _tmpIsFollowing;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFollowing);
            _tmpIsFollowing = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new SeriesEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpThumbnailUrl,_tmpBannerUrl,_tmpGenre,_tmpTags,_tmpTotalEpisodes,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpRating,_tmpReviewCount,_tmpIsPremium,_tmpStatus,_tmpReleaseSchedule,_tmpIsFollowing,_tmpCreatedAt,_tmpCachedAt);
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
  public Flow<List<SeriesEntity>> getSeriesByGenre(final String genre, final int limit) {
    final String _sql = "SELECT * FROM series WHERE genre = ? ORDER BY rating DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (genre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, genre);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"series"}, new Callable<List<SeriesEntity>>() {
      @Override
      @NonNull
      public List<SeriesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfBannerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfTotalEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalEpisodes");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReleaseSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseSchedule");
          final int _cursorIndexOfIsFollowing = CursorUtil.getColumnIndexOrThrow(_cursor, "isFollowing");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<SeriesEntity> _result = new ArrayList<SeriesEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SeriesEntity _item;
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
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpBannerUrl;
            if (_cursor.isNull(_cursorIndexOfBannerUrl)) {
              _tmpBannerUrl = null;
            } else {
              _tmpBannerUrl = _cursor.getString(_cursorIndexOfBannerUrl);
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
            final int _tmpTotalEpisodes;
            _tmpTotalEpisodes = _cursor.getInt(_cursorIndexOfTotalEpisodes);
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
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpReleaseSchedule;
            if (_cursor.isNull(_cursorIndexOfReleaseSchedule)) {
              _tmpReleaseSchedule = null;
            } else {
              _tmpReleaseSchedule = _cursor.getString(_cursorIndexOfReleaseSchedule);
            }
            final boolean _tmpIsFollowing;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFollowing);
            _tmpIsFollowing = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new SeriesEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpThumbnailUrl,_tmpBannerUrl,_tmpGenre,_tmpTags,_tmpTotalEpisodes,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpRating,_tmpReviewCount,_tmpIsPremium,_tmpStatus,_tmpReleaseSchedule,_tmpIsFollowing,_tmpCreatedAt,_tmpCachedAt);
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
  public Flow<List<SeriesEntity>> getFollowedSeries() {
    final String _sql = "SELECT * FROM series WHERE isFollowing = 1 ORDER BY cachedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"series"}, new Callable<List<SeriesEntity>>() {
      @Override
      @NonNull
      public List<SeriesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfBannerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfTotalEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalEpisodes");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReleaseSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseSchedule");
          final int _cursorIndexOfIsFollowing = CursorUtil.getColumnIndexOrThrow(_cursor, "isFollowing");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<SeriesEntity> _result = new ArrayList<SeriesEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SeriesEntity _item;
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
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpBannerUrl;
            if (_cursor.isNull(_cursorIndexOfBannerUrl)) {
              _tmpBannerUrl = null;
            } else {
              _tmpBannerUrl = _cursor.getString(_cursorIndexOfBannerUrl);
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
            final int _tmpTotalEpisodes;
            _tmpTotalEpisodes = _cursor.getInt(_cursorIndexOfTotalEpisodes);
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
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpReleaseSchedule;
            if (_cursor.isNull(_cursorIndexOfReleaseSchedule)) {
              _tmpReleaseSchedule = null;
            } else {
              _tmpReleaseSchedule = _cursor.getString(_cursorIndexOfReleaseSchedule);
            }
            final boolean _tmpIsFollowing;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFollowing);
            _tmpIsFollowing = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new SeriesEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpThumbnailUrl,_tmpBannerUrl,_tmpGenre,_tmpTags,_tmpTotalEpisodes,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpRating,_tmpReviewCount,_tmpIsPremium,_tmpStatus,_tmpReleaseSchedule,_tmpIsFollowing,_tmpCreatedAt,_tmpCachedAt);
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
  public Object getSeriesById(final String seriesId,
      final Continuation<? super SeriesEntity> $completion) {
    final String _sql = "SELECT * FROM series WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (seriesId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, seriesId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SeriesEntity>() {
      @Override
      @Nullable
      public SeriesEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfBannerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfTotalEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalEpisodes");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReleaseSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseSchedule");
          final int _cursorIndexOfIsFollowing = CursorUtil.getColumnIndexOrThrow(_cursor, "isFollowing");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final SeriesEntity _result;
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
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpBannerUrl;
            if (_cursor.isNull(_cursorIndexOfBannerUrl)) {
              _tmpBannerUrl = null;
            } else {
              _tmpBannerUrl = _cursor.getString(_cursorIndexOfBannerUrl);
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
            final int _tmpTotalEpisodes;
            _tmpTotalEpisodes = _cursor.getInt(_cursorIndexOfTotalEpisodes);
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
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpReleaseSchedule;
            if (_cursor.isNull(_cursorIndexOfReleaseSchedule)) {
              _tmpReleaseSchedule = null;
            } else {
              _tmpReleaseSchedule = _cursor.getString(_cursorIndexOfReleaseSchedule);
            }
            final boolean _tmpIsFollowing;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFollowing);
            _tmpIsFollowing = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _result = new SeriesEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpThumbnailUrl,_tmpBannerUrl,_tmpGenre,_tmpTags,_tmpTotalEpisodes,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpRating,_tmpReviewCount,_tmpIsPremium,_tmpStatus,_tmpReleaseSchedule,_tmpIsFollowing,_tmpCreatedAt,_tmpCachedAt);
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
  public Object searchSeries(final String query, final int limit,
      final Continuation<? super List<SeriesEntity>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM series\n"
            + "        WHERE title LIKE '%' || ? || '%'\n"
            + "        OR description LIKE '%' || ? || '%'\n"
            + "        ORDER BY rating DESC\n"
            + "        LIMIT ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
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
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SeriesEntity>>() {
      @Override
      @NonNull
      public List<SeriesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfBannerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfTotalEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalEpisodes");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReleaseSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseSchedule");
          final int _cursorIndexOfIsFollowing = CursorUtil.getColumnIndexOrThrow(_cursor, "isFollowing");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<SeriesEntity> _result = new ArrayList<SeriesEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SeriesEntity _item;
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
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpBannerUrl;
            if (_cursor.isNull(_cursorIndexOfBannerUrl)) {
              _tmpBannerUrl = null;
            } else {
              _tmpBannerUrl = _cursor.getString(_cursorIndexOfBannerUrl);
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
            final int _tmpTotalEpisodes;
            _tmpTotalEpisodes = _cursor.getInt(_cursorIndexOfTotalEpisodes);
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
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpReleaseSchedule;
            if (_cursor.isNull(_cursorIndexOfReleaseSchedule)) {
              _tmpReleaseSchedule = null;
            } else {
              _tmpReleaseSchedule = _cursor.getString(_cursorIndexOfReleaseSchedule);
            }
            final boolean _tmpIsFollowing;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFollowing);
            _tmpIsFollowing = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new SeriesEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpThumbnailUrl,_tmpBannerUrl,_tmpGenre,_tmpTags,_tmpTotalEpisodes,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpRating,_tmpReviewCount,_tmpIsPremium,_tmpStatus,_tmpReleaseSchedule,_tmpIsFollowing,_tmpCreatedAt,_tmpCachedAt);
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
  public Flow<List<SeriesEntity>> getTopRatedSeries() {
    final String _sql = "SELECT * FROM series ORDER BY rating DESC LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"series"}, new Callable<List<SeriesEntity>>() {
      @Override
      @NonNull
      public List<SeriesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
          final int _cursorIndexOfBannerUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfTotalEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalEpisodes");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthorUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "authorUsername");
          final int _cursorIndexOfAuthorDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorDisplayName");
          final int _cursorIndexOfAuthorAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatarUrl");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReleaseSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseSchedule");
          final int _cursorIndexOfIsFollowing = CursorUtil.getColumnIndexOrThrow(_cursor, "isFollowing");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cachedAt");
          final List<SeriesEntity> _result = new ArrayList<SeriesEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SeriesEntity _item;
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
            final String _tmpThumbnailUrl;
            if (_cursor.isNull(_cursorIndexOfThumbnailUrl)) {
              _tmpThumbnailUrl = null;
            } else {
              _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            }
            final String _tmpBannerUrl;
            if (_cursor.isNull(_cursorIndexOfBannerUrl)) {
              _tmpBannerUrl = null;
            } else {
              _tmpBannerUrl = _cursor.getString(_cursorIndexOfBannerUrl);
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
            final int _tmpTotalEpisodes;
            _tmpTotalEpisodes = _cursor.getInt(_cursorIndexOfTotalEpisodes);
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
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpReleaseSchedule;
            if (_cursor.isNull(_cursorIndexOfReleaseSchedule)) {
              _tmpReleaseSchedule = null;
            } else {
              _tmpReleaseSchedule = _cursor.getString(_cursorIndexOfReleaseSchedule);
            }
            final boolean _tmpIsFollowing;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFollowing);
            _tmpIsFollowing = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new SeriesEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpThumbnailUrl,_tmpBannerUrl,_tmpGenre,_tmpTags,_tmpTotalEpisodes,_tmpAuthorId,_tmpAuthorUsername,_tmpAuthorDisplayName,_tmpAuthorAvatarUrl,_tmpRating,_tmpReviewCount,_tmpIsPremium,_tmpStatus,_tmpReleaseSchedule,_tmpIsFollowing,_tmpCreatedAt,_tmpCachedAt);
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
