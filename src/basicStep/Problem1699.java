package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1699 { // 제곱 수의 합
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(in.readLine());
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++){
            dp[i] = i;
            for (int j = 1; j*j <= i; j++){
                int calc = dp[i - j * j] + 1;
                dp[i] = Math.min(dp[i], calc);
            }
        }

        System.out.println(dp[num]);

    }
}
