package edu.cscc.ForEach;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // For-each - traversing technique to iterate through an array or collection
        //            less steps, more readable
        //            less flexible

        int rows = 10;
        int columns = 10;

        // Create board
        ArrayList<ArrayList<Character>> board = new ArrayList<>();

        // Populate board with rows and columns
        for (int i = 0; i < rows; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < columns; j++) {
                board.get(i).add('#');
            }
        }

        // Draw board to console custom
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board.get(i).get(j));
                if (j == columns - 1) {
                    System.out.println();
                }
            }
        }

        // For-Each loop for iterating over each array or row in board
        for (ArrayList<Character> c : board) {
            System.out.println(c);
        }
    }
}
