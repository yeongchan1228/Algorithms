package programmers.level2;

import java.io.IOException;

public class N12924 { // 숫자의 표현
    public static void main(String[] args) throws IOException {
        int n = 15;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int start = 1;
            int end = 1;
            int sum = end;
            int answer = 0;
            while (start <= end) {
                if (sum < n) {
                    sum += ++end;
                    continue;
                }

                if (sum == n) {
                    answer++;
                }

                sum -= start;
                start++;
            }
            return answer;
        }
    }
}
