package programmers.dev_matching;

public class Dev2021_2 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};

        Solution solution = new Solution();
        for (int answer : solution.solution(rows, columns, queries)) {
            System.out.println(answer);
        }
    }

     static class Solution {
        static int[][] map;
        public int[] solution(int rows, int columns, int[][] queries) {
            createMap(rows, columns);
            return calc(queries);
        }

         private int[] calc(int[][] queries) {
            int idx = 0;
            int[] answer = new int[queries.length];
            for (int[] query : queries) {
                int x1 = query[0] - 1;
                int y1 = query[1] - 1;
                int x2 = query[2] - 1;
                int y2 = query[3] - 1;

                answer[idx] = map[x1][y1];
                int tmp = map[x1][y1];
                //맨 왼쪽
                for (int i = x1; i < x2; i++) {
                    map[i][y1] = map[i + 1][y1];
                    answer[idx] = Math.min(answer[idx], map[i + 1][y1]);
                }

                // 맨 아래
                for (int i = y1; i < y2; i++) {
                    map[x2][i] = map[x2][i + 1];
                    answer[idx] = Math.min(answer[idx], map[x2][i + 1]);
                }

                // 맨 오른쪽
                for (int i = x2; i > x1; i--) {
                    map[i][y2] = map[i - 1][y2];
                    answer[idx] = Math.min(answer[idx], map[i - 1][y2]);
                }

                // 맨 위
                for (int i = y2; i > y1 + 1; i--) {
                    map[x1][i] = map[x1][i - 1];
                    answer[idx] = Math.min(answer[idx], map[x1][i - 1]);
                }

                map[x1][y1 + 1] = tmp;
                idx++;
            }
            return answer;
         }

         private void createMap(int rows, int columns) {
            int start = 1;
            map = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    map[i][j] = start++;
                }
            }
        }
    }
}
