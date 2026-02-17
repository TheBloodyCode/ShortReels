package com.shortreels.data.remote.models;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Objects (DTOs) - Remote API models
 * These represent the raw JSON structure from the API.
 * Mappers convert these to domain models.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001B\u00b3\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0002\u0010\u001eJ\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u00c6\u0003J\t\u0010>\u001a\u00020\u0014H\u00c6\u0003J\t\u0010?\u001a\u00020\u0016H\u00c6\u0003J\t\u0010@\u001a\u00020\u0018H\u00c6\u0003J\t\u0010A\u001a\u00020\nH\u00c6\u0003J\t\u0010B\u001a\u00020\nH\u00c6\u0003J\t\u0010C\u001a\u00020\u001cH\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u001cH\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\nH\u00c6\u0003J\t\u0010K\u001a\u00020\fH\u00c6\u0003J\t\u0010L\u001a\u00020\fH\u00c6\u0003J\u00d9\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u00c6\u0001J\u0013\u0010N\u001a\u00020\u001c2\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010P\u001a\u00020\fH\u00d6\u0001J\t\u0010Q\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0019\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0016\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010+R\u0016\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010+R\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\'R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0016\u0010\u001a\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010$\u00a8\u0006R"}, d2 = {"Lcom/shortreels/data/remote/models/VideoDto;", "", "id", "", "title", "description", "videoUrl", "thumbnailUrl", "hlsUrl", "duration", "", "episode", "", "season", "seriesId", "seriesTitle", "genre", "tags", "", "author", "Lcom/shortreels/data/remote/models/AuthorDto;", "stats", "Lcom/shortreels/data/remote/models/VideoStatsDto;", "monetization", "Lcom/shortreels/data/remote/models/MonetizationDto;", "createdAt", "updatedAt", "isLiked", "", "isBookmarked", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/shortreels/data/remote/models/AuthorDto;Lcom/shortreels/data/remote/models/VideoStatsDto;Lcom/shortreels/data/remote/models/MonetizationDto;JJZZ)V", "getAuthor", "()Lcom/shortreels/data/remote/models/AuthorDto;", "getCreatedAt", "()J", "getDescription", "()Ljava/lang/String;", "getDuration", "getEpisode", "()I", "getGenre", "getHlsUrl", "getId", "()Z", "getMonetization", "()Lcom/shortreels/data/remote/models/MonetizationDto;", "getSeason", "getSeriesId", "getSeriesTitle", "getStats", "()Lcom/shortreels/data/remote/models/VideoStatsDto;", "getTags", "()Ljava/util/List;", "getThumbnailUrl", "getTitle", "getUpdatedAt", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"})
public final class VideoDto {
    @com.google.gson.annotations.SerializedName(value = "id")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @com.google.gson.annotations.SerializedName(value = "title")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @com.google.gson.annotations.SerializedName(value = "description")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @com.google.gson.annotations.SerializedName(value = "video_url")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String videoUrl = null;
    @com.google.gson.annotations.SerializedName(value = "thumbnail_url")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String thumbnailUrl = null;
    @com.google.gson.annotations.SerializedName(value = "hls_url")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String hlsUrl = null;
    @com.google.gson.annotations.SerializedName(value = "duration")
    private final long duration = 0L;
    @com.google.gson.annotations.SerializedName(value = "episode")
    private final int episode = 0;
    @com.google.gson.annotations.SerializedName(value = "season")
    private final int season = 0;
    @com.google.gson.annotations.SerializedName(value = "series_id")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String seriesId = null;
    @com.google.gson.annotations.SerializedName(value = "series_title")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String seriesTitle = null;
    @com.google.gson.annotations.SerializedName(value = "genre")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String genre = null;
    @com.google.gson.annotations.SerializedName(value = "tags")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tags = null;
    @com.google.gson.annotations.SerializedName(value = "author")
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.remote.models.AuthorDto author = null;
    @com.google.gson.annotations.SerializedName(value = "stats")
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.remote.models.VideoStatsDto stats = null;
    @com.google.gson.annotations.SerializedName(value = "monetization")
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.data.remote.models.MonetizationDto monetization = null;
    @com.google.gson.annotations.SerializedName(value = "created_at")
    private final long createdAt = 0L;
    @com.google.gson.annotations.SerializedName(value = "updated_at")
    private final long updatedAt = 0L;
    @com.google.gson.annotations.SerializedName(value = "is_liked")
    private final boolean isLiked = false;
    @com.google.gson.annotations.SerializedName(value = "is_bookmarked")
    private final boolean isBookmarked = false;
    
    public VideoDto(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hlsUrl, long duration, int episode, int season, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.AuthorDto author, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.VideoStatsDto stats, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.MonetizationDto monetization, long createdAt, long updatedAt, boolean isLiked, boolean isBookmarked) {
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
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.models.AuthorDto getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.models.VideoStatsDto getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.models.MonetizationDto getMonetization() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final boolean isLiked() {
        return false;
    }
    
    public final boolean isBookmarked() {
        return false;
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
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.models.AuthorDto component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.models.VideoStatsDto component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.models.MonetizationDto component16() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
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
    public final com.shortreels.data.remote.models.VideoDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hlsUrl, long duration, int episode, int season, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String genre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.AuthorDto author, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.VideoStatsDto stats, @org.jetbrains.annotations.NotNull()
    com.shortreels.data.remote.models.MonetizationDto monetization, long createdAt, long updatedAt, boolean isLiked, boolean isBookmarked) {
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