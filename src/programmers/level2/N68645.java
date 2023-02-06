package programmers.level2;

import java.util.*;

public class N68645 { // 삼각 달팽이
    public static void main(String[] args) {
        int n = 4;
        for (int answer : new Solution().solution(n)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(int n) {
            int[][] map = new int[n][n];

            int x = -1;
            int y = 0;
            int val = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    if (i % 3 == 0) {
                        x++;
                    } else if (i % 3 == 1) {
                        y++;
                    } else if (i % 3 == 2) {
                        x--;
                        y--;
                    }
                    map[x][y] = val++;
                }
            }

            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) {
                        break;
                    }
                    answer.add(map[i][j]);
                }
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
