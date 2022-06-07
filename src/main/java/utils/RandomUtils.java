package utils;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class RandomUtils {
    public static String randomMail() {
        return randomAlphabetic(7) + "@gmail.com";
    }

    public static String randomPassword() {
        return randomAlphabetic(7);
    }

    public static String randomText() {
        return randomAlphabetic(7);
    }
}
