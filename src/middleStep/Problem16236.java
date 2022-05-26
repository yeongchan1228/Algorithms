package middleStep;

import java.io.*;
import java.util.*;

public class Problem16236 { // 아기 상어

    static int N, saveX, saveY, count, size, result;
    static int[][] map;
    static Queue<Point> pq = new PriorityQueue<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = 2;
        count = 0;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    saveX = i;
                    saveY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true){
            bfs();
        }

    }

    static void bfs() throws IOException {
        boolean[][] check = new boolean[N][N];
//        queue.offer(new Point(saveX, saveY, 0));
        pq.offer(new Point(saveX, saveY, 0));
        check[saveX][saveY] = true;
        boolean noEat = true;

        while (!pq.isEmpty()){
            Point poll = pq.poll();
            int x = poll.x;
            int y = poll.y;
            int d = poll.d;

            if(map[x][y] < size && map[x][y] != 0){
                saveX = x;
                saveY = y;
                map[saveX][saveY] = 0;

                count++;
                result += d;

                noEat = false;

                break;
            }

            for (int i = 0; i < 4; i++) {
                int pX = x + dx[i];
                int pY = y + dy[i];

                if(pX > -1 && pX < N && pY > -1 && pY < N && !check[pX][pY] && map[pX][pY] <= size){
                    pq.offer(new Point(pX, pY, d + 1));
                    check[pX][pY] = true;
                }
            }
        }

        if(noEat){
            out.write(String.valueOf(result));
            out.flush();
            out.close();
            System.exit(0);
        }

        if(count == size){
            size++;
            count = 0;
        }

        pq.clear();
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            if(this.d == o.d){
                if(this.x == o.x){
                    return this.y - o.y;
                }else return this.x - o.x;
            }
            return this.d - o.d;
        }
    }
}
