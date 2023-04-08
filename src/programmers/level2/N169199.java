package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class N169199 { // 리코쳇 로봇
    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(new Solution().solution(board));
    }

    static class Solution {
        private static int[] dCol = {1, -1, 0, 0};
        private static int[] dRow = {0, 0, 1, -1};
        private static int row = 0, col = 0;

        private static char[][] map;
        private static boolean[][] visited;
        public int solution(String[] board) {
            row = board.length;
            col = board[0].length();

            Queue<Info> queue = new LinkedList<>();
            visited = new boolean[row][col];
            map = new char[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    map[i][j] = board[i].charAt(j);
                    if (map[i][j] == 'R') {
                        queue.offer(new Info(i, j, 0));
                        visited[i][j] = true;
                    }
                }
            }

            return bfs(queue);
        }

        private int bfs(Queue<Info> queue) {
            while (!queue.isEmpty()) {
                Info info = queue.poll();

                for (int i = 0; i < dRow.length; i++) {
                    int pRow = info.row + dRow[i];
                    int pCol = info.col + dCol[i];

                    while (isValid(pRow, pCol)) {
                        pRow += dRow[i];
                        pCol += dCol[i];
                    }

                    pRow -= dRow[i];
                    pCol -= dCol[i];

                    if (map[pRow][pCol] == 'R' || (row == pRow && col == pCol) || visited[pRow][pCol]) {
                        continue;
                    }

                    if (map[pRow][pCol] == 'G') {
                        return info.move + 1;
                    }

                    visited[pRow][pCol] = true;
                    queue.offer(new Info(pRow, pCol, info.move + 1));
                }
            }

            return -1;
        }

        private boolean isValid(int pRow, int pCol) {
            return pRow > -1 && pRow < row && pCol > -1 && pCol < col && map[pRow][pCol] != 'D';
        }

        static class Info  {
            int row;
            int col;
            int move;

            public Info(int row, int col, int move) {
                this.row = row;
                this.col = col;
                this.move = move;
            }
        }
    }

}
