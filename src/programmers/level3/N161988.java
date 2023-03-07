package programmers.level3;

public class N161988 { // 연속 펄스 부분 수열의 합
    public static void main(String[] args) {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(new Solution().solution(sequence));
    }

    static class Solution {
        public long solution(int[] sequence) {
            long[] dp1 = new long[sequence.length];
            long[] dp2 = new long[sequence.length];
            dp1[0] = sequence[0];
            dp2[0] = sequence[0] * -1;

            long answer = Math.max(dp1[0], dp2[0]);
            for (int i = 1; i < sequence.length; i++) {
                if (i % 2 == 0) {
                    dp1[i] = Math.max(sequence[i], dp1[i - 1] + sequence[i]);
                    dp2[i] = Math.max(sequence[i] * -1, dp2[i - 1] - sequence[i]);
                } else {
                    dp1[i] = Math.max(sequence[i] * -1, dp1[i - 1] - sequence[i]);
                    dp2[i] = Math.max(sequence[i], dp2[i - 1] + sequence[i]);
                }
                answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
            }

            return answer;
        }
    }
}
