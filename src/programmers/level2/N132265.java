package programmers.level2;

import java.util.Map;
import java.util.HashMap;

public class N132265 { // 롤케이크 자르기
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        System.out.println(new Solution().solution(topping));
    }

    static class Solution {
        public int solution(int[] topping) {
            Map<Integer, Integer> hashMap1 = new HashMap<>();
            Map<Integer, Integer> hashMap2 = new HashMap<>();

            for (int i = 0; i < topping.length; i++) {
                hashMap2.put(topping[i], hashMap2.getOrDefault(topping[i], 0) + 1);
            }

            int answer = 0;
            for (int i = 0; i < topping.length; i++) {
                hashMap1.put(topping[i], hashMap1.getOrDefault(topping[i], 0) + 1);
                if (hashMap2.containsKey(topping[i])) {
                    int val = hashMap2.get(topping[i]) - 1;
                    if (val == 0) {
                        hashMap2.remove(topping[i]);
                    } else {
                        hashMap2.put(topping[i], val);
                    }
                }

                if (hashMap1.size() == hashMap2.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
