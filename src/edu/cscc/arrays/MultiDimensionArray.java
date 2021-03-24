package edu.cscc.arrays;

import java.util.Scanner;

public class MultiDimensionArray {

    public static void main(String[] args) {

        // Game Variables
        boolean running = true;
        boolean validateIcon = false;

        // Board Variables
        int width = 3;
        int height = 3;
        char defaultValue = '_';

        // Player and Computer Variables
        Scanner input = new Scanner(System.in);
        char playerIcon = ' ';
        char computerIcon = ' ';

        char board[][] = new char[width][height];

        // gives the game board a default value
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = defaultValue;
            }
        }

        System.out.println("~~ TIC_TAC_TOE CONSOLE ~~");

        // draws game board
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0 && i != 0) {
                    System.out.println();
                }
                System.out.print("| " + board[i][j] + " ");
                if (j == height - 1) {
                    System.out.print("|");
                }
            }
        }
        System.out.println();

        // Get player's icon of choice
        while (!validateIcon) {
            System.out.println("What icon would you like? X or O?: ");
            playerIcon = input.next().charAt(0);
            switch (playerIcon) {
                case 'X':
                    computerIcon = 'O';
                    validateIcon = true;
                    break;
                case 'O':
                    computerIcon = 'X';
                    validateIcon = true;
                    break;
                default:
                    System.out.println("Please select again.");
                    break;
            }
        }
        System.out.println("Player's icon is: " + playerIcon);
        System.out.println("Computer's icon is: " + computerIcon);
    }
}
