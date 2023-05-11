package leetCode;

public class P36 { // Valid Sudoku
    static final int SIZE = 9;
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board, int i, int j) {
        return checkRow(board, i, j) && checkCol(board, i, j) && checkBox(board, i, j);
    }

    private static boolean checkRow(char[][] board, int i, int j) {
        for (int rowIdx = 0; rowIdx < SIZE; rowIdx++) {
            if (rowIdx == j) {
                continue;
            }

            if (board[i][j] == board[i][rowIdx]) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkCol(char[][] board, int i, int j) {
        for (int colIdx = 0; colIdx < SIZE; colIdx++) {
            if (colIdx == i) {
                continue;
            }

            if (board[i][j] == board[colIdx][j]) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkBox(char[][] board, int i, int j) {
        int boxI = i - (i % 3);
        int boxJ = j - (j % 3);
        for (int iIdx = boxI; iIdx < boxI + 3; iIdx++) {
            for (int jIdx = boxJ; jIdx < boxJ + 3; jIdx++) {
                if (i == iIdx && j == jIdx) {
                    continue;
                }

                if (board[i][j] == board[iIdx][jIdx]) {
                    return false;
                }
            }
        }

        return true;
    }
}
