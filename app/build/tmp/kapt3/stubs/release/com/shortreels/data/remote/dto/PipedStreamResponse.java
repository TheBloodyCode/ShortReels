package com.shortreels.data.remote.dto;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\u008d\u0001\u0010\'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006."}, d2 = {"Lcom/shortreels/data/remote/dto/PipedStreamResponse;", "", "title", "", "description", "uploadDate", "uploader", "uploaderAvatar", "thumbnailUrl", "hls", "audioStreams", "", "Lcom/shortreels/data/remote/dto/PipedStreamItem;", "videoStreams", "relatedStreams", "Lcom/shortreels/data/remote/dto/PipedRelatedStream;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAudioStreams", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getHls", "getRelatedStreams", "getThumbnailUrl", "getTitle", "getUploadDate", "getUploader", "getUploaderAvatar", "getVideoStreams", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class PipedStreamResponse {
    @com.google.gson.annotations.SerializedName(value = "title")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String title = null;
    @com.google.gson.annotations.SerializedName(value = "description")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String description = null;
    @com.google.gson.annotations.SerializedName(value = "uploadDate")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String uploadDate = null;
    @com.google.gson.annotations.SerializedName(value = "uploader")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String uploader = null;
    @com.google.gson.annotations.SerializedName(value = "uploaderAvatar")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String uploaderAvatar = null;
    @com.google.gson.annotations.SerializedName(value = "thumbnailUrl")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String thumbnailUrl = null;
    @com.google.gson.annotations.SerializedName(value = "hls")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String hls = null;
    @com.google.gson.annotations.SerializedName(value = "audioStreams")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> audioStreams = null;
    @com.google.gson.annotations.SerializedName(value = "videoStreams")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> videoStreams = null;
    @com.google.gson.annotations.SerializedName(value = "relatedStreams")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.dto.PipedRelatedStream> relatedStreams = null;
    
    public PipedStreamResponse(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String uploadDate, @org.jetbrains.annotations.Nullable()
    java.lang.String uploader, @org.jetbrains.annotations.Nullable()
    java.lang.String uploaderAvatar, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hls, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> audioStreams, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> videoStreams, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedRelatedStream> relatedStreams) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUploadDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUploader() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUploaderAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThumbnailUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHls() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> getAudioStreams() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> getVideoStreams() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedRelatedStream> getRelatedStreams() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedRelatedStream> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.dto.PipedStreamResponse copy(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String uploadDate, @org.jetbrains.annotations.Nullable()
    java.lang.String uploader, @org.jetbrains.annotations.Nullable()
    java.lang.String uploaderAvatar, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String hls, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> audioStreams, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedStreamItem> videoStreams, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedRelatedStream> relatedStreams) {
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