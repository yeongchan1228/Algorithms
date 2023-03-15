package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1711 { // 직각삼각형
    private static int n;
    private static int answer = 0;
    private static Point[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        dfs(0, 0, new Point[3]);

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    private static void dfs(int depth, int start, Point[] selected) {
        if (depth == 3) {
            long line1 = calc(selected[0], selected[1]);
            long line2 = calc(selected[0], selected[2]);
            long line3 = calc(selected[1], selected[2]);

            if (line3 == line1 + line2) {
                answer++;
                return;
            }

            if (line2 == line1 + line3) {
                answer++;
                return;
            }

            if (line1 == line2 + line3) {
                answer++;
                return;
            }

            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = points[i];
            dfs(depth + 1, i + 1, selected);
        }
    }

    private static long calc(Point x1, Point x2) {
        return pow(x2.x - x1.x) + pow(x2.y - x1.y);
    }

    private static long pow(long len) {
        return len * len;
    }

    private static class Point {
        long x;
        long y;

        public Point(final long x, final long y) {
            this.x = x;
            this.y = y;
        }
    }
}
