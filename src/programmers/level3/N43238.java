
package programmers.level3;

public class N43238 { // 입국 심사
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        System.out.println(new Solution().solution(n, times));
    }

    static class Solution {
        public long solution(int n, int[] times) {
            long minTime = 0;
            long maxTime = getMaxTime(times) * n;

            long answer = 0;
            while (minTime <= maxTime) {
                long middleTime = (minTime + maxTime) / 2;

                long totalPassCount = 0;
                for (int time : times) {
                    totalPassCount += (middleTime / time);
                }

                if (totalPassCount < n) {
                    minTime = middleTime + 1;
                } else {
                    maxTime = middleTime - 1;
                    answer = middleTime;
                }
            }

            return answer;
        }

        private long getMaxTime(int[] times) {
            int maxTime = 0;
            for (int time : times) {
                if (time > maxTime) {
                    maxTime = time;
                }
            }
            return maxTime;
        }
    }
}
