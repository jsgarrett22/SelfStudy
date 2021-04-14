package edu.cscc.classes;

public class Board {

    private int width;
    private int height;
    private char defaultValue = '_';
    private char[][] board;

    Board(int width, int height) {
        this.width = width;
        this.height = height;
        populate(this.width, this.height, defaultValue);
    }

    /** METHOD THAT POPULATES ELEMENT WITH A DEFAULT VALUE */
    private void populate(int width, int height, char defaultValue) {
        board = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = defaultValue;
            }
        }
    }

    /** DRAWS BOARD TO CONSOLE */
    public void draw() {

        // draw column headers based on width of board
        for (int i = 0; i < width; i++) {
            System.out.print("| " + i + " ");
            if (i == width - 1) {
                System.out.print("| ");
            }
        }

        System.out.println();

        // draw entire board
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0 && i != 0) {
                    System.out.println();
                }
                System.out.print("| " + board[i][j] + " ");
                if (j == width - 1) {
                    System.out.print("| " + i);
                }
            }
        }

        System.out.println();

    }

    public void update(int column, int row, char icon) {

    }

}

class BoardFactory {

    public static Board create(int width, int height) {
        return new Board(width, height);
    }

}

class BoardDemo {
    public static void main(String[] args) {
        Board ticTacToe = BoardFactory.create(1, 1);
        ticTacToe.draw();

//        Board checkersBoard = BoardFactory.create(8, 8);
//        checkersBoard.draw();
//
//        Board battleshipBoard = BoardFactory.create(10, 10);
//        battleshipBoard.draw();
    }
}
