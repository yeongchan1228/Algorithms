package leetCode;

public class P5 { // Longest Palindromic Substring
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1 && chars[i] == chars[j]) {
                    dp[i][j] = true;
                } else {
                    if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
