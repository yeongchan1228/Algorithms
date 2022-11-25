package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class Internship2021_2 { // 거리두기 확인하기
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        Solution solution = new Solution();
        for (int val : solution.solution(places)) {
            System.out.println(val);
        }
    }

    static class Solution {
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};

        static final int SIZE = 5;
        static final char PERSON = 'P';
        static final char TABLE = 'O';

        public int[] solution(String[][] places) {

            int idx = 0;
            int[] answer = new int[places.length];
            for (String[] place : places) {
                boolean isContinue = true;
                for (int i = 0; i < SIZE && isContinue; i++) {
                    for (int j = 0; j < SIZE && isContinue; j++) {
                        if (place[i].charAt(j) == PERSON) {
                            if (!bfs (i, j, place)) {
                                isContinue = false;
                            }
                        }
                    }
                }

                answer[idx] = isContinue ? 1 : 0;
                idx++;
            }

            return answer;
        }

        private boolean bfs(int x, int y, String[] place) {
            Queue<Position> queue = new LinkedList<>();
            queue.offer(new Position(x, y));

            while (!queue.isEmpty()) {
                Position now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int px = now.x + dx[i];
                    int py = now.y + dy[i];

                    if (px < 0 || py < 0 || px >= SIZE || py >= SIZE || (px == x && py == y)) {
                        continue;
                    }

                    int distance = Math.abs(x - px) + Math.abs(y - py);
                    if (place[px].charAt(py) == PERSON && distance <= 2) {
                        return false;
                    }

                    if (place[px].charAt(py) == TABLE && distance < 2) {
                        queue.offer(new Position(px, py));
                    }
                }
            }

            return true;
        }

        public class Position {
            int x;
            int y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
