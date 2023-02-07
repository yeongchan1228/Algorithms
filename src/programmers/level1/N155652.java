package programmers.level1;

public class N155652 { // 둘만의 암호
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int idx = 5;
        System.out.println(new Solution().solution(s, skip, idx));
    }

    static class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();
            for (char ch : s.toCharArray()) {
                for (int i = 0; i < index; i++) {
                    ch = plus(ch);
                    while (skip.contains(String.valueOf(ch))) {
                        ch = plus(ch);
                    }
                }

                answer.append(ch);
            }
            return answer.toString();
        }

        private char plus(char ch) {
            return (++ch > 'z') ? 'a' : ch;
        }
    }
}
