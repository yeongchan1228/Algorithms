package middleStep;

import java.util.Scanner;

public class Problem12865 { // 배낭 문제
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 물건 개수
        int K = in.nextInt(); // 총 무게

        int[][] goods = new int[N][2]; // 0 -> 무게, 1 -> 가치

        for(int i = 0; i < N; i++){
            goods[i][0] = in.nextInt();
            goods[i][1] = in.nextInt();
        }

        int[] dp = new int[K+1];
        dp[0] = 0;

        for(int i = 0; i < N; i++){
            for(int j = K; j > 0; j--){
                if(j >= goods[i][0]){
                    dp[j] = Math.max(dp[j], goods[i][1] + dp[j - goods[i][0]]);
                }
            }
        }
        System.out.print(dp[K]);
    }
}
