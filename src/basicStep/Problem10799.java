package basicStep;

import java.io.*;
import java.util.Stack;

public class Problem10799 { // 쇠 막대기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = in.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        boolean isTrue = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                if (!isTrue) isTrue = true;
                stack.add('(');
                continue;
            }
            stack.pop();
            if (isTrue) {
                result += stack.size();
                isTrue = false;
            }
            else {
                result += 1;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
