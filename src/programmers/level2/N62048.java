package programmers.level2;

public class N62048 { // 멀쩡한 사각형
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(new Solution().solution(w, h));
    }

    static class Solution {
        public long solution(int w, int h) {
            long gcd = gcd(w, h);

            return (long) w * h - (w + h - gcd);
        }

        private long gcd(int a, int b) {
            while (b != 0) {
                int c = a % b;
                a = b;
                b = c;
            }

            return a;
        }
    }

}
