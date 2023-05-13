package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P131 { // Palindrome Partitioning
    public static void main(String[] args) {
        String s = "aab";
        for (List<String> answer : partition(s)) {
            System.out.println(answer);
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        solve(0, s, new ArrayList<String>(), answer);
        return answer;
    }

    private static void solve(int start, String s, List<String> temp, List<List<String>> answer) {
        if (start == s.length()) {
            answer.add(new ArrayList(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(start, i, s.toCharArray())) {
                temp.add(s.substring(start, i + 1));
                solve(i + 1, s, temp, answer);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(int left, int right, char[] chars) {
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }

        return true;
    }
}
