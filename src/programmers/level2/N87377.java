package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class N87377 { // 교점에 별 만들기
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        for (String answer : new Solution().solution(line)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public String[] solution(int[][] line) {
            List<Point> list = new ArrayList<>();

            long maxX = Long.MIN_VALUE;
            long minX = Long.MAX_VALUE;
            long maxY = Long.MIN_VALUE;
            long minY = Long.MAX_VALUE;
            for (int i = 0; i < line.length - 1; i++) {
                int a = line[i][0];
                int b = line[i][1];
                int e = line[i][2];
                for (int j = i + 1; j < line.length; j++) {
                    int c = line[j][0];
                    int d = line[j][1];
                    int f = line[j][2];

                    long bfed = (long) b * f - e * d;
                    long denominator = (long) a * d - b * c;
                    if (denominator == 0) {
                        continue;
                    }

                    if (bfed % denominator != 0) {
                        continue;
                    }

                    long ecaf = (long) e * c - a * f;
                    if (ecaf % denominator != 0) {
                        continue;
                    }

                    long x = bfed / denominator;
                    long y = ecaf / denominator;
                    list.add(new Point(x, y));
                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);
                }
            }

            boolean[][] isPoint = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
            for (int i = 0; i < list.size(); i++) {
                Point point = list.get(i);
                isPoint[Math.abs((int) (point.y - maxY))][Math.abs((int) (point.x - minX))] = true;
            }

            String[] answer = new String[(int) (maxY - minY + 1)];
            for (int i = 0; i < isPoint.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < isPoint[i].length; j++) {
                    if (isPoint[i][j]) {
                        sb.append("*");
                    } else {
                        sb.append(".");
                    }
                }
                answer[i] = sb.toString();
            }

            return answer;
        }

        private class Point {
            long x;
            long y;

            public Point(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
