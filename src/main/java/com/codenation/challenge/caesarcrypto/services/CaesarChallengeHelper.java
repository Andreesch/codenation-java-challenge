package com.codenation.challenge.caesarcrypto.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CaesarChallengeHelper {

    /*
        Para resolver esse problema, podemos considerar a posição do caractere segunda a tabela ASCII.
        Precisamos apenas de um texto e um número de "giros/mudanças" que será aplicado na frase.
        A função Characters.isLetter() irá servir como auxiliar para determinar se aquele caractere é uma letra, do contrário, a posição não deverá ser alterada.
    */

    public static String encryptData(Integer shifts, String text) {
        char[] textToCharArray = text.toCharArray();
        char[] encryptedCharArray = new char[textToCharArray.length];

        for (int i = 0; i < textToCharArray.length; i++) {
            encryptedCharArray[i] = encryptWithShift(shifts, textToCharArray[i]);
        }

        return new String(encryptedCharArray);
    }

    public static String decryptData(Integer shifts, String text) {
        char[] textToCharArray = text.toCharArray();
        char[] decryptedCharArray = new char[textToCharArray.length];

        for (int i = 0; i < textToCharArray.length; i++) {
            decryptedCharArray[i] += decryptWithShift(shifts, textToCharArray[i]);
        }

        return new String(decryptedCharArray);
    }

    private static char encryptWithShift(int shifts, int pos) {
        return !isLetter(pos) ? (char) pos : (char) ((pos) + shifts);
    }

    private static char decryptWithShift(int shifts, int pos) {
        return !isLetter(pos) ? (char) pos : (char) ((pos) - shifts);
    }

    private static boolean isLetter(Integer asciiPosition) {
        return Character.isLetter(asciiPosition);
    }
}
