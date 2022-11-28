package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N1844 { // 게임 맵 최단거리
    static int n = 0;
    static int m = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};

        System.out.println(new Solution().solution(maps));
    }

    static class Solution {

        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;

            bfs(0, 0, maps);

            return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
        }

        private void bfs(int x, int y, int[][] maps) {
            Queue<Position> queue = new LinkedList<>();
            queue.offer(new Position(x, y));

            while (!queue.isEmpty()) {
                Position now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int px = dx[i] + now.x;
                    int py = dy[i] + now.y;

                    if (!isValid(now.x, now.y, px, py, maps)) {
                        continue;
                    }

                    maps[px][py] = maps[now.x][now.y] + 1;
                    queue.offer(new Position(px, py));
                }
            }

        }

        private boolean isValid(int x, int y, int px, int py, int[][] maps) {
            return px > -1 && px < n && py > -1 && py < m
                    && (maps[px][py] == 1 || maps[px][py] > maps[x][y] + 1);
        }

        private class Position {
            int x;
            int y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
