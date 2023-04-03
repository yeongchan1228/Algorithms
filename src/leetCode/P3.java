package leetCode;

import java.util.HashSet;
import java.util.Set;

public class P3 { // Longest Substring Without Repeating Characters
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();

        int answer = 0;
        int startIdx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                while (set.contains(chars[i])) {
                    set.remove(chars[startIdx++]);
                }
            }

            set.add(chars[i]);
            answer = Math.max(answer, i - startIdx + 1);
        }

        return answer;
    }
}
