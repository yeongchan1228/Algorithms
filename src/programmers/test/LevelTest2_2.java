package programmers.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LevelTest2_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        if(isTrue(str)) System.out.println(str);
        else System.out.println(getAnswer(str));
    }

    private static String getAnswer(String p) {
        if(p.length() == 0) return p;

        String u = "";
        String v = "";
        int open = 0;
        int close = 0;

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if(ch == '(') open++;
            else close++;

            if(open == close) {
                u += p.substring(0, i + 1);
                v += p.substring(i + 1);
                break;
            }
        }

        boolean aTrue = isTrue(u);
        if(aTrue) {
            return u + getAnswer(v);
        }

        String answer = "(" + getAnswer(v) + ")";
        StringBuilder sb = new StringBuilder();
        u = u.substring(1, u.length() - 1);

        for (int i = 0; i < u.length(); i++) {
            char ch = u.charAt(i);
            if(ch == '(') sb.append(')');
            else sb.append('(');
        }

        return answer += sb.toString();
    }

    private static boolean isTrue(String p) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if(ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }
}
