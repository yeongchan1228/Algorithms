package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem17086 { // 아기 상어 2

    static int[] dx = {1, 1, 1, -1, -1, -1, 0 ,0}, dy = {0, 1, -1, 0, 1, -1, 1, -1};
    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;
    static Queue<Point> queue = new LinkedList();

    public static void main(String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < col; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {queue.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                }
                map[i][j] = num;

            }
        }

        bfs();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, map[i][j]);
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int nowX = poll.x;
            int nowY = poll.y;

            for (int i = 0; i < 8; i++) {
                int pX = nowX + dx[i];
                int pY = nowY + dy[i];

                if (isValid(visited, pX, pY)) {
                    map[pX][pY] = poll.move + 1;
                    queue.offer(new Point(pX, pY, poll.move + 1));
                    visited[pX][pY] = true;
                }
            }
        }
    }

    private static boolean isValid(boolean[][] visited, int pX, int pY) {
        return pX > -1 && pX < row && pY > -1 && pY < col && !visited[pX][pY];
    }

    static class Point {
        int x;
        int y;
        int move;

        public Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
