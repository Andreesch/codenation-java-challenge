package com.codenation.challenge.caesarcrypto.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptHelper {

    public static String toSHA1Encrypt(String text) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] hash = messageDigest.digest(text.getBytes(StandardCharsets.UTF_8));

            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String bytesToHex(byte[] bytes) {

        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
