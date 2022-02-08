package basicStep;

import java.util.Scanner;

public class Problem15989 { // 1, 2, 3 더하기 4
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] num = new int[count];

        for(int i = 0; i < count; i++){
            num[i] = in.nextInt();
        }

        int max = -1;
        for(int i = 0; i<count; i++){
            if(max < num[i]){
                max = num[i];
            }
        }

        int[][] dp = new int[max + 1][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i <= max; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int i = 0; i < count; i++){
            if(i == (count - 1))
                System.out.print(dp[num[i]][1] + dp[num[i]][2] + dp[num[i]][3]);
            else
                System.out.println(dp[num[i]][1] + dp[num[i]][2] + dp[num[i]][3]);
        }
    }
}
