package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9095 { // 1, 2, 3 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        /**
         * 4 -> 1 + 3 -> 3은 4개
         *   -> 2 + 2 -> 2는 2개
         *   -> 3 + 1 -> 1은
         */
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            System.out.println(dp[num]);
        }
    }
}
