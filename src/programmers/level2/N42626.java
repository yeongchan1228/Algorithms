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
            PriorityQueue<Integer> pq = getPriorityQueue(scoville);

            int cnt = 0;
            while (true) {
                if (pq.peek() >= K) {
                    return cnt;
                }

                if (pq.size() == 1) {
                    if (pq.peek() >= K) {
                        return cnt;
                    }
                    break;
                }

                cnt++;
                pq.offer(pq.poll() + (pq.poll() * 2));
            }

            return -1;
        }

        private PriorityQueue<Integer> getPriorityQueue(int[] scoville) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int val : scoville) {
                pq.add(val);
            }
            return pq;
        }
    }
}
