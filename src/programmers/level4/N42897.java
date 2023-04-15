package programmers.level4;

public class N42897 { // 도둑질
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};

        System.out.println(new Solution().solution(money));
    }

    static class Solution {
        public int solution(int[] money) {
            int[][] dp = new int[2][money.length];
            dp[0][0] = money[0];
            dp[0][1] = money[0];
            dp[1][0] = 0;
            dp[1][1] = money[1];

            for (int i = 2; i < money.length; i++) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
                dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
            }

            return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
        }
    }
}
