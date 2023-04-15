package programmers.level3;

import java.util.Arrays;

public class N42884 { // 단속카메라
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(new Solution().solution(routes));
    }

    static class Solution {
        public int solution(int[][] routes) {
            if (routes.length < 2) {
                return 1;
            }

            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

            int left = 0;
            int right = 1;
            int answer = 1;
            while (right < routes.length) {
                if (routes[left][1] >= routes[right][0]) {
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
