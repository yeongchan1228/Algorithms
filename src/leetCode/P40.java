package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40 { // Combination Sum II
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        for (List<Integer> answer : combinationSum2(candidates, target)) {
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(0, target, new ArrayList<Integer>(), candidates, answer);
        return answer;
    }

    private static void dfs(int start, int target, List<Integer> temp, int[] candidates, List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (target - candidates[i] < 0) {
                break;
            }

            temp.add(candidates[i]);
            dfs(i + 1, target - candidates[i], temp, candidates, answer);
            temp.remove(temp.size() - 1);
        }
    }
}
