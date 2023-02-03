package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class N154539 { // 뒤에 있는 큰 수 찾기
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        for (int answer : new Solution().solution(numbers)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Arrays.fill(answer, -1);
            Stack<Number> stack = new Stack<>();

            for (int i = 0; i < numbers.length; i++) {
                int number = numbers[i];

                while (!stack.isEmpty() && stack.peek().value < number) {
                    answer[stack.pop().idx] = number;
                }
                stack.push(new Number(i, number));
            }

            return answer;
        }

        private static class Number {
            int idx;
            int value;

            public Number(int idx, int value) {
                this.idx = idx;
                this.value = value;
            }
        }
    }

}