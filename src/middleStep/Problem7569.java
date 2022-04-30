package middleStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7569 { // 토마토

    static int M, N, H;
    static int[][][] map;
    static int[] dm = {1, -1, 0, 0, 0, 0};
    static int[] dn = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 칸
        N = Integer.parseInt(st.nextToken()); // 세로 칸
        H = Integer.parseInt(st.nextToken()); // 높이

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(in.readLine());
                for (int k = 0; k < M; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j][k] = value;
                    if(value == 1) queue.offer(new Point(i, j, k));
                }
            }
        }

        int result;
        if(queue.size() == H * N * M){
            result = 1;
        }else {
            bfs();
            result = checkMap();
        }

        out.write(String.valueOf(result - 1));
        out.flush();
        out.close();
    }

    private static int checkMap() {
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int value = map[i][j][k];
                    if(value == 0){
                        return 0;
                    }
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }

    static void bfs(){
        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            int nowM = nowPoint.m;
            int nowN = nowPoint.n;
            int nowH = nowPoint.h;
            int nowValue = map[nowH][nowN][nowM];

            for (int i = 0; i < 6; i++) {
                int nextM = nowM + dm[i];
                int nextN = nowN + dn[i];
                int nextH = nowH + dh[i];

                if(nextM > -1 && nextM < M && nextN > -1 && nextN < N && nextH > -1 && nextH < H
                        && map[nextH][nextN][nextM] == 0){
                    map[nextH][nextN][nextM] = nowValue + 1;
                    queue.offer(new Point(nextH, nextN, nextM));
                }
            }
        }


    }

    static class Point{
        int m;
        int n;
        int h;

        public Point(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}
