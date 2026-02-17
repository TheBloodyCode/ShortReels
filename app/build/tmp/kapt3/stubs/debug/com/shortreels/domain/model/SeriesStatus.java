package com.shortreels.domain.model;

import android.os.Parcelable;
import kotlinx.parcelize.Parcelize;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/shortreels/domain/model/SeriesStatus;", "", "(Ljava/lang/String;I)V", "ONGOING", "COMPLETED", "HIATUS", "COMING_SOON", "app_debug"})
public enum SeriesStatus {
    /*public static final*/ ONGOING /* = new ONGOING() */,
    /*public static final*/ COMPLETED /* = new COMPLETED() */,
    /*public static final*/ HIATUS /* = new HIATUS() */,
    /*public static final*/ COMING_SOON /* = new COMING_SOON() */;
    
    SeriesStatus() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.shortreels.domain.model.SeriesStatus> getEntries() {
        return null;
    }
}