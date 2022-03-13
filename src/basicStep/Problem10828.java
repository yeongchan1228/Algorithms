package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10828 { // 스택
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] str = in.readLine().split(" ");
            switch (str[0]) {
                case "push":
                    stack.push(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    if(!stack.isEmpty()){
                        System.out.println(stack.pop());
                    }else{
                        System.out.println("-1");
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(!stack.isEmpty()){
                        System.out.println("0");
                    }else{
                        System.out.println("1");
                    }
                    break;
                case "top":
                    if(!stack.isEmpty()){
                        System.out.println(stack.peek());
                    }else{
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
