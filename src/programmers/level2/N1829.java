package programmers.level2;

public class N1829 { // 카카오프렌즈 컬러링북

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        for (int answer : new Solution().solution(m, n ,picture)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static int cnt = 0;
        static int[] di = {1, -1, 0, 0};
        static int[] dj = {0, 0, 1, -1};

        public int[] solution(int m, int n, int[][] picture) {
            int[] answer = new int[2];
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && picture[i][j] != 0) {
                        answer[0]++;
                        visited[i][j] = true;
                        dfs(1, i, j, picture[i][j], picture, visited);
                        answer[1] = Math.max(answer[1], cnt + 1);
                        cnt = 0;
                    }
                }
            }

            return answer;
        }

        private void dfs(int depth, int i, int j, int val, int[][] picture, boolean[][] visited) {
            for (int k = 0; k < di.length; k++) {
                int pi = i + di[k];
                int pj = j + dj[k];

                if (isValid(val, picture, visited, pi, pj)) {
                    visited[pi][pj] = true;
                    cnt++;
                    dfs(depth + 1, pi, pj, val, picture, visited);
                }
            }
        }

        private boolean isValid(int val, int[][] picture, boolean[][] visited, int pi, int pj) {
            return pi > -1 && pi < picture.length && pj > -1 && pj < picture[0].length && !visited[pi][pj] && val == picture[pi][pj];
        }
    }
}
