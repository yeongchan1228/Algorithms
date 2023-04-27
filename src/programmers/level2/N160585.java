package programmers.level2;

public class N160585 { // 혼자서 하는 틱택토
    static char[][] map;
    static final int SIZE = 3;
    static int oCnt = 0;
    static int xCnt = 0;
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        System.out.println(new Solution().solution(board));
    }

    static class Solution {
        public int solution(String[] board) {
            setInfo(board);

            if (!checkCount()) {
                return 0;
            }

            int oFinishCount = getFinishCount('O');
            int xFinishCount = getFinishCount('X');
            if (oFinishCount > 0 && xFinishCount > 0) {
                return 0;
            }

            if (oFinishCount > 0 && oCnt == xCnt) {
                return 0;
            }

            if (xFinishCount > 0 && oCnt > xCnt) {
                return 0;
            }

            return 1;
        }

        private void setInfo(String[] board) {
            map = new char[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = board[i].charAt(j);

                    if (map[i][j] == 'O') {
                        oCnt++;
                    } else if (map[i][j] == 'X') {
                        xCnt++;
                    }
                }
            }
        }

        private boolean checkCount() {
            if (xCnt > oCnt || oCnt - xCnt > 1) {
                return false;
            }

            return true;
        }

        private int getFinishCount(char ch) {
            int count = 0;
            for (int i = 0; i < SIZE; i++) {
                if (checkRow(i, ch)) {
                    count++;
                }
            }

            for (int j = 0; j < SIZE; j++) {
                if (checkCol(j, ch)) {
                    count++;
                }
            }

            if (checkRightDiagonal(ch)) {
                count++;
            }

            if (checkLeftDiagonal(ch)) {
                count++;
            }

            return count;
        }

        private boolean checkRow(int i, char ch) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != ch) {
                    return false;
                }
            }

            return true;
        }

        private boolean checkCol(int j, char ch) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][j] != ch) {
                    return false;
                }
            }

            return true;
        }

        private boolean checkRightDiagonal(char ch) {
            for (int i = 0, j = 0; i < SIZE; i++, j++) {
                if (map[i][j] != ch) {
                    return false;
                }
            }

            return true;
        }

        private boolean checkLeftDiagonal(char ch) {
            for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
                if (map[i][j] != ch) {
                    return false;
                }
            }

            return true;
        }
    }
}
