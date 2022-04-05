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

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 2) arr.add(new Point(j, i));
                map[i][j] = num;
            }
        }

        dfs(0, 0);

        out.write(String.valueOf(max));
        out.flush();
        out.close();
    }

    static void dfs(int depth, int start){
        if(depth == 3){
            bfs();
            return;
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if(map[i][j] == 0 && !visited[i][j]){
//                    map[i][j] = 1;
//                    visited[i][j] = true;
//                    dfs(depth + 1);
//                    map[i][j] = 0;
//                    visited[i][j] = false;
//                }
//            }
//        }

        for (int i = start; i < N * M; i++) {
            int dN = i / M;
            int dM = i % M;

            if(map[dN][dM] == 0){
                map[dN][dM] = 1;
                dfs(depth + 1, i + 1);
                map[dN][dM] = 0;
            }
        }
    }

    static void bfs(){

        setCopy();

        int size = arr.size();
        for (int t = 0; t < size; t++) {
            queue.offer(arr.get(t));
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int nowX = point.x;
                int nowY = point.y;

                for (int i = 0; i < 4; i++) {
                    int pX = nowX + dx[i];
                    int pY = nowY + dy[i];

                    if (pX > -1 && pX < M && pY > -1 && pY < N && copy[pY][pX] == 0) {
                        copy[pY][pX] = 2;
                        queue.offer(new Point(pX, pY));
                    }
                }
            }
        }

        max = Math.max(max, getResult());
    }

    static void setCopy(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    static int getResult(){
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] == 0)
                    result++;
            }
        }
        return result;
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
