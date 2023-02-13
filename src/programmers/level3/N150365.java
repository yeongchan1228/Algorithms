package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class N150365 { // 미로 탈출 명령어
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;

        System.out.println(new Solution().solution(n, m, x, y, r, c, k));
    }

    static class Solution {
        private static final int[] dx = {1, 0, 0, -1};
        private static final int[] dy = {0, -1, 1, 0};
        private static final char[] moveChar = {'d', 'l', 'r', 'u'};
        private static final String IMPOSSIBLE = "impossible";

        private static int[][] map;

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            map = new int[n][m];
            return bfs(x - 1, y - 1, r - 1, c - 1, k, n, m);
        }

        private String bfs(int x, int y, int r, int c, int k, int n, int m) {
            Queue<Info> queue = new LinkedList<>();
            queue.offer(new Info(x, y, new StringBuilder()));

            while (!queue.isEmpty()) {
                Info now = queue.poll();
                int depth = now.move.toString().length();

                if (depth == k) {
                    if (now.x == r && now.y == c) {
                        return now.move.toString();
                    }
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int px = now.x + dx[i];
                    int py = now.y + dy[i];
                    if (isValid(px, py, n, m, depth)) {
                        map[px][py] = depth + 1;
                        queue.offer(new Info(px, py, new StringBuilder(now.move.toString()).append(moveChar[i])));
                    }
                }
            }

            return IMPOSSIBLE;
        }

        private boolean isValid(int px, int py, int n, int m, int depth) {
            return px > -1 && px < n && py > -1 && py < m && map[px][py] < depth + 1;
        }

        public class Info {
            int x;
            int y;
            StringBuilder move;

            public Info(int x, int y, StringBuilder move) {
                this.x = x;
                this.y = y;
                this.move = move;
            }
        }
    }
}
