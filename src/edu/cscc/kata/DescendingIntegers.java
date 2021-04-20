package edu.cscc.kata;

import java.util.*;

/**
 * Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order.
 * Essentially, rearrange the digits to create the highest possible number.
 *
 */
public class DescendingIntegers {

    public static void main(String[] args) {

        int firstNum = 42145;
        int secondNum = 145263;
        int thirdNum = 123456789;

        System.out.println(sortDesc(firstNum));
        System.out.println(sortDesc(secondNum));
        System.out.println(sortDesc(thirdNum));

    }

    public static int sortDesc(final int num) {

        // int -> String -> char array
        char[] cInt = String.valueOf(num).toCharArray();
        List<Integer> list = new ArrayList<Integer>();
        StringBuilder sbInt = new StringBuilder();

        // for every char, convert to Integer and add to Integer list
        for (char c : cInt) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }

        // sort list in descending order
        list.sort(Collections.reverseOrder());

        // converts each integer in the list to a single int
        int sum = 0;
        for (Integer i : list) {
            sum = 10*sum + i;
        }

        return sum;
    }
}
