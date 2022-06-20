package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11051 { // 이항 계수 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j > K) break;

                if(i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
                }
            }
        }

        out.write(String.valueOf(dp[N][K]));
        out.flush();
        out.close();
    }
}
