package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9461 { // 파도반 수열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(in.readLine());
        int[] N = new int[num];

        int max = 0;
        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(in.readLine());
            if(max < value){
                max = value;
            }
            N[i] = value;
        }

        long[] dp = new long[max + 1];
        dp[1] = 1;
        if(max > 1)  dp[2] = 1l;
        if(max > 2)  dp[3] = 1l;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < N.length; i++) {
            System.out.println(dp[N[i]]);
        }
    }
}
