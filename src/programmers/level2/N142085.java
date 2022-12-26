package programmers.level2;

import java.util.PriorityQueue;

public class N142085 { // 디펜스 게임
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        System.out.println(new Solution().solution(n, k , enemy));
    }

    static class Solution {
        public int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int i = 0; i < enemy.length; i++) {
                int minusVal = enemy[i];
                n -= minusVal;
                pq.add(minusVal);

                if (n < 0) {
                    if (k > 0 && !pq.isEmpty()) {
                        k--;
                        n += pq.poll();
                        continue;
                    }
                    return i;
                }
            }

            return enemy.length;
        }
    }
}
