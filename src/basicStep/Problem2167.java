package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2167 { // 2차원 배열의 합
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        while (k --> 0) {
            st = new StringTokenizer(in.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int l = i - 1; l < x; l++) {
                for (int o = j - 1; o < y; o++) {
                    sum += map[l][o];
                }
            }
            result.append(sum + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
