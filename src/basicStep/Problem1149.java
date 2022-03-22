package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1149 { // RGB거리
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] RGB = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            String[] str = in.readLine().split(" ");
            RGB[i][0] = Integer.parseInt(str[0]); // red
            RGB[i][1] = Integer.parseInt(str[1]); //green
            RGB[i][2] = Integer.parseInt(str[2]); // blue

        }

        int dp[][] = new int[N + 1][3];
        dp[1][0] = RGB[1][0];
        dp[1][1] = RGB[1][1];
        dp[1][2] = RGB[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2];
        }

        System.out.println(Arrays.stream(dp[N]).min().getAsInt());
    }
}
