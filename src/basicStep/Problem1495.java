package basicStep;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1495 { //기타리스트
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int S = in.nextInt();
        int M = in.nextInt();

        int[] list = new int[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = in.nextInt();
        }

        int[] dp = new int[M+1];
        for(int i = 0; i < M+1; i++){
            dp[i] = -1;
        }
        dp[S] = 0;

        int num1, num2 = 0;

        list[0] = S;

        int[] mid = new int[M+1];
        int cnt = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= M; j++){
                if(dp[j] == i - 1){
                    mid[cnt] = j;
                    cnt++;
                }
            }

            for(int k = 0; k < cnt; k++) {
                num1 = mid[k] - list[i];
                num2 = mid[k] + list[i];
                if (num1 > -1 && num1 < M + 1) {
                    dp[num1] = i;
                }
                if (num2 > -1 && num2 < M + 1) {
                    dp[num2] = i;
                }
            }
            mid = new int[M+1];
            cnt = 0;
        }

        int result = -1;
        int k = 0;
        for(int i = 0; i < M+1; i++){
            if(N == dp[i]){
                result = Math.max(-1, i);
            }
        }

        System.out.print(result);

    }
}
