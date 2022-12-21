package programmers.level2;

import java.util.Arrays;

public class N87390 { // n^2 배열 자르기

    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        System.out.println(Arrays.toString(new Solution().solution(n, left, right)));
    }

    static class Solution {
        public int[] solution(int n, long left, long right) {
            int size = (int) (right - left) + 1;
            int[] answer = new int[size];

            int cnt = 0;
            for (long i = left; i <= right; i++) {
                long x = i / n;
                long y = i % n;
                answer[cnt++] = (int) (Math.max(x, y) + 1);
            }
            return answer;
        }
    }

}