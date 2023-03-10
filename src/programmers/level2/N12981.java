package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class N12981 { // 영어 끝말잇기
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        for (int answer : new Solution().solution(n, words)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];

            int len = words.length;
            Map<String, Boolean> map = new HashMap<>();
            if (words[0].length() == 0) {
                return answer;
            }

            map.put(words[0], true);
            for (int i = 1; i < len; i++) {
                if (!map.containsKey(words[i]) && words[i].charAt(0) == words[i - 1].charAt(words[i - 1].length() - 1) && words[i].length() != 0) {
                    map.put(words[i], true);
                    continue;
                }

                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            return answer;
        }
    }
}
