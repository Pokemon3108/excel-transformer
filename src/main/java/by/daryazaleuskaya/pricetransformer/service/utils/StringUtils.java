package by.daryazaleuskaya.pricetransformer.service.utils;

public class StringUtils {

    private StringUtils() {}

    public static boolean contains(String sourceString, String comparableString) {
        return sourceString.toUpperCase().contains(comparableString.toUpperCase());
    }
}
