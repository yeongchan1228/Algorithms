package programmers.level2;

public class N49994 { // 방문 길이
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(new Solution().solution(dirs));
    }

    static class Solution {
        static int x = 10;
        static int y = 10;
        static final int MAX = 21;

        static final int[] dx = {2, -2, 0, 0};
        static final int[] dy = {0, 0, 2, -2};

        static final boolean[][] isVisited = new boolean[MAX][MAX];

        public int solution(String dirs) {
            for (char ch : dirs.toCharArray()) {
                switch (ch) {
                    case 'U' :
                        if (isValidPosition(2)) {
                            positionToTrue(0, -1);
                        }
                        break;
                    case 'D' :
                        if (isValidPosition(3)) {
                            positionToTrue(0, 1);
                        }
                        break;
                    case 'R' :
                        if (isValidPosition(0)) {
                            positionToTrue(-1, 0);
                        }
                        break;
                    case 'L' :
                        if (isValidPosition(1)) {
                            positionToTrue(1, 0);
                        }
                        break;
                }
            }

            return getAnswer();
        }

        private static int getAnswer() {
            int answer = 0;
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    if (isVisited[i][j]) {
                        answer++;
                    }
                }
            }
            return answer;
        }

        private boolean isValidPosition(int idx) {
            int px = x + dx[idx];
            int py = y + dy[idx];

            if (px > -1 && px < MAX && py > -1 && py < MAX) {
                x = px;
                y = py;
                return true;
            }

            return false;
        }

        private void positionToTrue(int px, int py) {
            isVisited[x + px][y + py] = true;
        }
    }
}
