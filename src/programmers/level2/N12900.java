package programmers.level2;

public class N12900 { // 2 x n 타일링
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
            return dp[n];
        }
    }
}
