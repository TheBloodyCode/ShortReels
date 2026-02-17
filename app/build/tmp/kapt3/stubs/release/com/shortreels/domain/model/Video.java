package com.shortreels.domain.model;

import android.os.Parcelable;
import kotlinx.parcelize.Parcelize;

/**
 * Core domain models for ShortReels
 * These are clean, framework-independent data classes used across layers.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b>\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00c9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020!\u00a2\u0006\u0002\u0010\"J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0011H\u00c6\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u00c6\u0003J\t\u0010K\u001a\u00020\u0015H\u00c6\u0003J\t\u0010L\u001a\u00020\u0017H\u00c6\u0003J\t\u0010M\u001a\u00020\u0019H\u00c6\u0003J\t\u0010N\u001a\u00020\nH\u00c6\u0003J\t\u0010O\u001a\u00020\nH\u00c6\u0003J\t\u0010P\u001a\u00020\u001dH\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010R\u001a\u00020\u001dH\u00c6\u0003J\t\u0010S\u001a\u00020\u001dH\u00c6\u0003J\t\u0010T\u001a\u00020!H\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010Y\u001a\u00020\nH\u00c6\u0003J\t\u0010Z\u001a\u00020\fH\u00c6\u0003J\t\u0010[\u001a\u00020\fH\u00c6\u0003J\u00ed\u0001\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020!H\u00c6\u0001J\t\u0010]\u001a\u00020\fH\u00d6\u0001J\u0013\u0010^\u001a\u00020\u001d2\b\u0010_\u001a\u0004\u0018\u00010`H\u00d6\u0003J\t\u0010a\u001a\u00020\fH\u00d6\u0001J\t\u0010b\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u001a\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u001a\u0010\u001e\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u00100\"\u0004\b1\u00102R\u001a\u0010\u001f\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u00100\"\u0004\b3\u00102R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u00100\"\u0004\b4\u00102R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0011\u0010\u001b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010&R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010(R\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E\u00a8\u0006h"}, d2 = {"Lcom/shortreels/domain/model/Video;", "Landroid/os/Parcelable;", "id", "", "title", "description", "videoUrl", "thumbnailUrl", "hlsUrl", "duration", "", "episode", "", "season", "seriesId", "seriesTitle", "genre", "Lcom/shortreels/domain/model/Genre;", "tags", "", "author", "Lcom/shortreels/domain/model/Author;", "stats", "Lcom/shortreels/domain/model/VideoStats;", "monetization", "Lcom/shortreels/domain/model/Monetization;", "createdAt", "updatedAt", "isLiked", "", "isBookmarked", "isDownloaded", "watchProgress", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/String;Lcom/shortreels/domain/model/Genre;Ljava/util/List;Lcom/shortreels/domain/model/Author;Lcom/shortreels/domain/model/VideoStats;Lcom/shortreels/domain/model/Monetization;JJZZZF)V", "getAuthor", "()Lcom/shortreels/domain/model/Author;", "getCreatedAt", "()J", "getDescription", "()Ljava/lang/String;", "getDuration", "getEpisode", "()I", "getGenre", "()Lcom/shortreels/domain/model/Genre;", "getHlsUrl", "getId", "()Z", "setBookmarked", "(Z)V", "setDownloaded", "setLiked", "getMonetization", "()Lcom/shortreels/domain/model/Monetization;", "getSeason", "getSeriesId", "getSeriesTitle", "getStats", "()Lcom/shortreels/domain/model/VideoStats;", "getTags", "()Ljava/util/List;", "getThumbnailUrl", "getTitle", "getUpdatedAt", "getVideoUrl", "getWatchProgress", "()F", "setWatchProgress", "(F)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"})
@kotlinx.parcelize.Parcelize()
public final class Video implements android.os.Parcelable {
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
    private final com.shortreels.domain.model.Genre genre = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tags = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.domain.model.Author author = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.domain.model.VideoStats stats = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.domain.model.Monetization monetization = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    private boolean isLiked;
    private boolean isBookmarked;
    private boolean isDownloaded;
    private float watchProgress;
    
    public Video(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hlsUrl, long duration, int episode, int season, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesTitle, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Genre genre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Author author, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.VideoStats stats, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Monetization monetization, long createdAt, long updatedAt, boolean isLiked, boolean isBookmarked, boolean isDownloaded, float watchProgress) {
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
    public final com.shortreels.domain.model.Genre getGenre() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Author getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.VideoStats getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Monetization getMonetization() {
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
    
    public final void setLiked(boolean p0) {
    }
    
    public final boolean isBookmarked() {
        return false;
    }
    
    public final void setBookmarked(boolean p0) {
    }
    
    public final boolean isDownloaded() {
        return false;
    }
    
    public final void setDownloaded(boolean p0) {
    }
    
    public final float getWatchProgress() {
        return 0.0F;
    }
    
    public final void setWatchProgress(float p0) {
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
    public final com.shortreels.domain.model.Genre component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Author component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.VideoStats component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Monetization component16() {
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
    
    public final boolean component21() {
        return false;
    }
    
    public final float component22() {
        return 0.0F;
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
    public final com.shortreels.domain.model.Video copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hlsUrl, long duration, int episode, int season, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesId, @org.jetbrains.annotations.NotNull()
    java.lang.String seriesTitle, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Genre genre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Author author, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.VideoStats stats, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Monetization monetization, long createdAt, long updatedAt, boolean isLiked, boolean isBookmarked, boolean isDownloaded, float watchProgress) {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
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
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
}