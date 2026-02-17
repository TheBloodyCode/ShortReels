# Add project specific ProGuard rules here.

# ===== Retrofit =====
-keepattributes Signature
-keepattributes *Annotation*
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# ===== OkHttp =====
-dontwarn okhttp3.**
-keep class okhttp3.** { *; }
-dontwarn okio.**

# ===== Gson =====
-keepattributes Signature
-keepattributes *Annotation*
-dontwarn sun.misc.**
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory { *; }
-keep class * implements com.google.gson.JsonSerializer { *; }
-keep class * implements com.google.gson.JsonDeserializer { *; }

# ===== Room =====
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.**

# ===== ExoPlayer / Media3 =====
-keep class com.google.android.exoplayer2.** { *; }
-keep class androidx.media3.** { *; }
-dontwarn androidx.media3.**

# ===== Hilt =====
-keep class dagger.** { *; }
-keep class javax.inject.** { *; }
-dontwarn dagger.**

# ===== DTOs - keep for Gson =====
-keep class com.shortreels.data.remote.dto.** { *; }
-keep class com.shortreels.data.models.** { *; }
-keep class com.shortreels.data.local.entities.** { *; }

# ===== Glide =====
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
    <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

# ===== Kotlin =====
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}

# ===== DataStore =====
-keep class androidx.datastore.** { *; }

# ===== Coroutines =====
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}
