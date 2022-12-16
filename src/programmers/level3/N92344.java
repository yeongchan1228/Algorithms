package programmers.level3;

public class N92344 { // 파괴되지 않은 건물
    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        System.out.println(new Solution().solution(board, skill));
    }

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int n = board.length;
            int m = board[0].length;
            int[][] preArr = new int[n + 1][m + 1];

            for (int[] info : skill) {
                int degree = info[0] == 1 ? -info[5] : info[5];
                int x1 = info[1];
                int y1 = info[2];
                int x2 = info[3];
                int y2 = info[4];

                preArr[x1][y1] += degree;
                preArr[x1][y2 + 1] += -degree;
                preArr[x2 + 1][y2 + 1] += degree;
                preArr[x2 + 1][y1] += -degree;
            }

            for (int i = 0; i < n + 1; i++) {
                int sum = 0;
                for (int j = 0; j < m + 1; j++) {
                    sum += preArr[i][j];
                    preArr[i][j] = sum;
                }
            }

            for (int i = 0; i < m + 1; i++) {
                int sum = 0;
                for (int j = 0; j < n + 1; j++) {
                    sum += preArr[j][i];
                    preArr[j][i] = sum;
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] + preArr[i][j] > 0) {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }
}
