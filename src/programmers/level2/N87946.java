package programmers.level2;

import java.io.IOException;

public class N87946 { // 피로도
    public static void main(String[] args) throws IOException {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(new Solution().solution(k, dungeons));
    }

    static class Solution {
        static int answer = 0;
        public int solution(int k, int[][] dungeons) {
            calc(k, 0, new boolean[dungeons.length], dungeons);
            return answer;
        }

        private void calc(int k, int cnt, boolean[] visited, int[][] dungeons) {
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && k >= dungeons[i][0]) {
                    visited[i] = true;
                    calc(k - dungeons[i][1], cnt + 1, visited, dungeons);
                    visited[i] = false;
                }
            }

            answer = Math.max(answer, cnt);
        }
    }
}
