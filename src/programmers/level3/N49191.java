package programmers.level3;

public class N49191 { // 순위
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(new Solution().solution(n, results));
    }

    static class Solution {
        static int[][] graphs;

        public int solution(int n, int[][] results) {
            setGraphs(n, results);

            calc(n);

            return getAnswer(n);
        }

        private void setGraphs(int n, int[][] results) {
            graphs = new int[n + 1][n + 1];
            for (int[] result : results) {
                int winner = result[0];
                int loser = result[1];

                graphs[winner][loser] = 1;
                graphs[loser][winner] = -1;
            }
        }

        private void calc(int n) {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    if (k == i) {
                        continue;
                    }
                    for (int j = 1; j <= n; j++) {
                        if (i == j) {
                            continue;
                        }

                        if (graphs[i][k] == 1 && graphs[k][j] == 1) {
                            graphs[i][j] = 1;
                            graphs[j][i] = -1;
                        }

                        if (graphs[i][k] == -1 && graphs[k][j] == -1) {
                            graphs[j][i] = 1;
                            graphs[i][j] = -1;
                        }
                    }
                }
            }
        }

        private int getAnswer(int n) {
            int answer = 0;

            for (int i = 1; i <= n; i++) {
                boolean isConfirm = true;
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (graphs[i][j] == 0) {
                        isConfirm = false;
                        break;
                    }
                }

                if (isConfirm) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
