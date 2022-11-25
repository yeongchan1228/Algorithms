package programmers.level2;

public class N42883 { // 큰 수 만들기
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;

        System.out.println(new Solution().solution(number, k));
    }

    static class Solution {
        public String solution(String number, int k) {
            int idx = 0;
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < number.length() - k; i++) {
                int max = 0;
                for (int j = idx; j <= k + i; j++) {
                    int val = number.charAt(j) - '0';
                    if (val > max) {
                        max = val;
                        idx = j + 1;
                    }
                }
                answer.append(max);
            }
            return answer.toString();
        }
    }
}
