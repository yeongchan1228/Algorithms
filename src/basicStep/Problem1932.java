package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class Problem1932 { // 정수 삼각형

//    static int maxNum = 0;
//    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] triangle = new int[N][N + 1];
//        boolean[][] visited = new boolean[N][N];
//        result = new int[N];

        for (int i = 0; i < N; i++) {
            String[] str = in.readLine().split(" ");
            for (int j = 1; j <= str.length; j++) {
                triangle[i][j] = Integer.parseInt(str[j - 1]);
            }
        }
//        result[0] = triangle[0][0];
//        calc(1, triangle[0][0], 0, N, triangle, visited);

        int dp[][] = new int[N][N + 1];
        dp[0][1] = triangle[0][1];

        // 0 -> 1 -> 2 ...
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] , dp[i - 1][j]) + triangle[i][j];
            }
        }

        System.out.println(Arrays.stream(dp[N - 1]).max().getAsInt());

    }
//
//    static void calc(int depth, int sum, int check, int size ,int[][] triangle, boolean[][] visited){
//        if(depth == size){ // 끝까지 갔을 경우
//            int resultSum = Arrays.stream(result).sum();
//            maxNum = Math.max(maxNum, resultSum);
//            return;
//        }
//        /**
//         * depth - 0 - 2
//         *  1- 3
//         */
//        for (int i = check; i <= check + 1; i++) {
//
//            if(!visited[depth][i]){
//                visited[depth][i] = true;
//                sum += triangle[depth][i];
//                result[depth] = triangle[depth][i];
//
//                calc(depth + 1, sum, i, size, triangle, visited);
//
//                visited[depth][i] = false;
//
//            }
//        }
//
//    }
}
