package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P17 { // Letter Combinations of a Phone Number
    private static String[] list = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        String digits = "23";
        for (String answer : letterCombinations(digits)) {
            System.out.println(answer);
        }
        int[] nums = {1, 2, 3, 4};
        Arrays.asList(nums);
    }

    public static List<String> letterCombinations(String digits) {
        int size = digits.length();
        List<String> answer = new ArrayList<>();
        if (size == 0) {
            return answer;
        }

        dfs(0, digits, new char[size], answer);
        return answer;
    }

    private static void dfs(int depth, String digits, char[] selected, List<String> answer) {
        if (depth == digits.length()) {
            answer.add(String.valueOf(selected));
            return;
        }

        int idx = digits.charAt(depth) - '0' - 2;
        for (int i = 0; i < list[idx].length(); i++) {
            selected[depth] = list[idx].charAt(i);
            dfs(depth + 1, digits, selected, answer);
        }
    }
}
