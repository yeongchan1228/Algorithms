package basicStep;

import java.util.Scanner;

public class Problem1890 { // 점프

    static int N;
    static int[][] map;
    static long[][] dp;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        map = new int[N][N];
        dp = new long[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = in.nextInt();
            }
        }

        dp[0][0] = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == N-1 && j == N-1) { // map[N-1][N-1]은 도착점

                }
                else {
                    if (j + map[i][j] < N) { // 오른쪽 이동 가능
                        dp[i][j + map[i][j]] = dp[i][j + map[i][j]] + dp[i][j];
                    }
                    if (i + map[i][j] < N) { // 아래 이동 가능
                        dp[i + map[i][j]][j] = dp[i + map[i][j]][j] + dp[i][j];
                    }
                }
            }
        }

        System.out.print(dp[N-1][N-1]);
    }
}
