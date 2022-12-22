package programmers.level2;

import java.util.*;

public class N138476 { // 귤 고르기
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(new Solution().solution(k, tangerine));
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int tangerineVal : tangerine) {
                hashMap.put(tangerineVal, hashMap.getOrDefault(tangerineVal, 0) + 1);
            }

            ArrayList<Integer> keys = new ArrayList<>(hashMap.keySet());
            Collections.sort(keys, (o1, o2) -> {
                return hashMap.get(o2) - hashMap.get(o1);
            });

            int answer = 0;
            for (int key : keys) {
                k -= hashMap.get(key);

                answer++;

                if (k < 1) {
                    break;
                }
            }
            return answer;
        }
    }
}
