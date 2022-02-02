package basicStep;

import java.util.Scanner;

public class Problem15486 {

    static int N, max;
    static int[][] work;
    static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        work = new int[N+2][2];
        dp = new int[N+2];
        dp[0] = 0;
        max = -1;

        work[0][0] = 0;
        work[0][1] = 0;
        work[N+1][0] = 0;
        work[N+1][1] = 0;
        for(int i = 1; i <= N; i++){
            work[i][0] = in.nextInt();
            work[i][1] = in.nextInt();
        }

        for(int i = 1; i <= N+1; i++){
            if(max < dp[i]){
                max = dp[i];
            }

            if(i + work[i][0] <= N+1){
                dp[i + work[i][0]] = Math.max(dp[i + work[i][0]], work[i][1] + max);
            }
        }

        System.out.print(dp[N+1]);
    }
}
