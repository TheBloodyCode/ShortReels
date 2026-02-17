package com.shortreels.data.local.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\bX\b\u0087\b\u0018\u00002\u00020\u0001B\u00b9\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0018\u0012\u0006\u0010\'\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020\n\u0012\u0006\u0010)\u001a\u00020\n\u0012\b\b\u0002\u0010*\u001a\u00020\n\u00a2\u0006\u0002\u0010+J\t\u0010P\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\t\u0010U\u001a\u00020\nH\u00c6\u0003J\t\u0010V\u001a\u00020\nH\u00c6\u0003J\t\u0010W\u001a\u00020\nH\u00c6\u0003J\t\u0010X\u001a\u00020\nH\u00c6\u0003J\t\u0010Y\u001a\u00020\nH\u00c6\u0003J\t\u0010Z\u001a\u00020\u0018H\u00c6\u0003J\t\u0010[\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0018H\u00c6\u0003J\t\u0010]\u001a\u00020\fH\u00c6\u0003J\t\u0010^\u001a\u00020\u0003H\u00c6\u0003J\t\u0010_\u001a\u00020\u0018H\u00c6\u0003J\t\u0010`\u001a\u00020\u0018H\u00c6\u0003J\t\u0010a\u001a\u00020\u0018H\u00c6\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020!H\u00c6\u0003J\t\u0010d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010g\u001a\u00020\u0003H\u00c6\u0003J\t\u0010h\u001a\u00020\u0003H\u00c6\u0003J\t\u0010i\u001a\u00020\u0018H\u00c6\u0003J\t\u0010j\u001a\u00020\nH\u00c6\u0003J\t\u0010k\u001a\u00020\nH\u00c6\u0003J\t\u0010l\u001a\u00020\nH\u00c6\u0003J\t\u0010m\u001a\u00020\nH\u00c6\u0003J\t\u0010n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010o\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010q\u001a\u00020\nH\u00c6\u0003J\t\u0010r\u001a\u00020\fH\u00c6\u0003J\t\u0010s\u001a\u00020\fH\u00c6\u0003J\u00f5\u0002\u0010t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00182\b\b\u0002\u0010\'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020\nH\u00c6\u0001J\u0013\u0010u\u001a\u00020\u00182\b\u0010v\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010w\u001a\u00020\fH\u00d6\u0001J\t\u0010x\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010%\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010$\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\'\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\"\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010&\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010#\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0011\u0010\u0016\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00100R\u0011\u0010*\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u0011\u0010\u001a\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00100R\u0011\u0010(\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010-R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0011\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u00103R\u0011\u0010\u001e\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u00103R\u0011\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u00103R\u0011\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u00103R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u00103R\u0011\u0010\u0012\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00108R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0011\u0010\u0014\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010-R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010-R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010-R\u0011\u0010)\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010-R\u0011\u0010\u0015\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u0011\u0010 \u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010O\u00a8\u0006y"}, d2 = {"Lcom/shortreels/data/local/entities/VideoEntity;", "", "id", "", "title", "description", "videoUrl", "thumbnailUrl", "hlsUrl", "duration", "", "episode", "", "season", "seriesId", "seriesTitle", "genre", "tags", "likeCount", "commentCount", "shareCount", "viewCount", "bookmarkCount", "isPremium", "", "isLocked", "coinsRequired", "unlockType", "isLiked", "isBookmarked", "isDownloaded", "localPath", "watchProgress", "", "authorId", "authorUsername", "authorDisplayName", "authorAvatarUrl", "authorIsVerified", "authorFollowerCount", "createdAt", "updatedAt", "cachedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJZZILjava/lang/String;ZZZLjava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJJJ)V", "getAuthorAvatarUrl", "()Ljava/lang/String;", "getAuthorDisplayName", "getAuthorFollowerCount", "()J", "getAuthorId", "getAuthorIsVerified", "()Z", "getAuthorUsername", "getBookmarkCount", "getCachedAt", "getCoinsRequired", "()I", "getCommentCount", "getCreatedAt", "getDescription", "getDuration", "getEpisode", "getGenre", "getHlsUrl", "getId", "getLikeCount", "getLocalPath", "getSeason", "getSeriesId", "getSeriesTitle", "getShareCount", "getTags", "getThumbnailUrl", "getTitle", "getUnlockType", "getUpdatedAt", "getVideoUrl", "getViewCount", "getWatchProgress", "()F", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"})
@androidx.room.Entity(tableName = "videos")
public final class VideoEntity {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String videoUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String thumbnailUrl = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String hlsUrl = null;
    private final long duration = 0L;
    private final int episode = 0;
    private final int season = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String seriesId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String seriesTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String genre = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tags = null;
    private final long likeCount = 0L;
    private final long commentCount = 0L;
    private final long shareCount = 0L;
    private final long viewCount = 0L;
    private final long bookmarkCount = 0L;
    private final boolean isPremium = false;
    private final boolean isLocked = false;
    private final int coinsRequired = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String unlockType = null;
    private final boolean isLiked = false;
    private final boolean isBookmarked = false;
    private final boolean isDownloaded = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String localPath = null;
    private final float watchProgress = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorUsername = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorDisplayName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorAvatarUrl = null;
    private final boolean authorIsVerified = false;
    private final long authorFollowerCount = 0L;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    private final long cachedAt = 0L;
    
    public VideoEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hlsUrl, long duration, int episode, int season, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, @org.jetbrains.annotations.NotNull()
    java.lang.String tags, long likeCount, long commentCount, long shareCount, long viewCount, long bookmarkCount, boolean isPremium, boolean isLocked, int coinsRequired, @org.jetbrains.annotations.NotNull()
    java.lang.String unlockType, boolean isLiked, boolean isBookmarked, boolean isDownloaded, @org.jetbrains.annotations.Nullable()
    java.lang.String localPath, float watchProgress, @org.jetbrains.annotations.NotNull()
    java.lang.String authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String authorUsername, @org.jetbrains.annotations.NotNull()
    java.lang.String authorDisplayName, @org.jetbrains.annotations.NotNull()
    java.lang.String authorAvatarUrl, boolean authorIsVerified, long authorFollowerCount, long createdAt, long updatedAt, long cachedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVideoUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThumbnailUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHlsUrl() {
        return null;
    }
    
    public final long getDuration() {
        return 0L;
    }
    
    public final int getEpisode() {
        return 0;
    }
    
    public final int getSeason() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeriesId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeriesTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGenre() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTags() {
        return null;
    }
    
    public final long getLikeCount() {
        return 0L;
    }
    
    public final long getCommentCount() {
        return 0L;
    }
    
    public final long getShareCount() {
        return 0L;
    }
    
    public final long getViewCount() {
        return 0L;
    }
    
    public final long getBookmarkCount() {
        return 0L;
    }
    
    public final boolean isPremium() {
        return false;
    }
    
    public final boolean isLocked() {
        return false;
    }
    
    public final int getCoinsRequired() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnlockType() {
        return null;
    }
    
    public final boolean isLiked() {
        return false;
    }
    
    public final boolean isBookmarked() {
        return false;
    }
    
    public final boolean isDownloaded() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocalPath() {
        return null;
    }
    
    public final float getWatchProgress() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorAvatarUrl() {
        return null;
    }
    
    public final boolean getAuthorIsVerified() {
        return false;
    }
    
    public final long getAuthorFollowerCount() {
        return 0L;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final long getCachedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final long component15() {
        return 0L;
    }
    
    public final long component16() {
        return 0L;
    }
    
    public final long component17() {
        return 0L;
    }
    
    public final long component18() {
        return 0L;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component20() {
        return false;
    }
    
    public final int component21() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final boolean component24() {
        return false;
    }
    
    public final boolean component25() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component26() {
        return null;
    }
    
    public final float component27() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component31() {
        return null;
    }
    
    public final boolean component32() {
        return false;
    }
    
    public final long component33() {
        return 0L;
    }
    
    public final long component34() {
        return 0L;
    }
    
    public final long component35() {
        return 0L;
    }
    
    public final long component36() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.local.entities.VideoEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hlsUrl, long duration, int episode, int season, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, @org.jetbrains.annotations.NotNull()
    java.lang.String tags, long likeCount, long commentCount, long shareCount, long viewCount, long bookmarkCount, boolean isPremium, boolean isLocked, int coinsRequired, @org.jetbrains.annotations.NotNull()
    java.lang.String unlockType, boolean isLiked, boolean isBookmarked, boolean isDownloaded, @org.jetbrains.annotations.Nullable()
    java.lang.String localPath, float watchProgress, @org.jetbrains.annotations.NotNull()
    java.lang.String authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String authorUsername, @org.jetbrains.annotations.NotNull()
    java.lang.String authorDisplayName, @org.jetbrains.annotations.NotNull()
    java.lang.String authorAvatarUrl, boolean authorIsVerified, long authorFollowerCount, long createdAt, long updatedAt, long cachedAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}