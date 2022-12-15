package programmers.level2;

import java.io.IOException;

public class N92335 { // k진수에서 소수 개수 구하기

    public static void main(String[] args) throws IOException {
        int n = 437674;
        int k = 3;
        System.out.println(new Solution().solution(n, k));
    }

    static class Solution {
        public int solution(int n, int k) {
            String[] split = changeN(n, k).split("0");
            int answer = 0;
            for (String val : split) {
                if (val.length() == 0) {
                    continue;
                }

                if (checkPrime(Long.parseLong(val))) {
                    answer++;
                }
            }

            return answer;
        }

        private String changeN(int n, int k) {
            StringBuilder sb = new StringBuilder();
            while (n > k) {
                sb.append(n % k);
                n /= k;
            }
            sb.append(n);

            return sb.reverse().toString();
        }

        private boolean checkPrime(long num) {
            if (num == 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
