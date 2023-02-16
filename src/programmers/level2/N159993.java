package programmers.level2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class N159993 { // 미로 탈출

    public static void main(String[] args) throws IOException {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(new Solution().solution(maps));
    }

    static class Solution {
        private static final char LEVER = 'L';
        private static final char FINISH = 'E';
        private static int[] di = {1, 0, -1, 0};
        private static int[] dj = {0, 1, 0, -1};

        private static char[][] map;
        private static int[][] checkMap;
        public int solution(String[] maps) {
            int maxI = maps.length;
            int maxJ = maps[0].length();

            Info startInfo = null;
            Info leverInfo = null;
            map = new char[maxI][maxJ];
            checkMap = new int[maxI][maxJ];
            for (int i = 0; i < maxI; i++) {
                for (int j = 0; j < maxJ; j++) {
                    map[i][j] = maps[i].charAt(j);

                    if (map[i][j] == 'S') {
                        startInfo = new Info(i, j);
                        continue;
                    }

                    if (map[i][j] == 'L') {
                        leverInfo = new Info(i, j);
                    }
                }
            }

            resetCheckMap();
            int leverVal = bfs(startInfo, maxI, maxJ, LEVER);
            if (leverVal == -1) {
                return -1;
            }

            resetCheckMap();
            int finishVal = bfs(leverInfo, maxI, maxJ, FINISH);
            if (finishVal == -1) {
                return -1;
            }

            return leverVal + finishVal;
        }

        private int bfs(Info info, int maxI, int maxJ, char target) {
            Queue<Info> queue = new LinkedList<>();
            queue.offer(info);
            checkMap[info.i][info.j] = 0;

            while (!queue.isEmpty()) {
                Info now = queue.poll();

                for (int i = 0; i < di.length; i++) {
                    int pi = now.i + di[i];
                    int pj = now.j + dj[i];

                    if (isValid(pi, pj, maxI, maxJ, now)) {
                        checkMap[pi][pj] = checkMap[now.i][now.j] + 1;
                        if (map[pi][pj] == target) {
                            return checkMap[pi][pj];
                        }
                        queue.offer(new Info(pi, pj));
                    }
                }
            }

            return -1;
        }

        private boolean isValid(int pi, int pj, int maxI, int maxJ, Info now) {
            return pi > -1 && pi < maxI && pj > -1 && pj < maxJ && map[pi][pj] != 'X' && checkMap[pi][pj] > checkMap[now.i][now.j] + 1;
        }

        private void resetCheckMap() {
            for (int i = 0; i < checkMap.length; i++) {
                for (int j = 0; j < checkMap[0].length; j++) {
                    checkMap[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        public class Info {
            int i;
            int j;

            public Info(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
    }

}
