package by.daryazaleuskaya.pricetransformer.service;

import java.nio.charset.StandardCharsets;

public class EncoderUtils {

    public static String getUtf8String(String input) {
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
