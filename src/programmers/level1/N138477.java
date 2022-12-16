package programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class N138477 { // 명예의 전당 (1)
    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(new Solution().solution(k, score)));
    }

    static class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.offer(score[0]);

            for (int i = 1; i < score.length; i++) {
                if (i <= k - 1) {
                    answer[i - 1] = pq.peek();
                    pq.offer(score[i]);
                    continue;
                }

                if (pq.peek() > score[i]) {
                    answer[i - 1] = pq.peek();
                    continue;
                }

                pq.offer(score[i]);
                answer[i - 1] = pq.poll();
            }

            answer[score.length - 1] = pq.poll();
            return answer;
        }
    }
}
