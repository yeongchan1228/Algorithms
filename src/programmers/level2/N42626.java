package programmers.level2;

import java.util.PriorityQueue;

public class N42626 { // 더 맵게
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(new Solution().solution(scoville, k));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int scovilleVal : scoville) {
                pq.offer(scovilleVal);
            }

            int answer = 0;
            while (pq.size() > 1) {
                int val1 = pq.poll();
                if (val1 >= K) {
                    break;
                }
                int val2 = pq.poll() * 2;
                pq.offer(val1 + val2);
                answer++;
            }

            return pq.poll() >= K ? answer : -1;
        }
    }
}
