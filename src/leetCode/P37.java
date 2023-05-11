package leetCode;

import java.util.Arrays;

public class P37 { // Sudoku Solver
    static final int SIZE = 9;

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private static boolean solve(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        for (char i = '1'; i <= '9'; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;

                if (solve(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isValid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val) {
                return false;
            }

            if (board[i][col] == val) {
                return false;
            }

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == val) {
                return false;
            }
        }

        return true;
    }
}
