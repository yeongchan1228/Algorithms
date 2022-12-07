package programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class N49189 { // 가장 먼 노드
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(new Solution().solution(n, vertex));
    }

    static class Solution {
        static int maxVal = 0;
        static int[] depths;
        static ArrayList<ArrayList<Integer>> list;

        public int solution(int n, int[][] edge) {
            depths = new int[n + 1];

            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int[] nowEdge : edge) {
                int from = nowEdge[0];
                int to = nowEdge[1];

                list.get(from).add(to);
                list.get(to).add(from);
            }

            calc();

            int answer = 0;
            for (int i = 2; i <= n; i++) {
                if (depths[i] == maxVal) {
                    answer++;
                }
            }

            return answer;
        }

        private void calc() {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            depths[1] = 1;

            while (!queue.isEmpty()) {
                int nowIdx = queue.poll();

                for (int nextIdx : list.get(nowIdx)) {
                    if (depths[nextIdx] != 0) {
                        continue;
                    }

                    depths[nextIdx] = depths[nowIdx] + 1;
                    maxVal = Math.max(maxVal, depths[nextIdx]);
                    queue.offer(nextIdx);
                }
            }
        }
    }
}
