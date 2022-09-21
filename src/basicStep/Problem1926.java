package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/21.
 */
public class Problem1926 {
    static int col = 0, row = 0, max = 0, totalCount = 0;
    static int[] dRow = {1, -1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException { // 그림

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[col][row];
        visited = new boolean[col][row];
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < row; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        out.write(totalCount + "\n" + max);
        out.flush();
        out.close();

    }

    private static void bfs() {
        Queue<Point> points = new LinkedList<>();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = 1;
                    visited[i][j] = true;
                    points.offer(new Point(i, j));

                    while (!points.isEmpty()) {
                        Point point = points.poll();

                        for (int k = 0; k < 4; k++) {
                            int pCol = point.col + dCol[k];
                            int pRow = point.row + dRow[k];
                            if (isValid(pCol, pRow)) {
                                count++;
                                visited[pCol][pRow] = true;
                                points.add(new Point(pCol, pRow));
                            }
                        }
                    }

                    totalCount++;
                    max = Math.max(max, count);
                }
            }
        }
    }

    private static boolean isValid(int dCol, int dRow) {
        return dRow > -1 && dRow < row && dCol > -1 && dCol < col && !visited[dCol][dRow] && map[dCol][dRow] == 1;
    }

    static class Point {
        int row;
        int col;

        public Point(int col, int row) {
            this.row = row;
            this.col = col;
        }
    }
}
