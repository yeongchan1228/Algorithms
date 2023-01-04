package programmers.level3;

public class N131703 { // 2차원 동전 뒤집기

    public static void main(String[] args) {
        int[][] beginning = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int[][] target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};

        System.out.println(new Solution().solution(beginning, target));
    }

    static class Solution {
        static int answer = Integer.MAX_VALUE;

        public int solution(int[][] beginning, int[][] target) {
            dfs(0, 0, beginning, target);

            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        private void dfs(int depth, int cnt, int[][] beginning, int[][] target) {
            if (depth == beginning[0].length) {
                int val = checkLines(beginning, target);
                if (val == -1) {
                    return;
                }

                answer = Math.min(answer, cnt + val);
                return;
            }

            dfs(depth + 1, cnt, beginning, target);
            filpLine(depth, beginning);
            dfs(depth + 1, cnt + 1, beginning, target);
            filpLine(depth, beginning);
        }

        private int checkLines(int[][] beginning, int[][] target) {
            int cnt = 0;
            for (int i = 0; i < beginning.length; i++) {
                if (!checkLine(i, beginning, target)) {
                    if (checkFilpLine(i, beginning, target)) {
                        cnt++;
                        continue;
                    }

                    return -1;
                }
            }

            return cnt;
        }

        private boolean checkFilpLine(int line, int[][] beginning, int[][] target) {
            for (int i = 0; i < beginning[0].length; i++) {
                int val = beginning[line][i] ^ 1;
                if (val != target[line][i]) {
                    return false;
                }
            }

            return true;
        }

        private boolean checkLine(int line, int[][] beginning, int[][] target) {
            for (int i = 0; i < beginning[0].length; i++) {
                if (beginning[line][i] != target[line][i]) {
                    return false;
                }
            }

            return true;
        }

        private void filpLine(int line, int[][] beginning) {
            for (int i = 0; i < beginning.length; i++) {
                beginning[i][line] = beginning[i][line] ^ 1;
            }
        }
    }
}
