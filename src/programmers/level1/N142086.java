package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class N142086 { // 가장 가까운 같은 글자
    public static void main(String[] args) {
        String s = "banana";

        for (int answer : new Solution().solution(s)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            Map<Character, Integer> map = new HashMap<>();

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (map.containsKey(ch)) {
                    answer[i] = i - map.get(ch);
                } else {
                    answer[i] = -1;
                }

                map.put(ch, i);
            }

            return answer;
        }
    }
}
