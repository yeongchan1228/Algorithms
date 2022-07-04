package middleStep;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem17298 { // 오큰수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());

        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int val = result[i];
            if(stack.isEmpty()) stack.push(i);
            else if(val <= result[stack.peek()]) stack.push(i);
            else if(val > result[stack.peek()]) {
                while (!stack.isEmpty() && val > result[stack.peek()]) result[stack.pop()] = val;
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) result[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int val : result) sb.append(val + " ");

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
