package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10773 { // 제로
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(in.readLine());

            if(!stack.isEmpty() && num == 0)
                stack.pop();
            else if(num != 0)
                stack.push(num);
        }

        int result = 0;
        while (!stack.isEmpty()) {
            Integer value = stack.pop();

            result += value;
        }

        System.out.println(result);
    }
}
