package programmers.level2;

import java.util.Arrays;

public class N181188 { // 요격 시스템
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(new Solution().solution(targets));
    }

    static class Solution {
        public int solution(int[][] targets) {
            if (targets.length < 2) return 1;

            Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

            int left = 0;
            int right = 1;
            int answer = 1;
            while (right < targets.length) {
                if (targets[left][1] > targets[right][0]) {
                    right++;
                    continue;
                }

                answer++;
                left = right;
                right++;
            }

            return answer;
        }
    }
}
