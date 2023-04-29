package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14925 { // 목장 건설하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i - 1][j - 1] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][ j - 1])) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }
}
