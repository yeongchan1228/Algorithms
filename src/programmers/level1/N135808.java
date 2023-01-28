package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class N135808 { // 과일 장수
    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(new Solution().solution(k, m, score));
    }

    static class Solution {
        public int solution(int k, int m, int[] score) {
            int[] sortedScore = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

            int answer = 0;
            int idx = m - 1;
            int len = score.length;
            while (idx < len) {
                answer += sortedScore[idx] * m;
                idx += m;
            }
            return answer;
        }
    }
}
