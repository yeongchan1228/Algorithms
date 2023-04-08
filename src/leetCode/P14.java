package leetCode;

public class P14 { // Longest Common Prefix
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();

        boolean isContinue = true;
        for (int i = 0; i < strs[0].length() && isContinue; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || ch != strs[j].charAt(i)) {
                    isContinue = false;
                    break;
                }
            }

            if (isContinue) {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}
