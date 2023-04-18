package programmers.level3;

import java.util.Arrays;

public class N12987 { // 숫자 게임
    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};
        System.out.println(new Solution().solution(A, B));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);

            int aIdx = 0;
            int bIdx = 0;
            int answer = 0;
            while (bIdx < B.length) {
                if (B[bIdx] > A[aIdx]) {
                    aIdx++;
                    bIdx++;
                    answer++;
                } else {
                    bIdx++;
                }
            }
            return answer;
        }
    }
}
