package programmers.level3;

public class N64062 { // 징검다리 건너기
    public static void main(String[] args) {
        int k = 3;
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(new Solution().solution(stones, k));
    }

    static class Solution {
        public int solution(int[] stones, int k) {
            int left = 1;
            int right = getRight(stones);
            int answer = 0;
            while (left <= right) {
                int mid = (left + right) / 2;

                int cnt = 0;
                for (int stone : stones) {
                    if (stone >= mid) {
                        cnt = 0;
                        continue;
                    }

                    if (stone < mid) {
                        cnt++;
                    }

                    if (cnt == k) {
                        break;
                    }
                }

                if (cnt == k) {
                    right = mid - 1;
                    continue;
                }

                answer = mid;
                left = mid + 1;
            }

            return answer;
        }

        private int getRight(int[] stones) {
            int right = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > right) {
                    right = stones[i];
                }
            }
            return right;
        }
    }
}
