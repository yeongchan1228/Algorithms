package programmers.level3;

import java.util.*;

public class N42627 { // 디스크 컨트롤러
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(new Solution().solution(jobs));
    }

    static class Solution {
        public int solution(int[][] jobs) {

            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            int idx = 0;
            int end = 0;
            int count = 0;
            int answer = 0;
            while (count < jobs.length) {
                while (idx < jobs.length && end >= jobs[idx][0]) {
                    pq.offer(jobs[idx++]);
                }

                if (pq.isEmpty()) {
                    end = jobs[idx][0];
                    continue;
                }

                int[] job = pq.poll();
                answer += job[1] + end - job[0];
                end += job[1];
                count++;
            }

            return answer / jobs.length;
        }
    }
}
