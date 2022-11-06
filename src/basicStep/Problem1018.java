package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1018 { // 체스판 다시 칠하기

    static int n;
    static int m;
    static char[][] map;
    static final int MAP_MAX_SIZE = 8;
    static final int MAX_VALUE = 64;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j];
            }
        }

        for (int i = 0; i <= n - MAP_MAX_SIZE; i++) {
            for (int j = 0; j <= m - MAP_MAX_SIZE; j++) {
                result = Math.min(result, calc(i, j));
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static int calc(int i, int j) {
        int cnt = 0;
        String check[] = {"WBWBWBWB", "BWBWBWBW"};

        for (int k = 0; k < MAP_MAX_SIZE; k++) {
            int row = i + k;
            for (int l = 0; l < MAP_MAX_SIZE; l++) {
                int col = j + l;

                if (map[row][col] != check[row % 2].charAt(l)) {
                    cnt++;
                }
            }
        }

        return Math.min(cnt, MAX_VALUE - cnt);
    }
}
