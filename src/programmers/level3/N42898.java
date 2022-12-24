package programmers.level3;

public class N42898 { // 등굣길
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(new Solution().solution(m, n, puddles));
    }

    static class Solution {
        private static int DIVISION_VALUE = 1000000007;
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n][m];

            for (int[] puddle : puddles) {
                dp[puddle[1] - 1][puddle[0] - 1] = -1;
            }

            for (int i = 0; i < m; i++) {
                if (dp[0][i] == -1) {
                    break;
                }
                dp[0][i] = 1;
            }

            for (int i = 0; i < n; i++) {
                if (dp[i][0] == -1) {
                    break;
                }
                dp[i][0] = 1;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (dp[i][j] == -1) {
                        continue;
                    }

                    int leftVal = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];
                    int topVal = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
                    dp[i][j] = (leftVal + topVal) % DIVISION_VALUE;
                }
            }

            return dp[n - 1][m - 1];
        }
    }
}
