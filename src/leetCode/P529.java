package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P529 { // Minesweeper
    static int rowSize, colSize;
    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {0, -1, 1, 0, -1, 1, 1, -1};
    public static void main(String[] args) {
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3, 0};

        for (char[] chars : updateBoard(board, click)) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        rowSize = board.length;
        colSize = board[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];

        bfs(click, board, visited);
        return board;
    }

    private static void bfs(int[] click, char[][] board, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();

        int defaultX = click[0];
        int defaultY = click[1];
        if (board[defaultX][defaultY] == 'M') {
            board[defaultX][defaultY] = 'X';
            return;
        }

        queue.offer(new Point(defaultX, defaultY));
        visited[defaultX][defaultY] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int count = getMineCount(point, board);
            if (count > 0) {
                board[point.x][point.y] = (char) (count + '0');
            } else {
                board[point.x][point.y] = 'B';
            }

            for (int i = 0; i < dx.length; i++) {
                int px = point.x + dx[i];
                int py = point.y + dy[i];

                if (isValid(px, py)) {
                    if (board[point.x][point.y] == 'B' && !visited[px][py] && board[px][py] == 'E') {
                        visited[px][py] = true;
                        queue.offer(new Point(px, py));
                    }
                }
            }
        }

    }

    private static boolean isValid(int px, int py) {
        return px > -1 && px < rowSize && py > -1 && py < colSize;
    }

    private static boolean isMine(int px, int py, char[][] board) {
        return board[px][py] == 'M';
    }

    private static int getMineCount(Point point, char[][] board) {
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int px = point.x + dx[i];
            int py = point.y + dy[i];

            if (isValid(px, py)) {
                if (isMine(px, py, board)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
