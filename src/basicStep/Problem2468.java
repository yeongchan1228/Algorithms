package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2468 { // 안전 영역

    static Queue<Point> queue = new LinkedList<>();
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        int max = -1;
        for (int i = 1; i <= N; i++) {
            String[] str = in.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(str[j - 1]);
                if(num > max){
                    max = num;
                }
                map[i][j] = num;
            }
        }

        int result = -1;
        int temp;
        for (int i = 0; i <= max; i++) {
            temp = 0;

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    visited[j][k] = false;
                }
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(!visited[j][k]) {
                        int value = map[j][k];
                        if (value <= i) {
                            visited[j][k] = true;
                        }else{
                            queue.offer(new Point(j, k));
                        }
                    }
                }
            }
            temp += bfs();
            result = Math.max(result, temp);
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static int bfs(){
        int temp = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nowX = point.x;
            int nowY = point.y;

            if(!visited[nowX][nowY]) {
                dfs(nowX, nowY);
                temp++;
            }
        }

        return temp;
    }

    static void dfs(int x, int y){
        int pX, pY = 0;
        if(!visited[x][y]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                pX = x + dx[i];
                pY = y + dy[i];

                if (pX > 0 && pX <= N && pY > 0 && pY <= N && !visited[pX][pY]) {
                    dfs(pX, pY);
                }
            }
        }
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
