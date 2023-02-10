package programmers.level4;

import java.util.Arrays;

public class N43236 { // 징검다리
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        System.out.println(new Solution().solution(distance, rocks, n));
    }

    static class Solution {
        public int solution(int distance, int[] rocks, int n) {
            Arrays.sort(rocks);

            int left = 1;
            int right = distance;
            int answer = 0;
            while (left < right) {
                int prev = 0;
                int deleteRockCnt = 0;
                int mid = (left + right) / 2;

                for (int i = 0; i < rocks.length; i++) {
                    if (rocks[i] - prev < mid) {
                        deleteRockCnt++;
                        continue;
                    }

                    prev = rocks[i];
                }

                if (distance - prev < mid) {
                    deleteRockCnt++;
                }

                if (deleteRockCnt > n) {
                    right = mid;
                    continue;
                }

                answer = mid;
                left = mid + 1;
            }

            return answer;
        }
    }
}
