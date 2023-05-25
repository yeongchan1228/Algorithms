package middleStep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2169 { // 로봇 조종하기

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;

        int[][] map = new int[n][m];
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        int[][] temp = new int[2][m + 1];
        dp[1][1] = map[1][1];
        for (int i = 2; i < m; i++) {
            dp[1][i] = map[1][i] + dp[1][i - 1];
        }

        for (int i = 2; i < n; i++) {
            // 왼쪽, 위
            temp[0][0] = dp[i - 1][1];
            for (int j = 1; j < m; j++) {
                temp[0][j] = Math.max(dp[i - 1][j], temp[0][j - 1]) + map[i][j];
            }

            // 오른쪽, 위
            temp[1][m] = dp[i - 1][m - 1] ;
            for (int j = m - 1; j >= 1; j--) {
                temp[1][j] = Math.max(dp[i - 1][j], temp[1][j + 1]) + map[i][j];
            }

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        out.write(String.valueOf(dp[n - 1][m - 1]));
        out.flush();
        out.close();
    }
}
