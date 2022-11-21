package programmers.kakao;

import java.util.Arrays;

public class Internship2022_3 {
    public static void main(String[] args) {
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10,15,2,1,2}, {20,20,3,3,4}};

        Solution solution = new Solution();
        System.out.println(solution.solution(alp, cop, problems));
    }

    static class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            int maxAlpReq = alp;
            int maxCopReq = cop;
            for (int i = 0; i < problems.length; i++) {
                maxAlpReq = Math.max(maxAlpReq, problems[i][0]);
                maxCopReq = Math.max(maxCopReq, problems[i][1]);
            }

            if (maxAlpReq <= alp && maxCopReq <= cop) {
                return 0;
            }

            int dp[][] = new int[maxAlpReq + 1][maxCopReq + 1];
            for (int i = 0; i < maxAlpReq + 1; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            dp[alp][cop] = 0;
            for (int i = alp; i <= maxAlpReq; i++) {
                for (int j = cop; j <= maxCopReq; j++) {
                    if (i < maxAlpReq) {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                    }
                    if (j < maxCopReq) {
                        dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                    }

                    for (int[] problem : problems) {
                        int alpReq = problem[0];
                        int copReq = problem[1];
                        int alpRwd = problem[2];
                        int copRwd = problem[3];
                        int cost = problem[4];

                        if (i >= alpReq && j >= copReq) {
                            int tmpAlp = Math.min(i + alpRwd, maxAlpReq);
                            int tmpCop = Math.min(j + copRwd, maxCopReq);
                            dp[tmpAlp][tmpCop] = Math.min(dp[tmpAlp][tmpCop], dp[i][j] + cost);
                        }
                    }
                }
            }

            return dp[maxAlpReq][maxCopReq];
        }
    }
}
