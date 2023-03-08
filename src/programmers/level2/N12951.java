package programmers.level2;

public class N12951 { // JadenCase 문자열 만들기
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();

            char[] chars = s.toCharArray();
            answer.append(toUpperCase(chars[0]));

            for (int i = 1; i < chars.length; i++) {
                if (chars[i - 1] == ' ') {
                    answer.append(toUpperCase(chars[i]));
                } else {
                    answer.append(toLowerCase(chars[i]));
                }
            }

            return answer.toString();
        }

        private char toUpperCase(char ch) {
            if ('a' <= ch && ch <= 'z') {
                return (char) (ch - 32);
            }

            return ch;
        }

        private char toLowerCase(char ch) {
            if ('A' <= ch && ch <= 'Z') {
                return (char) (ch + 32);
            }

            return ch;
        }
    }

}
