package leetCode;

public class P79 { // Word Search
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int rowSize = 0;
    static int colSize = 0;
    static boolean isTrue;

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        isTrue = false;
        rowSize = board.length;
        colSize = board[0].length;
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == wordChars[0]) {
                    boolean[][] visited = new boolean[rowSize][colSize];

                    visited[i][j] = true;
                    dfs(1, i, j, board, wordChars, visited);
                    visited[i][j] = false;

                    if (isTrue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void dfs(int depth, int x, int y, char[][] board, char[] wordChars, boolean[][] visited) {
        if (isTrue) {
            return;
        }

        if (depth == wordChars.length) {
            isTrue = true;
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int px = x + dx[i];
            int py = y + dy[i];

            if (isValid(px, py, wordChars[depth], visited, board)) {
                visited[px][py] = true;
                dfs(depth + 1, px, py, board, wordChars, visited);
                visited[px][py] = false;
            }
        }
    }

    private static boolean isValid(int px, int py, char nextChar, boolean[][] visited, char[][] board) {
        return px > -1 && px < rowSize && py > -1 && py < colSize && !visited[px][py] && board[px][py] == nextChar;
    }
}
