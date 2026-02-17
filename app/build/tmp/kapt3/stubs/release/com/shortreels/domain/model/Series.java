package com.shortreels.domain.model;

import android.os.Parcelable;
import kotlinx.parcelize.Parcelize;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0011H\u00c6\u0003J\t\u0010=\u001a\u00020\u0013H\u00c6\u0003J\t\u0010>\u001a\u00020\u000fH\u00c6\u0003J\t\u0010?\u001a\u00020\u0016H\u00c6\u0003J\t\u0010@\u001a\u00020\u0018H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u001bH\u00c6\u0003J\t\u0010C\u001a\u00020\u001dH\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\tH\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u00c6\u0003J\t\u0010K\u001a\u00020\u000fH\u00c6\u0003J\u00bf\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u00c6\u0001J\t\u0010M\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010N\u001a\u00020\u001d2\b\u0010O\u001a\u0004\u0018\u00010PH\u00d6\u0003J\t\u0010Q\u001a\u00020\u000fH\u00d6\u0001J\t\u0010R\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010+\"\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\'R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00104\u00a8\u0006X"}, d2 = {"Lcom/shortreels/domain/model/Series;", "Landroid/os/Parcelable;", "id", "", "title", "description", "thumbnailUrl", "bannerUrl", "genre", "Lcom/shortreels/domain/model/Genre;", "tags", "", "episodes", "Lcom/shortreels/domain/model/Video;", "totalEpisodes", "", "author", "Lcom/shortreels/domain/model/Author;", "rating", "", "reviewCount", "monetization", "Lcom/shortreels/domain/model/Monetization;", "status", "Lcom/shortreels/domain/model/SeriesStatus;", "releaseSchedule", "createdAt", "", "isFollowing", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/shortreels/domain/model/Genre;Ljava/util/List;Ljava/util/List;ILcom/shortreels/domain/model/Author;FILcom/shortreels/domain/model/Monetization;Lcom/shortreels/domain/model/SeriesStatus;Ljava/lang/String;JZ)V", "getAuthor", "()Lcom/shortreels/domain/model/Author;", "getBannerUrl", "()Ljava/lang/String;", "getCreatedAt", "()J", "getDescription", "getEpisodes", "()Ljava/util/List;", "getGenre", "()Lcom/shortreels/domain/model/Genre;", "getId", "()Z", "setFollowing", "(Z)V", "getMonetization", "()Lcom/shortreels/domain/model/Monetization;", "getRating", "()F", "getReleaseSchedule", "getReviewCount", "()I", "getStatus", "()Lcom/shortreels/domain/model/SeriesStatus;", "getTags", "getThumbnailUrl", "getTitle", "getTotalEpisodes", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"})
@kotlinx.parcelize.Parcelize()
public final class Series implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String thumbnailUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bannerUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.domain.model.Genre genre = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tags = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.domain.model.Video> episodes = null;
    private final int totalEpisodes = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.domain.model.Author author = null;
    private final float rating = 0.0F;
    private final int reviewCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.domain.model.Monetization monetization = null;
    @org.jetbrains.annotations.NotNull()
    private final com.shortreels.domain.model.SeriesStatus status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String releaseSchedule = null;
    private final long createdAt = 0L;
    private boolean isFollowing;
    
    public Series(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String bannerUrl, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Genre genre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.domain.model.Video> episodes, int totalEpisodes, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Author author, float rating, int reviewCount, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Monetization monetization, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.SeriesStatus status, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseSchedule, long createdAt, boolean isFollowing) {
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
    public final java.lang.String getThumbnailUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBannerUrl() {
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
    public final java.util.List<com.shortreels.domain.model.Video> getEpisodes() {
        return null;
    }
    
    public final int getTotalEpisodes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Author getAuthor() {
        return null;
    }
    
    public final float getRating() {
        return 0.0F;
    }
    
    public final int getReviewCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Monetization getMonetization() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.SeriesStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleaseSchedule() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final boolean isFollowing() {
        return false;
    }
    
    public final void setFollowing(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Author component10() {
        return null;
    }
    
    public final float component11() {
        return 0.0F;
    }
    
    public final int component12() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Monetization component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.SeriesStatus component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    public final long component16() {
        return 0L;
    }
    
    public final boolean component17() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Genre component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.domain.model.Video> component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.domain.model.Series copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String bannerUrl, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Genre genre, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.domain.model.Video> episodes, int totalEpisodes, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Author author, float rating, int reviewCount, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.Monetization monetization, @org.jetbrains.annotations.NotNull()
    com.shortreels.domain.model.SeriesStatus status, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseSchedule, long createdAt, boolean isFollowing) {
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