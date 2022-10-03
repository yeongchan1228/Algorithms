package middleStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/10/03.
 */
public class Problem11049 { // 행렬 곱셈 순서
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[][] dp = new int[n][n];
        int[][] matrices = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            matrices[i][0] = Integer.parseInt(st.nextToken());
            matrices[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    dp[j][j + i] = Math.min(
                            dp[j][j + i],
                            dp[j][j + k] + dp[j + k + 1][j + i] + matrices[j][0] * matrices[j + k][1] * matrices[j + i][1]
                    );
                }
            }
        }

        out.write(String.valueOf(dp[0][n - 1]));
        out.flush();
        out.close();
    }
}
