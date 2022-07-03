package basicStep;

import java.io.*;
import java.util.Stack;

public class Problem1935 { // 후위 표기식 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        String str = in.readLine();

        double[] alpha = new double[N];
        for (int i = 0; i < N; i++) {
            alpha[i] = Double.parseDouble(in.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int i1 = ch - 65;
                stack.push(alpha[i1]);
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();
                switch (ch) {
                    case '*' :
                        stack.push(val2 * val1);
                        break;
                    case '/' :
                        stack.push(val2 / val1);
                        break;
                    case '+' :
                        stack.push(val2 + val1);
                        break;
                    case '-' :
                        stack.push(val2 - val1);
                        break;
                }
            }
        }

        out.write(String.format("%.2f", stack.pop()));
        out.flush();
        out.close();
    }
}
