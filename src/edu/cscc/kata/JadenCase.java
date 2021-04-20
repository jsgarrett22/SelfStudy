package edu.cscc.kata;

import java.util.Locale;

public class JadenCase {

    public static void main(String[] args) {
        System.out.println(toJadenCase("heLlO theRe joSHuA garRETt!"));
    }

    public static String toJadenCase(String phrase) {

        String reformattedString = "";
        // flag used to determine if current char is a space or not
        boolean isCharASpace = false;

        if (phrase != null && !phrase.isEmpty()) {
            char[] cPhrase = phrase.toCharArray();
            for (int i = 0; i < cPhrase.length; i++) {
                if (i == 0) {
                    reformattedString += Character.toUpperCase(cPhrase[i]);
                } else if (cPhrase[i] == ' ') {
                    reformattedString += cPhrase[i];
                    isCharASpace = true;
                } else if (isCharASpace) {
                    if (cPhrase[i] != ' ') {
                        reformattedString += Character.toUpperCase(cPhrase[i]);
                        isCharASpace = false;
                    }
                } else {
                    reformattedString += Character.toLowerCase(cPhrase[i]);
                }
            }
            return reformattedString;
        } else {
            throw new RuntimeException("The phrase can not be null.");
        }
    }
}

