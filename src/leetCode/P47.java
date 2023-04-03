package leetCode;

import java.util.*;

public class P47 { // Permutations II
    private static boolean[] visited;
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        for (List<Integer> list : permuteUnique(nums)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        visited = new boolean[nums.length];

        dfs(0, nums, new int[nums.length], answer);
        return new ArrayList<>(answer);
    }

    private static void dfs(int depth, int[] nums, int[] selected, Set<List<Integer>> answer) {
        if (depth == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < selected.length; i++) {
                list.add(selected[i]);
            }
            answer.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = nums[i];
                dfs(depth + 1, nums, selected, answer);
                visited[i] = false;
            }
        }
    }
}
