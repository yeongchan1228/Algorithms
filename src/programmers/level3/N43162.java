package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class N43162 { // 네트워크
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new Solution().solution(n, computers));
    }

    static class Solution {
        private static List<List<Integer>> lists = new ArrayList<>();
        public int solution(int n, int[][] computers) {
            setUp(n, computers);

            return calcAnswer(n);
        }

        private int calcAnswer(int n) {
            int answer = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }

                answer++;
                dfs(i, visited);
            }
            return answer;
        }

        private void dfs(int node, boolean[] visited) {
            visited[node] = true;
            for (int nextNode : lists.get(node)) {
                if (visited[nextNode]) {
                    continue;
                }

                dfs(nextNode, visited);
            }
        }

        private void setUp(int n, int[][] computers) {
            setList(n);

            int idx = 1;
            for (int[] computer : computers) {
                for (int i = 0; i < n; i++) {
                    if (computer[i] == 1 && idx != i + 1) {
                        lists.get(idx).add(i + 1);
                    }
                }
                idx++;
            }
        }

        private void setList(int n) {
            for (int i = 0; i <= n; i++) {
                lists.add(new ArrayList<Integer>());
            }
        }
    }
}
