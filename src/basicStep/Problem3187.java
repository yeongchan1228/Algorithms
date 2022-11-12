package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3187 { // 양치기 꿍

    static int row, col;
    static int wolfCnt, sheepCnt;
    static int survivedWolf, survivedSheep;
    static char[][] map;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1 ,-1};
    private static final char WOLF = 'v';
    private static final char SHEEP = 'k';
    private static final char FENCE = '#';

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = in.readLine().toCharArray();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == WOLF || map[i][j] == SHEEP) {
                    bfs(i, j);
                }
            }
        }

        out.write(survivedSheep + " " + survivedWolf);
        out.flush();
        out.close();
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList();
        queue.offer(new Point(x, y));

        wolfCnt = 0;
        sheepCnt = 0;
        calcCnt(x, y);

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int px = now.x + dx[i];
                int py = now.y + dy[i];

                if (isValid(px, py)) {
                    queue.offer(new Point(px, py));
                    calcCnt(px, py);
                }
            }
        }

        if (wolfCnt >= sheepCnt) {
            survivedWolf += wolfCnt;
            return;
        }

        survivedSheep += sheepCnt;
    }

    private static void calcCnt(int x, int y) {
        if (map[x][y] == WOLF) {
            wolfCnt++;
        } else if (map[x][y] == SHEEP) {
            sheepCnt++;
        }
        map[x][y] = FENCE;
    }

    private static boolean isValid(int px, int py) {
        return px > -1 && px < row && py > -1 && py < col && map[px][py] != FENCE;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
