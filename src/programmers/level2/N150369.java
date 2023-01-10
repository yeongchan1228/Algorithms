package programmers.level2;

public class N150369 { // 택배 배달과 수거하기

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        System.out.println(new Solution().solution(cap, n, deliveries, pickups));
    }

    static class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            int idx = n - 1;
            int weight = 0;
            long answer = 0;
            while (true) {
                while (idx >= 0 && deliveries[idx] == 0 && pickups[idx] == 0) {
                    idx--;
                }

                if (idx == -1) {
                    break;
                }

                answer += idx + 1;

                calc(idx, cap, deliveries);
                calc(idx, cap, pickups);
            }

            return answer * 2;
        }

        private void calc(int idx, int cap, int[] arr) {
            int sum = 0;
            for (int i = idx; i >= 0; i--) {
                if (sum + arr[i] > cap) {
                    arr[i] -= (cap - sum);
                    sum = cap;
                    break;
                }

                sum += arr[i];
                arr[i] = 0;
            }
        }
    }
}
