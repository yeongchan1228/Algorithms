package programmers.level2;

public class N178870 { // 연속된 부분 수열의 합
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        System.out.println(new Solution().solution(sequence, k));
    }

    static class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            int left = 0;
            int right = 0;
            int sum = sequence[left];
            int minLen = Integer.MAX_VALUE;
            while (left <= right && right < sequence.length) {
                if (sum == k) {
                    if (right - left < minLen) {
                        answer[0] = left;
                        answer[1] = right;
                        minLen = right - left;
                    }
                    sum -= sequence[left++];
                    continue;
                }

                if (sum < k) {
                    right++;
                    if (right < sequence.length) {
                        sum += sequence[right];
                    }
                    continue;
                }

                if (sum > k) {
                    sum -= sequence[left++];
                }
            }

            return answer;
        }
    }

}
