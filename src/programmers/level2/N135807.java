package programmers.level2;

import java.io.IOException;

public class N135807 { // 숫자 카드 나누기

    public static void main(String[] args) throws IOException {
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};
        System.out.println(new Solution().solution(arrayA, arrayB));
    }

    static class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;
            int gcdA = getGcdFromArray(arrayA);
            int gcdB = getGcdFromArray(arrayB);

            if (gcdA != 1 && checkVal(gcdA, arrayB)) {
                answer = Math.max(answer, gcdA);
            }

            if (gcdB != 1 && checkVal(gcdB, arrayA)) {
                answer = Math.max(answer, gcdB);
            }

            return answer;
        }

        private boolean checkVal(int val, int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % val == 0) {
                    return false;
                }
            }

            return true;
        }

        private int getGcdFromArray(int[] array) {
            int gcd = array[0];
            for (int i = 1; i < array.length; i++) {
                gcd = gcd(gcd, array[i]);

                if (gcd == 1) {
                    break;
                }
            }

            return gcd;
        }

        private int gcd(int a, int b) {
            while (b > 0) {
                int r = a % b;
                a = b;
                b = r;
            }

            return a;
        }
    }

}
