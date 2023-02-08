package programmers.level2;

import java.util.*;

public class N17684 { // 압축
    public static void main(String[] args) {
        String msg = "ABABABABABABABAB";
        for (int answer : new Solution().solution(msg)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(String msg) {
            int ValSize = 27;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < ValSize; i++) {
                map.put(String.valueOf((char) ('A' + i)), i + 1);
            }

            int idx = 0;
            List<Integer> answer = new ArrayList<>();
            while (idx < msg.length()) {
                int saveVal = 0;
                StringBuilder sb = new StringBuilder();
                sb.append(msg.charAt(idx));
                while (idx < msg.length() && map.containsKey(sb.toString())) {
                    idx++;
                    saveVal = map.get(sb.toString());
                    if (idx < msg.length()) {
                        sb.append(msg.charAt(idx));
                    }
                }
                answer.add(saveVal);
                map.put(sb.toString(), ValSize++);
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
