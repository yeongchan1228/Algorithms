package programmers.level2;

import java.util.Arrays;

public class N147354 { // 테이블 해시 함수
    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        System.out.println(new Solution().solution(data, col, row_begin, row_end));
    }

    static class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            Arrays.sort(data, (o1, o2) -> {
                if (o1[col - 1] == o2[col - 1]) {
                    return o2[0] - o1[0];
                }
                return o1[col - 1] - o2[col - 1];
            });

            int answer = 0;
            for (int i = row_begin - 1; i < row_end; i++) {
                int sum = 0;
                for (int dataVal : data[i]) {
                    sum += dataVal % (i + 1);
                }

                answer = answer ^ sum;
            }

            return answer;
        }
    }
}
