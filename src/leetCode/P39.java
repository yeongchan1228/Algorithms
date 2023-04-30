package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P39 { // Combination Sum
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        for (List<Integer> answer : combinationSum(candidates, target)) {
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(0, 0, 0, target, new int[20], candidates, answer);
        return answer;
    }

    private static void dfs(int depth, int start, int sum, int target, int[] selected, int[] candidates, List<List<Integer>> answer) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < depth; i++) {
                list.add(selected[i]);
            }
            answer.add(list);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            selected[depth] = candidates[i];
            dfs(depth + 1, i, sum + candidates[i], target, selected, candidates, answer);
        }
    }
}
