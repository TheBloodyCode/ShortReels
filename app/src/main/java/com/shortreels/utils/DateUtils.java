package com.shortreels.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Date/time formatting utilities in Java.
 */
public class DateUtils {

    private DateUtils() {}

    private static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String getRelativeTime(String isoDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT, Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = sdf.parse(isoDate);
            if (date == null) return "";

            long diffMs = System.currentTimeMillis() - date.getTime();
            long diffSec = TimeUnit.MILLISECONDS.toSeconds(diffMs);
            long diffMin = TimeUnit.MILLISECONDS.toMinutes(diffMs);
            long diffHours = TimeUnit.MILLISECONDS.toHours(diffMs);
            long diffDays = TimeUnit.MILLISECONDS.toDays(diffMs);

            if (diffSec < 60) return "ahora";
            else if (diffMin < 60) return diffMin + "m";
            else if (diffHours < 24) return diffHours + "h";
            else if (diffDays < 30) return diffDays + "d";
            else if (diffDays < 365) return (diffDays / 30) + "sem";
            else return (diffDays / 365) + "a";

        } catch (Exception e) {
            return "";
        }
    }

    public static String formatDate(String isoDate) {
        try {
            SimpleDateFormat input = new SimpleDateFormat(ISO_FORMAT, Locale.getDefault());
            input.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = input.parse(isoDate);
            if (date == null) return isoDate;
            SimpleDateFormat output = new SimpleDateFormat("d MMM yyyy", new Locale("es"));
            return output.format(date);
        } catch (Exception e) {
            return isoDate;
        }
    }
}
