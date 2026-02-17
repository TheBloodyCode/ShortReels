package com.shortreels.data.local.dao;

import androidx.room.*;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shortreels.data.local.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J&\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\'J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00a2\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/shortreels/data/local/dao/SeriesDao;", "", "deleteSeries", "", "seriesId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSeries", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/shortreels/data/local/entities/SeriesEntity;", "getFollowedSeries", "getSeriesByGenre", "genre", "limit", "", "getSeriesById", "getTopRatedSeries", "insertSeries", "series", "(Lcom/shortreels/data/local/entities/SeriesEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSeriesList", "seriesList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchSeries", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFollowStatus", "isFollowing", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@androidx.room.Dao()
public abstract interface SeriesDao {
    
    @androidx.room.Query(value = "SELECT * FROM series ORDER BY cachedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.SeriesEntity>> getAllSeries();
    
    @androidx.room.Query(value = "SELECT * FROM series WHERE genre = :genre ORDER BY rating DESC LIMIT :limit")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.SeriesEntity>> getSeriesByGenre(@org.jetbrains.annotations.NotNull()
    java.lang.String genre, int limit);
    
    @androidx.room.Query(value = "SELECT * FROM series WHERE isFollowing = 1 ORDER BY cachedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.SeriesEntity>> getFollowedSeries();
    
    @androidx.room.Query(value = "SELECT * FROM series WHERE id = :seriesId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSeriesById(@org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.shortreels.data.local.entities.SeriesEntity> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM series\n        WHERE title LIKE \'%\' || :query || \'%\'\n        OR description LIKE \'%\' || :query || \'%\'\n        ORDER BY rating DESC\n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchSeries(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.shortreels.data.local.entities.SeriesEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM series ORDER BY rating DESC LIMIT 10")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.shortreels.data.local.entities.SeriesEntity>> getTopRatedSeries();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSeries(@org.jetbrains.annotations.NotNull()
    com.shortreels.data.local.entities.SeriesEntity series, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSeriesList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.local.entities.SeriesEntity> seriesList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE series SET isFollowing = :isFollowing WHERE id = :seriesId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateFollowStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, boolean isFollowing, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM series WHERE id = :seriesId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSeries(@org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}