package programmers.level2;

public class N12953 { // N개의 최소공배수


    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(new Solution().solution(arr));
    }

    static class Solution {
        public int solution(int[] arr) {
            if (arr.length == 1) {
                return arr[0];
            }

            int a = arr[0];
            int b = arr[1];
            int answer = lcm(a, b);
            for (int i = 2; i < arr.length; i++) {
                answer = lcm(answer, arr[i]);
            }

            return answer;
        }

        private int lcm(int a, int b) {
            int gcd = gcd(a, b);
            return a * b / gcd;
        }

        private int gcd(int a, int b) {
            while (b > 0) {
                int c = a % b;
                a = b;
                b = c;
            }

            return a;
        }
    }
}
