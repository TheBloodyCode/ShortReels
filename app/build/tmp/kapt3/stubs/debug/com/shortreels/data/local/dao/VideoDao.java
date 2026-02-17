package com.shortreels.data.local.dao;

import androidx.room.*;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shortreels.data.local.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J(\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0014\u001a\u00020\tH\'J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\'J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010 \u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u00a7@\u00a2\u0006\u0002\u0010%J(\u0010&\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\tH\u00a7@\u00a2\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010+\u001a\u00020$H\u00a7@\u00a2\u0006\u0002\u0010%J\u0016\u0010,\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010-\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u00a7@\u00a2\u0006\u0002\u00100\u00a8\u00061"}, d2 = {"Lcom/shortreels/data/local/dao/VideoDao;", "", "deleteOldCache", "", "threshold", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVideo", "videoId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookmarkedVideos", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/shortreels/data/local/entities/VideoEntity;", "getFeedVideos", "limit", "", "offset", "getSeriesEpisodes", "seriesId", "getTrendingVideos", "getVideoById", "getVideosByGenre", "genre", "insertVideo", "video", "(Lcom/shortreels/data/local/entities/VideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertVideos", "videos", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchVideos", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBookmarkStatus", "isBookmarked", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDownloadStatus", "downloaded", "path", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLikeStatus", "isLiked", "updateVideo", "updateWatchProgress", "progress", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface VideoDao {
    
    @androidx.room.Query(value = "SELECT * FROM videos ORDER BY createdAt DESC LIMIT :limit OFFSET :offset")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.VideoEntity>> getFeedVideos(int limit, int offset);
    
    @androidx.room.Query(value = "SELECT * FROM videos WHERE seriesId = :seriesId ORDER BY season, episode")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.VideoEntity>> getSeriesEpisodes(@org.jetbrains.annotations.NotNull()
    java.lang.String seriesId);
    
    @androidx.room.Query(value = "SELECT * FROM videos WHERE genre = :genre ORDER BY viewCount DESC LIMIT :limit")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.VideoEntity>> getVideosByGenre(@org.jetbrains.annotations.NotNull()
    java.lang.String genre, int limit);
    
    @androidx.room.Query(value = "SELECT * FROM videos WHERE id = :videoId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVideoById(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.data.local.entities.VideoEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM videos WHERE isBookmarked = 1 ORDER BY cachedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.VideoEntity>> getBookmarkedVideos();
    
    @androidx.room.Query(value = "\n        SELECT v.* FROM videos v\n        WHERE v.title LIKE \'%\' || :query || \'%\'\n        OR v.description LIKE \'%\' || :query || \'%\'\n        OR v.seriesTitle LIKE \'%\' || :query || \'%\'\n        ORDER BY v.viewCount DESC\n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchVideos(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.shortreels.data.local.entities.VideoEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM videos WHERE viewCount > 500000 ORDER BY viewCount DESC LIMIT 20")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.VideoEntity>> getTrendingVideos();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertVideo(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.entities.VideoEntity video, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertVideos(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.local.entities.VideoEntity> videos, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateVideo(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.entities.VideoEntity video, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE videos SET isLiked = :isLiked WHERE id = :videoId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLikeStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, boolean isLiked, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE videos SET isBookmarked = :isBookmarked WHERE id = :videoId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBookmarkStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, boolean isBookmarked, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE videos SET watchProgress = :progress WHERE id = :videoId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWatchProgress(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, float progress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE videos SET isDownloaded = :downloaded, localPath = :path WHERE id = :videoId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDownloadStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, boolean downloaded, @org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM videos WHERE cachedAt < :threshold AND isDownloaded = 0 AND isBookmarked = 0")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOldCache(long threshold, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM videos WHERE id = :videoId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteVideo(@org.jetbrains.annotations.NotNull()
    java.lang.String videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}