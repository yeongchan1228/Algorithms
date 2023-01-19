package others;

import java.util.*;
import java.io.*;

public class No6 { // 사물인식 최소 면적 산출 프로그램
    private static int answer = Integer.MAX_VALUE;
    private static List<List<Point>> list = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= k; i++) {
            list.add(new ArrayList<Point>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            list.get(color).add(new Point(x, y));
        }

        dfs(1, k, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);

        out.write(String.valueOf(answer));
        out.flush();

        in.close();
        out.close();
    }

    private static void dfs(int depth, int cnt, int maxX, int minX, int maxY, int minY) {
        if (depth > cnt) {
            answer = Math.min(answer, (maxX - minX) * (maxY - minY));
            return;
        }

        for (Point point : list.get(depth)) {
            int x = point.x;
            int y = point.y;

            int tempMaxX = maxX;
            int tempMinX = minX;
            int tempMaxY = maxY;
            int tempMinY = minY;
            if (tempMaxX < x) {
                tempMaxX = x;
            }

            if (tempMinX > x) {
                tempMinX = x;
            }

            if (tempMaxY < y) {
                tempMaxY = y;
            }

            if (tempMinY > y) {
                tempMinY = y;
            }

            int area = (tempMaxX - tempMinX) * (tempMaxY - tempMinY);
            if (answer <= area) {
                continue;
            }

            dfs(depth + 1, cnt, tempMaxX, tempMinX, tempMaxY, tempMinY);
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
