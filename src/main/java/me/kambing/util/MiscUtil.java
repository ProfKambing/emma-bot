package me.kambing.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A collection of misc utilities used throughout the bot
 */
public class MiscUtil {
    /**
     * Gets a random string from an array of strings
     *
     * @param array the array
     * @return a random value from the array
     */
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    /**
     * Sorts a given map of objects by their value
     *
     * @param map the map to sort
     * @param <K> key
     * @param <V> value (to sort by)
     * @return a sorted map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    /**
     * <a href="https://github.com/ChewMC/TransmuteIt/blob/2b86/src/pw/chew/transmuteit/DiscoveriesCommand.java#L174-L186">Source</a><br>
     * Capitalizes a String, e.g. "BRUH_MOMENT" -> "Bruh Moment"
     *
     * @param to the unformatted string
     * @return a formatting string
     * @author Chew
     */
    public static String capitalize(String to) {
        if (to.equals("")) {
            return "";
        }
        String[] words = to.split("_");
        StringBuilder newword = new StringBuilder();
        for (String word : words) {
            String rest = word.substring(1).toLowerCase();
            String first = word.substring(0, 1).toUpperCase();
            newword.append(first).append(rest).append(" ");
        }
        return newword.toString();
    }

    /**
     * Converts a given amount of bytes into friendlier data.<br>
     * Example: 2048 => 2 KB
     *
     * @param bytes the amount of bytes
     * @return the formatted string
     */
    public static String bytesToFriendly(long bytes) {
        // Find size of repo and list it
        int k = 1024;
        String[] measure = new String[]{"B", "KB", "MB", "GB", "TB"};
        double i;
        if (bytes == 0) {
            i = 0;
        } else {
            i = Math.floor(Math.log(bytes) / Math.log(k));
        }
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(bytes / Math.pow(k, i)) + " " + measure[(int) i + 1];
    }
}
