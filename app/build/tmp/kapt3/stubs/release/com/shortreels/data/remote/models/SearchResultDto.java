package com.shortreels.data.remote.models;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\nH\u00c6\u0003JC\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/shortreels/data/remote/models/SearchResultDto;", "", "videos", "", "Lcom/shortreels/data/remote/models/VideoDto;", "series", "Lcom/shortreels/data/remote/models/SeriesDto;", "authors", "Lcom/shortreels/data/remote/models/AuthorDto;", "totalResults", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getAuthors", "()Ljava/util/List;", "getSeries", "getTotalResults", "()I", "getVideos", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
public final class SearchResultDto {
    @com.google.gson.annotations.SerializedName(value = "videos")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.models.VideoDto> videos = null;
    @com.google.gson.annotations.SerializedName(value = "series")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.models.SeriesDto> series = null;
    @com.google.gson.annotations.SerializedName(value = "authors")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.models.AuthorDto> authors = null;
    @com.google.gson.annotations.SerializedName(value = "total_results")
    private final int totalResults = 0;
    
    public SearchResultDto(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.models.VideoDto> videos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.models.SeriesDto> series, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.models.AuthorDto> authors, int totalResults) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.models.VideoDto> getVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.models.SeriesDto> getSeries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.models.AuthorDto> getAuthors() {
        return null;
    }
    
    public final int getTotalResults() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.models.VideoDto> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.models.SeriesDto> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.models.AuthorDto> component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.models.SearchResultDto copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.models.VideoDto> videos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.models.SeriesDto> series, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.models.AuthorDto> authors, int totalResults) {
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