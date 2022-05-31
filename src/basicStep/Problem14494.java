package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14494 { // 다이나믹이 뭐예요?
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] dp = new long[M][N];
        dp[0][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(i == 0 && j != 0) dp[i][j] = 1;
                else if(j == 0 && i != 0) dp[i][j] = 1;
                else if(i != 0 && j != 0) dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % 1000000007;
            }
        }

        out.write(String.valueOf(dp[M - 1][N - 1]));
        out.flush();
        out.close();
    }
}
