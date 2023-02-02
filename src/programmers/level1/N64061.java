package programmers.level1;

import java.util.Stack;

public class N64061 { // 크레인 인형뽑기 게임
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(new Solution().solution(board, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            Point[] location = new Point[board.length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (location[j] == null && board[i][j] != 0) {
                        location[j] = new Point(i, j);
                        continue;
                    }
                }
            }

            Stack<Integer> stack = new Stack<>();

            for (int move : moves) {
                if (location[move-1] == null) {
                    continue;
                }

                Point current = location[move-1];
                int doll = board[current.x][current.y];
                if (!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer++;
                } else {
                    stack.push(doll);
                }

                board[current.x][current.y] = 0;
                int nx = current.x + 1;
                if (nx < board.length && board[nx][current.y] != 0) {
                    location[move - 1] = new Point(nx, current.y);
                } else {
                    location[move - 1] = null;
                }
            }

            return answer * 2;
        }

        static class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
