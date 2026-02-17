package com.shortreels.utils;

import java.util.Locale;

/**
 * Number formatting utilities.
 * Written in Java to showcase Kotlin/Java interoperability.
 */
public class NumberUtils {

    private NumberUtils() {}

    /**
     * Format a large number to a compact string (1.2K, 3.4M, etc.)
     */
    public static String formatCount(long count) {
        if (count >= 1_000_000_000L) {
            return String.format(Locale.getDefault(), "%.1fB", count / 1_000_000_000.0);
        } else if (count >= 1_000_000L) {
            return String.format(Locale.getDefault(), "%.1fM", count / 1_000_000.0);
        } else if (count >= 1_000L) {
            return String.format(Locale.getDefault(), "%.1fK", count / 1_000.0);
        }
        return String.valueOf(count);
    }

    /**
     * Format seconds to MM:SS
     */
    public static String formatDuration(long seconds) {
        long minutes = seconds / 60;
        long secs = seconds % 60;
        if (minutes >= 60) {
            long hours = minutes / 60;
            minutes = minutes % 60;
            return String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
        }
        return String.format(Locale.getDefault(), "%d:%02d", minutes, secs);
    }

    /**
     * Format percentage 0..1 to 0%..100%
     */
    public static String formatProgress(float progress) {
        return String.format(Locale.getDefault(), "%.0f%%", progress * 100);
    }

    /**
     * Clamp value between min and max
     */
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
