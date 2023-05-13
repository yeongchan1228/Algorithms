package leetCode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P139 { // Word Break
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> cached = new LinkedHashMap<>();
        return solve(s, wordDict, cached);
    }

    private static boolean solve(String target, List<String> wordDict, Map<String, Boolean> cached) {
        if (cached.containsKey(target)) {
            return cached.get(target);
        }

        if (target.length() == 0) {
            return true;
        }

        for (String word : wordDict) {
            if (target.startsWith(word) && solve(target.substring(word.length()), wordDict, cached)) {
                cached.put(target, true);
                return true;
            }
        }

        cached.put(target, false);
        return false;
    }
}
