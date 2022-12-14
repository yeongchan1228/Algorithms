package programmers.level4;

import java.util.Arrays;

public class N1843 { // 사칙연산
    public static void main(String[] args) {
        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};

        System.out.println(new Solution().solution(arr));
    }

    static class Solution {
        public int solution(String[] arr) {
            int midSize = (int) Math.ceil(arr.length / 2.0);

            int[][] maxDp = new int[midSize][midSize];
            int[][] minDp = new int[midSize][midSize];
            for (int i = 0; i < midSize; i++) {
                Arrays.fill(maxDp[i], Integer.MIN_VALUE);
                Arrays.fill(minDp[i], Integer.MAX_VALUE);

                int val = Integer.parseInt(arr[i * 2]);
                maxDp[i][i] = val;
                minDp[i][i] = val;
            }

            for (int i = 1; i < midSize; i++) {
                for (int j = 0; j < midSize - i; j++) {
                    int lastIdx = i + j;
                    for (int k = j; k < lastIdx; k++) {
                        if (arr[k * 2 + 1].equals("+")) {
                            maxDp[j][lastIdx] = Math.max(maxDp[j][lastIdx], maxDp[j][k] + maxDp[k + 1][lastIdx]);
                            minDp[j][lastIdx] = Math.min(minDp[j][lastIdx], minDp[j][k] + minDp[k + 1][lastIdx]);

                        } else {
                            maxDp[j][lastIdx] = Math.max(maxDp[j][lastIdx], maxDp[j][k] - minDp[k + 1][lastIdx]);
                            minDp[j][lastIdx] = Math.min(minDp[j][lastIdx], minDp[j][k] - maxDp[k + 1][lastIdx]);
                        }
                    }
                }
            }

            return maxDp[0][midSize - 1];
        }
    }
}
