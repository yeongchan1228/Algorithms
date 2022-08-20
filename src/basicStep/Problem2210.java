package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem2210 { // 숫자판 점프

    static int[][] map;
    static final int LIMIT = 5;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[LIMIT][LIMIT];
        for (int i = 0; i < LIMIT; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < LIMIT; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < LIMIT; i++) {
            for (int j = 0; j < LIMIT; j++) {
                dfs(0, i, j, map[i][j]);
            }
        }

        out.write(String.valueOf(hashSet.size()));
        out.flush();
        out.close();
    }

    static void dfs(int depth, int x, int y, int sum) {
        if (depth == LIMIT) {
            hashSet.add(sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];

            if (isValid(px, py)) {
                dfs(depth + 1, px, py, sum * 10 + map[px][py]);
            }
        }
    }

    private static boolean isValid(int px, int py) {
        return px > -1 && px < LIMIT && py > -1 && py < LIMIT;
    }
}
