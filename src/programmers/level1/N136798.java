package programmers.level1;

public class N136798 { // 기사단원의 무기
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;

        System.out.println(new Solution().solution(number, limit, power));
    }

    static class Solution {
        public int solution(int number, int limit, int power) {
            int[] counts = new int[number + 1];
            for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= number / i; j++) {
                    counts[i * j]++;
                }
            }

            int answer = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > limit) {
                    answer += power;
                    continue;
                }

                answer += counts[i];
            }

            return answer;
        }
    }
}
