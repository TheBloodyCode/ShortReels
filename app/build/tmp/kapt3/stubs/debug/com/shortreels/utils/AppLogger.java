package com.shortreels.utils;

import android.util.Log;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J$\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/shortreels/utils/AppLogger;", "", "()V", "TAG", "", "isDebug", "", "d", "", "tag", "msg", "e", "t", "", "i", "init", "debug", "w", "app_debug"})
public final class AppLogger {
    private static boolean isDebug = false;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ShortReels";
    @org.jetbrains.annotations.NotNull()
    public static final com.shortreels.utils.AppLogger INSTANCE = null;
    
    private AppLogger() {
        super();
    }
    
    public final void init(boolean debug) {
    }
    
    public final void d(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void e(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable t) {
    }
    
    public final void i(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void w(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
}