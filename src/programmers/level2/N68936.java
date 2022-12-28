package programmers.level2;

public class N68936 { // 쿼드압축 후 개수 세기

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        for (int answer : new Solution().solution(arr)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static int zero = 0;
        static int one = 0;
        public int[] solution(int[][] arr) {
            calc(0, 0, arr.length, arr);

            return new int[]{zero, one};
        }

        private void calc(int x, int y, int size, int[][] arr) {
            if (checkArr(x, y, size, arr)) {
                if (arr[x][y] == 0) {
                    zero++;
                } else {
                    one++;
                }
                return;
            } else {
                int calcSize = size / 2;
                calc(x, y, calcSize, arr);
                calc(x + calcSize, y, calcSize, arr);
                calc(x, y + calcSize, calcSize, arr);
                calc(x + calcSize, y + calcSize, calcSize, arr);
            }
        }

        private boolean checkArr(int x, int y, int size, int[][] arr) {
            int val = arr[x][y];
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (arr[i][j] != val) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
