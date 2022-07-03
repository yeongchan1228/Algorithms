package middleStep;

import java.io.*;
import java.util.Stack;

public class Problem1918 { // 후위 표기식
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();
        Stack<Character> operators = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && priority(ch) <= priority(operators.peek())) {
                    sb.append(operators.pop());
                }
                operators.push(ch);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    sb.append(operators.pop());
                }
                operators.pop();
            } else {
                sb.append(ch);
            }
        }

        while (!operators.isEmpty()) {
            sb.append(operators.pop());
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static int priority(char ch) {
        if (ch == '(') return 0;
        else if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;

        return -1;
    }
}
