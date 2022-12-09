package programmers.level2;

import java.util.ArrayList;

public class N92342 { // 양궁대회

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        Solution solution = new Solution();
        for (int answer : solution.solution(n, info)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static int[] ryanScore;
        static int maxDiffScore = -1;
        static final int MAX_SCORE = 10;
        static ArrayList<int[]> ryanScores = new ArrayList<int[]>();

        public int[] solution(int n, int[] info) {
            ryanScore = new int[info.length];

            dfs(0, 0, n, info);

            if (maxDiffScore == -1) {
                return new int[]{ -1 };
            }

            ryanScores.sort((o1, o2) -> {
                for (int i = 10; i >= 0; i--) {
                    if (o1[i] != o2[i]) {
                        return o2[i] - o1[i];
                    }
                }
                return 0;
            });

            return ryanScores.get(0);
        }

        private void dfs(int depth, int start, int n, int[] info) {
            if (depth == n) {
                int ryanTotalScore = 0;
                int apeachTotalScore = 0;

                for (int i=0; i<=MAX_SCORE; i++) {
                    if (ryanScore[i] == 0 && info[i] == 0) {
                        continue;
                    }
                    if (info[i] >= ryanScore[i]) {
                        apeachTotalScore += (MAX_SCORE - i);
                    } else {
                        ryanTotalScore += (MAX_SCORE - i);
                    }
                }

                if (ryanTotalScore > apeachTotalScore) {
                    int diffScore = ryanTotalScore - apeachTotalScore;
                    if (diffScore > maxDiffScore) {
                        maxDiffScore = diffScore;
                        ryanScores.clear();
                        ryanScores.add(ryanScore.clone());
                    }
                    if (diffScore == maxDiffScore) {
                        ryanScores.add(ryanScore.clone());
                    }

                }
                return;
            }

            for (int i=start; i<=MAX_SCORE; i++) {
                ryanScore[i]++;
                dfs(depth + 1, i, n, info);
                ryanScore[i]--;
            }
        }
    }
}
