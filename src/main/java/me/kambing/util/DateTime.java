package me.kambing.util;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

// Find time difference between 2 date in words
public class DateTime {
    public static String timeAgo(long different, boolean useSeconds) {
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        long yearsInMilli = daysInMilli * 365;

        long elapsedYears = different / yearsInMilli;
        different = different % yearsInMilli;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        ArrayList<String> output = new ArrayList<>();
        if(elapsedYears > 0)
            output.add(elapsedYears + " year" + (elapsedYears > 1 ? "s" : ""));
        if(elapsedDays > 0)
            output.add(elapsedDays + " day" + (elapsedDays > 1 ? "s" : ""));
        if(elapsedHours > 0)
            output.add(elapsedHours + " hour" + (elapsedHours > 1 ? "s" : ""));
        if(elapsedMinutes > 0)
            output.add(elapsedMinutes + " minute" + (elapsedMinutes > 1 ? "s" : ""));
        if(elapsedSeconds > 0 && useSeconds)
            output.add(elapsedSeconds + " second" + (elapsedSeconds > 1 ? "s" : ""));

        StringBuilder response = new StringBuilder();
        for (String module : output) {
            if(response.toString().equals("")) {
                response = new StringBuilder(module);
            } else if(module.equals(output.get(output.size() - 1))) {
                response.append(", and ").append(module);
            } else {
                response.append(", ").append(module);
            }
        }

        return response.toString();
    }
    public static String timeAgo(long different) {
        return timeAgo(different, true);
    }

    public static String timeAgoShort(long different, boolean useSeconds) {
        String timeAgo = timeAgo(different, useSeconds);
        String[] parts = timeAgo.replace(" and", "").split(", ");
        List<String> response = new ArrayList<>();
        for (String part : parts) {
            String[] values = part.split(" ");
            response.add(values[0] + "" + values[1].charAt(0));
        }
        return String.join(" ", response);
    }

    public static String timeAgoShort(Instant time, boolean useSeconds) {
        long diff = Instant.now().toEpochMilli() - time.toEpochMilli();
        return timeAgoShort(diff, useSeconds);
    }
}
