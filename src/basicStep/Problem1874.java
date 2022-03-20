package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1874 { // 스택 수열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(in.readLine());

        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(in.readLine());
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            stack.push(i);
            sb.append("+").append('\n');
            while (true) {
                if (!stack.isEmpty() && stack.peek() == num[cnt]) {
                    cnt++;
                    stack.pop();
                    sb.append("-").append('\n');
                }else {
                    break;
                }
            }
        }

        if(!stack.isEmpty()){
            sb.setLength(0);
            sb.append("NO");
        }

        System.out.println(sb);
    }
}
