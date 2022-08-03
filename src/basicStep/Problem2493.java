package basicStep;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2493 { // 탑
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        Stack<Top> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 0; i < cnt; i++) {
            int topLen = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().len < topLen) {
                    stack.pop();
            }

            if (stack.isEmpty()) {
                result.append(0 + " ");
            } else {
                result.append(stack.peek().idx + " ");
            }

            stack.push(new Top(topLen, i + 1));
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }

    static class Top {
        int len ;
        int idx;

        public Top(int len, int idx) {
            this.len = len;
            this.idx = idx;
        }
    }
}
