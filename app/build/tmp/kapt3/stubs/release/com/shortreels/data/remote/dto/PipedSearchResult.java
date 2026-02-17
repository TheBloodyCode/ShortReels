package com.shortreels.data.remote.dto;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\tH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/shortreels/data/remote/dto/PipedSearchResult;", "", "items", "", "Lcom/shortreels/data/remote/dto/PipedTrendingResponse;", "nextpage", "", "suggestion", "corrected", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)V", "getCorrected", "()Z", "getItems", "()Ljava/util/List;", "getNextpage", "()Ljava/lang/String;", "getSuggestion", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class PipedSearchResult {
    @com.google.gson.annotations.SerializedName(value = "items")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shortreels.data.remote.dto.PipedTrendingResponse> items = null;
    @com.google.gson.annotations.SerializedName(value = "nextpage")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String nextpage = null;
    @com.google.gson.annotations.SerializedName(value = "suggestion")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String suggestion = null;
    @com.google.gson.annotations.SerializedName(value = "corrected")
    private final boolean corrected = false;
    
    public PipedSearchResult(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedTrendingResponse> items, @org.jetbrains.annotations.Nullable()
    java.lang.String nextpage, @org.jetbrains.annotations.Nullable()
    java.lang.String suggestion, boolean corrected) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedTrendingResponse> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNextpage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSuggestion() {
        return null;
    }
    
    public final boolean getCorrected() {
        return false;
    }
    
    public PipedSearchResult() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shortreels.data.remote.dto.PipedTrendingResponse> component1() {
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
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shortreels.data.remote.dto.PipedSearchResult copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shortreels.data.remote.dto.PipedTrendingResponse> items, @org.jetbrains.annotations.Nullable()
    java.lang.String nextpage, @org.jetbrains.annotations.Nullable()
    java.lang.String suggestion, boolean corrected) {
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