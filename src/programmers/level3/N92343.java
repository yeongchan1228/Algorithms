package programmers.level3;

import java.util.ArrayList;

public class N92343 { // 양과 늑대
    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        System.out.println(new Solution().solution(info, edges));
    }

    static class Solution {
        private static int maxSheepCnt = 0;
        private static ArrayList<ArrayList<Integer>> list;

        public int solution(int[] info, int[][] edges) {
            list = new ArrayList<>();
            for (int i = 0; i <= info.length; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < edges.length; i++) {
                list.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> nextNodeList = new ArrayList<>();
            nextNodeList.add(0);
            dfs(0, 0, 0, info, nextNodeList);

            return maxSheepCnt;
        }

        private void dfs(int idx, int sheepCnt, int wolfCnt, int[] info, ArrayList<Integer> nextNodeList) {
            sheepCnt += info[idx] ^ 1;
            wolfCnt += info[idx];

            if (sheepCnt <= wolfCnt) {
                return;
            }

            maxSheepCnt = Math.max(maxSheepCnt, sheepCnt);

            ArrayList<Integer> copied = new ArrayList<>();
            copied.addAll(nextNodeList);
            copied.addAll(list.get(idx));
            copied.remove(Integer.valueOf(idx));

            for (int nextIdx : copied) {
                dfs(nextIdx, sheepCnt, wolfCnt, info, copied);
            }
        }
    }
}
