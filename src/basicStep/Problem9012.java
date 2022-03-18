package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem9012 { // 괄호
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        boolean isTrue = false;

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            stack = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if(ch == ')'){
                    if(stack.isEmpty()) {
                        sb.append("NO").append('\n');
                        isTrue = true;
                        break;
                    }
                    else if(stack.peek() == '('){
                        stack.pop();
                    }else {
                        stack.push(ch);
                    }
                }else
                    stack.push(ch);
            }

            if(stack.isEmpty() && !isTrue){
                sb.append("YES").append('\n');
            }else if(!stack.isEmpty() && !isTrue){
                sb.append("NO").append('\n');
            }
            isTrue = false;
        }

        System.out.println(sb);
    }
}
