package com.shortreels.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.shortreels.data.local.entities.CommentEntity;
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
public final class CommentDao_Impl implements CommentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CommentEntity> __insertionAdapterOfCommentEntity;

  private final SharedSQLiteStatement __preparedStmtOfToggleLike;

  private final SharedSQLiteStatement __preparedStmtOfDeleteVideoComments;

  public CommentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCommentEntity = new EntityInsertionAdapter<CommentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `comments` (`id`,`videoId`,`userId`,`userDisplayName`,`userAvatarUrl`,`content`,`likeCount`,`isLiked`,`isPinned`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CommentEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getVideoId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getVideoId());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUserId());
        }
        if (entity.getUserDisplayName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getUserDisplayName());
        }
        if (entity.getUserAvatarUrl() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUserAvatarUrl());
        }
        if (entity.getContent() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getContent());
        }
        statement.bindLong(7, entity.getLikeCount());
        final int _tmp = entity.isLiked() ? 1 : 0;
        statement.bindLong(8, _tmp);
        final int _tmp_1 = entity.isPinned() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__preparedStmtOfToggleLike = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE comments SET isLiked = ?, likeCount = likeCount + ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteVideoComments = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM comments WHERE videoId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertComment(final CommentEntity comment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCommentEntity.insert(comment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertComments(final List<CommentEntity> comments,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCommentEntity.insert(comments);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object toggleLike(final String commentId, final boolean isLiked, final int delta,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfToggleLike.acquire();
        int _argIndex = 1;
        final int _tmp = isLiked ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, delta);
        _argIndex = 3;
        if (commentId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, commentId);
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
          __preparedStmtOfToggleLike.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteVideoComments(final String videoId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteVideoComments.acquire();
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
          __preparedStmtOfDeleteVideoComments.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<CommentEntity>> getVideoComments(final String videoId, final int limit) {
    final String _sql = "SELECT * FROM comments WHERE videoId = ? ORDER BY isPinned DESC, createdAt DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (videoId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, videoId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"comments"}, new Callable<List<CommentEntity>>() {
      @Override
      @NonNull
      public List<CommentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfVideoId = CursorUtil.getColumnIndexOrThrow(_cursor, "videoId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfUserDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "userDisplayName");
          final int _cursorIndexOfUserAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "userAvatarUrl");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfLikeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "likeCount");
          final int _cursorIndexOfIsLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLiked");
          final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<CommentEntity> _result = new ArrayList<CommentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CommentEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpVideoId;
            if (_cursor.isNull(_cursorIndexOfVideoId)) {
              _tmpVideoId = null;
            } else {
              _tmpVideoId = _cursor.getString(_cursorIndexOfVideoId);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpUserDisplayName;
            if (_cursor.isNull(_cursorIndexOfUserDisplayName)) {
              _tmpUserDisplayName = null;
            } else {
              _tmpUserDisplayName = _cursor.getString(_cursorIndexOfUserDisplayName);
            }
            final String _tmpUserAvatarUrl;
            if (_cursor.isNull(_cursorIndexOfUserAvatarUrl)) {
              _tmpUserAvatarUrl = null;
            } else {
              _tmpUserAvatarUrl = _cursor.getString(_cursorIndexOfUserAvatarUrl);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final long _tmpLikeCount;
            _tmpLikeCount = _cursor.getLong(_cursorIndexOfLikeCount);
            final boolean _tmpIsLiked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsLiked);
            _tmpIsLiked = _tmp != 0;
            final boolean _tmpIsPinned;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPinned);
            _tmpIsPinned = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new CommentEntity(_tmpId,_tmpVideoId,_tmpUserId,_tmpUserDisplayName,_tmpUserAvatarUrl,_tmpContent,_tmpLikeCount,_tmpIsLiked,_tmpIsPinned,_tmpCreatedAt);
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
