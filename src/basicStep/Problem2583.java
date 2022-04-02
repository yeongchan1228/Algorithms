package basicStep;

import java.io.*;
import java.util.*;

public class Problem2583 { // 영역 구하기

    static int[][] map;
    static Queue<Point> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited= new boolean[M][N];
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ry1 = M - y1;
            int ry2 = M - y2;
            for (int j = ry2; j < ry2 + (ry1 - ry2); j++) {
                for (int k = x1; k < x1 + (x2 - x1); k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 1){
                    queue.offer(new Point(j, i));
                    visited[i][j] = true;
                    result.add(bfs(N, M));
                    count++;
                }
            }
        }

        result.sort(Comparator.naturalOrder());

        sb.append(count).append('\n');
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static int bfs(int N, int M){
        int count = 0;

        while (!queue.isEmpty()){
            Point point = queue.poll();
            count++;
            int nowX = point.x;
            int nowY = point.y;

            for (int i = 0; i < 4; i++) {
                int pX = nowX + dx[i];
                int pY = nowY + dy[i];

                if(pX > -1 && pX < N && pY > -1 && pY < M && !visited[pY][pX] && map[pY][pX] != 1){
                    queue.offer(new Point(pX, pY));
                    visited[pY][pX] = true;
                }
            }

        }
        return count;
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
