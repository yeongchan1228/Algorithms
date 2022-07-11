package basicStep;

import java.io.*;
import java.util.Stack;

public class Problem5397 { // 키로거
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();

        int N = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);

                if (ch == '<') {
                    if (!lStack.isEmpty()) rStack.push(lStack.pop());
                } else if (ch == '>') {
                    if (!rStack.isEmpty()) lStack.push(rStack.pop());
                } else if (ch == '-') {
                    if (!lStack.isEmpty()) lStack.pop();
                } else {
                    lStack.push(ch);
                }

            }

            while (!lStack.isEmpty()) {
                rStack.push(lStack.pop());
            }

            while (!rStack.isEmpty()) {
                result.append(rStack.pop());
            }
            result.append("\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
