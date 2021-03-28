package edu.cscc.arrays;

import java.util.Scanner;

public class MultiDimensionArray {

    public static void main(String[] args) {

        // Game Variables
        boolean running = true;
        boolean validateIcon = false;

        // Board Variables
        int width = 8;
        int height = 8;
        char defaultValue = '_';

        // Player and Computer Variables
        Scanner input = new Scanner(System.in);
        char playerIcon = ' ';
        char computerIcon = ' ';
        int columnPick, rowPick;

        // Create board of characters
        char[][] board = new char[width][height];

        populate(width, height, board, '_');

        System.out.println("~~ TIC_TAC_TOE CONSOLE ~~");

        // draws game board
        draw(width, height, board);

        // Get player's icon of choice
        while (!validateIcon) {
            System.out.println("What icon would you like? X or O?: ");
            playerIcon = input.next().charAt(0);
            switch (playerIcon) {
                case 'X':
                case 'x':
                    computerIcon = 'O';
                    validateIcon = true;
                    break;
                case 'O':
                case 'o':
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
        System.out.println("PLAYER TURN.");
        System.out.print("Enter Column: ");
        columnPick = input.nextInt();
        System.out.println();
        System.out.print("Enter Row: ");
        rowPick = input.nextInt();
        System.out.println("PLAYER TURN.");

        // set player pick on board
        board[rowPick][columnPick] = playerIcon;

        // redraw board
        draw(width, height, board);
    }

    /** METHOD THAT DRAWS GAME BOARD */
    public static void draw(int width, int height, char[][] board) {

        // draw header based on width of board
        for (int i = 0; i < width; i++) {
            if (i == 0) {
                //System.out.print("| ");
            }
            System.out.print("| " + i + " ");
            if (i == width - 1) {
                System.out.print("| ");
            }
        }

        System.out.println();

        // draw entire board
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0 && i != 0) {
                    System.out.println();
                }
                System.out.print("| " + board[i][j] + " ");
                if (j == height - 1) {
                    System.out.print("| " + i);
                }
            }
        }
        System.out.println();
    }

    /** METHOD THAT GIVES EACH ELEMENT OF THE BOARD A DEFAULT VALUE */
    public static void populate(int width, int height, char[][] board, char defaultValue) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = defaultValue;
            }
        }
    }
}
