package programmers.level2;

import java.util.Stack;

public class N131704 { // 택배상자

    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(new Solution().solution(order));
    }

    static class Solution {
        public int solution(int[] order) {
            Stack<Integer> stack = new Stack<>();

            int answer = 0;
            for (int i = 1; i <= order.length; i++) {
                if (order[answer] == i) {
                    answer++;
                } else {
                    stack.push(i);
                }

                while (!stack.isEmpty() && stack.peek() == order[answer]) {
                    answer++;
                    stack.pop();
                }
            }

            return answer;
        }
    }
}
