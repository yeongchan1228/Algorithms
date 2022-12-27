package programmers.level2;

public class N140107 { // 점 찍기
    public static void main(String[] args) {
        int k = 1;
        int d = 5;

        System.out.println(new Solution().solution(k, d));
    }

    static class Solution {
        public long solution(int k, int d) {
            long answer = 0;

            for (long i = 0; i <= d; i += k) {
                answer += (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(i, 2)) / k + 1;
            }

            return answer;
        }
    }

}
