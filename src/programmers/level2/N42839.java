package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class N42839 { // 소수 찾기

    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        private static int answer = 0;
        private final int MAX_SIZE = 10000000;

        public int solution(String numbers) {
            char[] numberChars = numbers.toCharArray();
            int len = numberChars.length;

            boolean[] isNotPrimes = calcPrime();
            char[] saveChars = new char[len];
            boolean[] visited = new boolean[len];
            Set<Integer> finishedSet = new HashSet<>();
            calcAnswer(0, saveChars, numberChars, visited, isNotPrimes, finishedSet);
            return answer;
        }

        private void calcAnswer(int depth, char[] saveChars, char[] numberChars, boolean[] visited, boolean[] isNotPrimes, Set<Integer> finishedSet) {
            if (depth != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < depth; i++) {
                    sb.append(saveChars[i]);
                }

                int val = Integer.parseInt(sb.toString());
                if (!finishedSet.contains(val) && !isNotPrimes[val]) {
                    answer++;
                }
                finishedSet.add(val);
            }

            if (depth == numberChars.length) {
                return;
            }

            for (int i = 0; i < numberChars.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    saveChars[depth] = numberChars[i];
                    calcAnswer(depth + 1, saveChars, numberChars, visited, isNotPrimes, finishedSet);
                    visited[i] = false;
                }
            }
        }

        private boolean[] calcPrime() {
            boolean[] isNotPrimes = new boolean[MAX_SIZE];
            isNotPrimes[0] = true;
            isNotPrimes[1] = true;

            for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
                for (int j = i + i; j < MAX_SIZE; j += i) {
                    if (!isNotPrimes[j]) {
                        isNotPrimes[j] = true;
                    }
                }
            }

            return isNotPrimes;
        }
    }

}