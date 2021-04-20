package edu.cscc.kata;

import java.util.Arrays;
import java.util.Locale;
import java.util.Stack;

// Take a string
// for every element of string, check to see if it is also contained in Alphabet
// if it is, it is a pangram and returns true, else it is not and returns false.
public class Pangram {

    public static void main(String[] args) {
        isPangram("The quick brown fox jumps over the lazy dog");
        isPangram("We promptly judged antique ivory buckles for the next prize");
    }

    /**
     *
     * @param sentence, string to check
     * @return returns true if the checked string contains all 26 letters of the alphabet. Otherwise, it returns false
     */
    static boolean isPangram(String sentence){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String containedInBoth = "";
        String checkedString = sentence.toLowerCase(Locale.ROOT);

        if (checkedString.equals("")) {
            System.out.println("An empty string can not be checked.");
            return false;
        }

        // populates a list of unique letters that are contained in both the alphabet and the checked string
        for (int i = 0; i < checkedString.length(); i++) {
            char currentChar = checkedString.charAt(i);
            if (alphabet.contains(Character.toString(currentChar)) && !containedInBoth.contains(Character.toString(currentChar))) {
                containedInBoth += currentChar;
            }
        }

        // converts array that contains characters in both and sorts it alphabetically
        char[] tempCharArray = containedInBoth.toCharArray();
        Arrays.sort(tempCharArray);
        containedInBoth = String.valueOf(tempCharArray);
        char[] tempCharAlphabet = alphabet.toCharArray();


        // compares both alphabet array and contained in both array to see if they equal each other
        if (alphabet.equalsIgnoreCase(containedInBoth)) {
            System.out.println("Both lists: \n" + alphabet + "\n" + containedInBoth);
            System.out.println("The string is a pangram!");
            return true;
        } else {
            System.out.println("Both lists: \n" + alphabet + "\n" + containedInBoth);
            System.out.println("The string is not a pangram!");
            return false;
        }
    }
}
