package programmers.level2;

import java.util.*;

public class N131130 { // 혼자 놀기의 달인

    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(new Solution().solution(cards));
    }

    static class Solution {
        private static Map<Integer, Integer> map = new HashMap<>();
        public int solution(int[] cards) {
            int idx = 1;
            for (int card : cards) {
                map.put(card, idx++);
            }

            List<Integer> list = new ArrayList<>();
            boolean[] visited = new boolean[cards.length + 1];
            for (int i = 0; i < cards.length; i++) {
                if (!visited[cards[i]]) {
                    list.add(calc(cards[i], 1, cards, visited));
                }
            }

            if (list.size() < 2) {
                return 0;
            }

            Collections.sort(list, Collections.reverseOrder());

            return list.get(0) * list.get(1);
        }

        private int calc(int card, int cnt, int[] cards, boolean[] visited) {
            visited[card] = true;
            int nextCard = map.get(card);

            if (visited[nextCard]) {
                return cnt;
            }

            return calc(nextCard, cnt + 1, cards, visited);
        }
    }

}