package com.shortreels.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.shortreels.R;
import java.text.NumberFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u001c\u0010\t\u001a\u00020\u0007*\u00020\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u001a\n\u0010\f\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\r\u001a\u00020\u0007*\u00020\b\u001a\u001e\u0010\u000e\u001a\u00020\u0007*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u001a\u001e\u0010\u0013\u001a\u00020\u0007*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u001a2\u0010\u0014\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u001a\n\u0010\u0019\u001a\u00020\u0011*\u00020\u0004\u001a\n\u0010\u0019\u001a\u00020\u0011*\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u0011*\u00020\u001a\u001a\n\u0010\u001c\u001a\u00020\u0011*\u00020\u001a\u001a\u001c\u0010\u001d\u001a\u00020\u0007*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020!\u001a\u0012\u0010\u001d\u001a\u00020\u0007*\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0011\u001a\n\u0010#\u001a\u00020\u0007*\u00020\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006$"}, d2 = {"dp", "", "getDp", "(F)F", "", "(I)I", "animateIn", "", "Landroid/view/View;", "animateOut", "onEnd", "Lkotlin/Function0;", "gone", "invisible", "loadCircle", "Landroid/widget/ImageView;", "url", "", "placeholder", "loadUrl", "setMargins", "left", "top", "right", "bottom", "toFormattedCount", "", "toTimeDiff", "toTimeString", "toast", "Landroid/content/Context;", "msg", "long", "", "Landroidx/fragment/app/Fragment;", "visible", "app_release"})
public final class ExtensionsKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toFormattedCount(long $this$toFormattedCount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toFormattedCount(int $this$toFormattedCount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toTimeString(long $this$toTimeString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toTimeDiff(long $this$toTimeDiff) {
        return null;
    }
    
    public static final void visible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visible) {
    }
    
    public static final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$gone) {
    }
    
    public static final void invisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$invisible) {
    }
    
    public static final void animateIn(@org.jetbrains.annotations.NotNull()
    android.view.View $this$animateIn) {
    }
    
    public static final void animateOut(@org.jetbrains.annotations.NotNull()
    android.view.View $this$animateOut, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEnd) {
    }
    
    public static final void setMargins(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setMargins, int left, int top, int right, int bottom) {
    }
    
    public static final void loadUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String url, int placeholder) {
    }
    
    public static final void loadCircle(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadCircle, @org.jetbrains.annotations.Nullable()
    java.lang.String url, int placeholder) {
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, boolean p2_1663806) {
    }
    
    public static final int getDp(int $this$dp) {
        return 0;
    }
    
    public static final float getDp(float $this$dp) {
        return 0.0F;
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
}