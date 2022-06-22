package basicStep;

import java.io.*;
import java.util.Stack;

public class Problem4949 { // 균형잡힌 세상
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true){
            String str = in.readLine();
            if(str.equals(".")) break;

            sb.append(calc(str) + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static String calc(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '['){
                stack.push(str.charAt(i));
            }else if(str.charAt(i) == ')'){
                if(stack.isEmpty() || stack.pop() != '(') {
                    return "no";
                }
            }else if(str.charAt(i) == ']'){
                if(stack.isEmpty() || stack.pop() != '[') {
                    return "no";
                }
            }
        }

        if(stack.isEmpty()) return "yes";
        else return "no";
    }
}
