package leetCode;

import java.util.Stack;

public class P32 { // Longest Valid Parentheses
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        char[] sToChars = s.toCharArray();

        for (int i = 0; i < sToChars.length; i++) {
            if (sToChars[i] == '(') {
                stack.push(i);
                continue;
            }

            if (!stack.isEmpty() && sToChars[stack.peek()] == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        int maxLen = 0;
        int end = s.length();
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            maxLen = Math.max(maxLen, end - idx - 1);
            end = idx;
        }

        return Math.max(maxLen, end);
    }
}
