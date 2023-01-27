package programmers.level2;

import java.util.Stack;

public class N76502 { // 괄호 회전하기

    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int size = s.length();

            int answer = 0;
            for (int i = 0; i < size; i++) {
                if (isValid(s, i, size)) {
                    answer++;
                }
            }
            return answer;
        }

        private boolean isValid(String s, int idx, int size) {
            Stack<Character> stack = new Stack<>();
            for (int i = idx; i < size + idx; i++) {
                char ch = s.charAt(i % size);
                switch (ch) {
                    case '[' :
                        stack.push('[');
                        break;
                    case ']' :
                        if (stack.isEmpty() || stack.peek() != '[') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case '{' :
                        stack.push('{');
                        break;
                    case '}' :
                        if (stack.isEmpty() || stack.peek() != '{') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case '(' :
                        stack.push('(');
                        break;
                    case ')' :
                        if (stack.isEmpty() || stack.peek() != '(') {
                            return false;
                        }
                        stack.pop();
                        break;
                }
            }

            if (stack.size() != 0) {
                return false;
            }

            return true;
        }
    }
}
