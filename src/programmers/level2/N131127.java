package programmers.level2;

import java.io.IOException;
import java.util.HashMap;

public class N131127 { // 할인 행사

    public static void main(String[] args) throws IOException {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(new Solution().solution(want, number, discount));
    }

    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            HashMap<String, Integer> hashMap = new HashMap<>();

            int totalCnt = 0;
            for (int i = 0; i < want.length; i++) {
                totalCnt += number[i];
                hashMap.put(want[i], number[i]);
            }

            for (int i = 0; i < totalCnt; i++) {
                if (hashMap.containsKey(discount[i])) {
                    hashMap.put(discount[i], hashMap.get(discount[i]) - 1);
                }
            }

            int answer = 0;
            if (checkTatalCount(hashMap)) {
                answer++;
            }

            for (int i = totalCnt; i < discount.length; i++) {
                String passProduct = discount[i - totalCnt];
                if (hashMap.containsKey(passProduct)) {
                    hashMap.put(passProduct, hashMap.get(passProduct) + 1);
                }

                if (hashMap.containsKey(discount[i])) {
                    hashMap.put(discount[i], hashMap.get(discount[i]) - 1);
                }

                if (checkTatalCount(hashMap)) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean checkTatalCount(HashMap<String, Integer> hashMap) {
            for (String key : hashMap.keySet()) {
                if (hashMap.get(key) != 0) {
                    return false;
                }
            }

            return true;
        }
    }

}
