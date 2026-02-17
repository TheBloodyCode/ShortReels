package com.shortreels.data.remote.dto;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/shortreels/data/remote/dto/NotificationsResponse;", "", "notifications", "", "Lcom/shortreels/data/remote/dto/NotificationDto;", "page", "", "hasMore", "", "unreadCount", "(Ljava/util/List;IZI)V", "getHasMore", "()Z", "getNotifications", "()Ljava/util/List;", "getPage", "()I", "getUnreadCount", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_release"})
public final class NotificationsResponse {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.dto.NotificationDto> notifications = null;
    private final int page = 0;
    @com.google.gson.annotations.SerializedName(value = "has_more")
    private final boolean hasMore = false;
    @com.google.gson.annotations.SerializedName(value = "unread_count")
    private final int unreadCount = 0;
    
    public NotificationsResponse(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.NotificationDto> notifications, int page, boolean hasMore, int unreadCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.NotificationDto> getNotifications() {
        return null;
    }
    
    public final int getPage() {
        return 0;
    }
    
    public final boolean getHasMore() {
        return false;
    }
    
    public final int getUnreadCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.NotificationDto> component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.dto.NotificationsResponse copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.NotificationDto> notifications, int page, boolean hasMore, int unreadCount) {
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