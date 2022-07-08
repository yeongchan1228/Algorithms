package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem16194 { // 카드 구매하기 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] prices = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = prices[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = prices[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(prices[j] + dp[i - j], dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
