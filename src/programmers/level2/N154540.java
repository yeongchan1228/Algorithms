package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class N154540 { // 무인도 여행
    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        for (int answer : new Solution().solution(maps)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        private static int[] di = {1, -1, 0, 0};
        private static int[] dj = {0, 0, 1, -1};

        private static char[][] map;
        private static boolean[][] visited;
        private static int val = 0;
        public int[] solution(String[] maps) {
            setUp(maps);

            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] != 'X' && !visited[i][j]) {
                        val += map[i][j] - '0';
                        visited[i][j] = true;
                        dfs(i, j);

                        answer.add(val);
                        val = 0;
                    }
                }
            }

            if (answer.size() == 0) {
                return new int[]{-1};
            }

            return answer.stream().sorted().mapToInt(i -> i).toArray();
        }

        private void dfs(int i, int j) {
            for (int k = 0; k < di.length; k++) {
                int pi = i + di[k];
                int pj = j + dj[k];

                if (isValid(pi, pj)) {
                    visited[pi][pj] = true;
                    val += (map[pi][pj] - '0');
                    dfs(pi, pj);
                }
            }
        }

        private boolean isValid(int pi, int pj) {
            return pi > -1 && pi < map.length && pj > -1 && pj < map[0].length && map[pi][pj] != 'X' && !visited[pi][pj];
        }

        private void setUp(String[] maps) {
            map = new char[maps.length][maps[0].length()];
            visited = new boolean[maps.length][maps[0].length()];

            for (int i = 0; i < map.length; i++) {
                char[] infos = maps[i].toCharArray();
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = infos[j];
                }
            }
        }
    }
}
