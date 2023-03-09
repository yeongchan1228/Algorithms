package middleStep;

import java.io.*;
import java.util.*;

public class Problem14502 { // 연구소

    static int N, M;
    static int[][] map, copy;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Point> arr = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    arr.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);

        out.write(String.valueOf(max));
        out.flush();
        out.close();
    }

    private static void dfs(int depth, int start) {
        if (depth == 3) {
            bfs();
            max = Math.max(max, calcArea());
            return;
        }

        for (int i = start; i < N * M; i++) {
            int nowN = i / M;
            int nowM = i % M;
            if (map[nowN][nowM] == 0) {
                map[nowN][nowM] = 1;
                dfs(depth + 1, i);
                map[nowN][nowM] = 0;
            }
        }
    }

    private static void copy() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    private static void bfs() {
        copy();
        addQueue();

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int px = point.x + dx[i];
                int py = point.y + dy[i];
                if (px > -1 && px < N && py > -1 && py < M && copy[px][py] == 0) {
                    queue.offer(new Point(px, py));
                    copy[px][py] = 2;
                }
            }
        }
    }

    private static void addQueue() {
        for (Point point : arr) {
            queue.offer(point);
        }
    }

    private static int calcArea() {
        int cnt = 0;
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
