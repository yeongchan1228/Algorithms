package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/10/07.
 */
public class Problem16948 { // 데스 나이트

    static int[] dx = {-2, 2, -1, 1, -1, 1}, dy = {0, 0, -2, -2, 2, 2};
    static boolean[][] checked;
    static int nowX, nowY, x, y, n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        checked = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        nowY = Integer.parseInt(st.nextToken());
        nowX = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println("-1");
    }
    static void bfs() {
        Queue<Point> queue = new LinkedList();
        queue.offer(new Point(nowY, nowX, 0));
        checked[nowY][nowX] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 6; i++)  {
                int pY = poll.y - dy[i];
                int pX = poll.x - dx[i];

                if (pY == y && pX == x) {
                    System.out.println(poll.count + 1);
                    System.exit(0);
                }

                if (isVaild(pY, pX)) {
                    queue.offer(new Point(pY, pX, poll.count + 1));
                    checked[pY][pX] = true;
                }
            }
        }
    }

    private static boolean isVaild(int pY, int pX) {
        return pY > -1 && pY < n && pX > -1 && pX < n && !checked[pY][pX];
    }

    static class Point {
        int y;
        int x;
        int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
