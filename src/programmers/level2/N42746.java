package programmers.level2;

import java.io.IOException;
import java.util.Arrays;

public class N42746 { // 가장 큰 수

    public static void main(String[] args) throws IOException {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        public String solution(int[] numbers) {
            String[] strs = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                strs[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(strs, (o1, o2) -> {
                return (o2 + o1).compareTo(o1 + o2);
            });

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                if (i == 0 && strs[i].equals("0")) {
                    return "0";
                }

                answer.append(strs[i]);
            }

            return answer.toString();
        }
    }

}
