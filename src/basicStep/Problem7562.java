package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7562 { // 나이트의 이동

    static int[] pX = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] pY = {1, -1, -1, 1, 2, -2, -2, 2};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int line, nX, nY, fX, fY;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            line = Integer.parseInt(in.readLine());

            map = new int[line][line];
            visited = new boolean[line][line];

            st = new StringTokenizer(in.readLine());
            nX = Integer.parseInt(st.nextToken());
            nY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            fX = Integer.parseInt(st.nextToken());
            fY = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(map[fX][fY]);
        }
    }


    static void bfs(){
        queue = new LinkedList<>();
        queue.offer(new Point(nX, nY));
        visited[nX][nY] = true;

        while(!queue.isEmpty()){
            Point temp = queue.poll();
            int x = temp.x;
            int y = temp.y;

            if(x == fX && y == fY)
                break;

            for (int i = 0; i < pX.length; i++) {
                int nx = x + pX[i];
                int ny = y + pY[i];

                if(nx >= 0 && nx < line && ny >= 0 && ny < line && !visited[nx][ny]){
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = map[x][y] + 1;
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
