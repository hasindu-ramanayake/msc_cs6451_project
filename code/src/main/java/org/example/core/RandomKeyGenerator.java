package org.example.core;


import java.security.SecureRandom;

public class RandomKeyGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int KEY_LENGTH = 16; // Adjust length as needed

    public static String generateRandomKey() {
        SecureRandom random = new SecureRandom();
        StringBuilder key = new StringBuilder(KEY_LENGTH);

        for (int i = 0; i < KEY_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            key.append(CHARACTERS.charAt(index));
        }

        return key.toString();
    }

}
