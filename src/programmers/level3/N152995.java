package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class N152995 { // 인사고과
    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        System.out.println(new Solution().solution(scores));
    }

    static class Solution {
        public int solution(int[][] scores) {
            int[] target = scores[0];

            Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

            int maxScore = 0;
            List<Integer> totalScores = new ArrayList<>();
            for (int i = 0; i < scores.length; i++) {
                if (scores[i][1] < maxScore) {
                    if (scores[i].equals(target)) {
                        return -1;
                    }
                    continue;
                }

                maxScore = Math.max(maxScore, scores[i][1]);
                totalScores.add(scores[i][0] + scores[i][1]);
            }

            Collections.sort(totalScores, Collections.reverseOrder());

            int targetScore = target[0] + target[1];
            for (int i = 0; i < totalScores.size(); i++) {
                if (totalScores.get(i) == targetScore) {
                    return i + 1;
                }
            }

            return -1;
        }
    }
}
