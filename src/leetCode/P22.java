package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P22 { // Generate Parentheses
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        calc(n, 0, 0, "", answer);
        return answer;
    }

    private static void calc(int n, int open, int close, String str, List<String> answer) {
        if (open == n && close == n) {
            answer.add(str);
            return;
        }

        if (open < n) {
            calc(n, open + 1, close, str + "(", answer);
        }

        if (close < open) {
            calc(n, open, close + 1, str + ")", answer);
        }
    }
}
