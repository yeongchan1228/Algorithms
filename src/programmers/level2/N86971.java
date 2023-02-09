package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class N86971 { // 전력망을 둘로 나누기
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
        System.out.println(new Solution().solution(n, wires));
    }

    static class Solution {
        private static List<List<Integer>> lists = new ArrayList<>();
        public int solution(int n, int[][] wires) {
            for (int i = 0; i <= n; i++) {
                lists.add(new ArrayList<Integer>());
            }

            for (int[] wire : wires) {
                lists.get(wire[0]).add(wire[1]);
                lists.get(wire[1]).add(wire[0]);
            }

            return calc(n);
        }

        private int calc(int n) {
            int min = Integer.MAX_VALUE;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                visited[i] = true;
                for (int node : lists.get(i)) {
                    if (visited[node]) {
                        continue;
                    }

                    int nodes = searchChild(i, node, new boolean[n + 1]) + 1;
                    min = Math.min(min, Math.abs(nodes - (n - nodes)));
                }
            }

            return min;
        }

        private int searchChild(int node, int excludeNode, boolean[] visited) {
            int childs = 0;
            visited[node] = true;
            visited[excludeNode] = true;
            for (int nextNode : lists.get(node)) {
                if (!visited[nextNode]) {
                    childs++;
                    visited[nextNode] = true;
                    childs += searchChild(nextNode, excludeNode, visited);
                }
            }
            return childs;
        }
    }
}
