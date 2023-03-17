package programmers.level2;

import java.util.*;

public class N152996 { // 시소 짝궁
    public static void main(String[] args) {
        int[] weights = {100,180,360,100,270};
        System.out.println(new Solution().solution(weights));
    }

    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int weight : weights) {
                map.put(weight, map.getOrDefault(weight, 0) + 1);
            }

            List<Integer> keyList = new ArrayList(map.keySet());
            Collections.sort(keyList);
            for (int i = 0; i < keyList.size(); i++) {
                int val = map.get(keyList.get(i));
                if (val > 1) {
                    answer += (long) val * (val - 1) / 2;
                }
                for (int j = i + 1; j < keyList.size(); j++) {
                    int num1 = keyList.get(i);
                    int num2 = keyList.get(j);
                    if (num1 * 2 == num2 || num1 * 3 == num2 * 2 || num1 * 4 == num2 * 3) {
                        answer += (long) map.get(num1) * map.get(num2);
                    }
                }
            }

            return answer;
        }
    }
}
