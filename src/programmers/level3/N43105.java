package programmers.level3;

import java.util.Arrays;

public class N43105 { // 정수 삼각형
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(new Solution().solution(triangle));
    }

    static class Solution {
        public int solution(int[][] triangle) {
            int size = triangle.length;
            int[][] dp = new int[size][size + 1];
            dp[0][1] = triangle[0][0];
            for (int i = 1; i < size; i++) {
                for (int j = 1; j <= i + 1; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j - 1];
                }
            }

            return Arrays.stream(dp[size - 1]).max().getAsInt();
        }
    }
}

