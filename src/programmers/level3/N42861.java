package programmers.level3;

import java.util.Arrays;

public class N42861 { // 섬 연결하기
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        System.out.println(new Solution().solution(n, costs));
    }

    static class Solution {
        public int solution(int n, int[][] costs) {
            int[] parent = getParent(n);

            Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

            int answer = 0;
            for (int i = 0; i < costs.length; i++) {
                int parentX = find(costs[i][0], parent);
                int parentY = find(costs[i][1], parent);
                if (parentX != parentY) {
                    answer += costs[i][2];
                    union(parentX, parentY, parent);
                }
            }

            return answer;
        }

        private int find(int x, int[] parent) {
            if (x == parent[x]) {
                return x;
            }

            return find(parent[x], parent);
        }

        private void union(int parentX, int parentY, int[] parent) {
            parent[parentY] = parentX;
        }

        private int[] getParent(int n) {
            int[] parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            return parent;
        }
    }
}
