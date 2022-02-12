package basicStep;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11058 { // 크리보드
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        dp[6] = 6;


        for(int i = 7; i <= N; i++){
            dp[i] = dp[i - 1] + 1;
            for(int j = 0; j < i - 3; j++){
                dp[i] = Math.max(dp[i], dp[i - (j + 3)] * (j + 2));
            }
        }
        
        System.out.print(dp[N]);
    }
}
