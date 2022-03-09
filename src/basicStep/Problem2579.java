package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2579 { // 계단 오르기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] map = new int[N+1];
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(in.readLine());
        }

        dp[0] = 0;
        dp[1] = map[1];

        if(N >= 2){
            dp[2] = map[1] + map[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + map[i - 1]) + map[i];
        }
        System.out.println(dp[N]);
    }
}
