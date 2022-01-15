package basicStep;

import java.util.Scanner;
import java.util.Stack;

public class Problem2504 { // 괄호의 값
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tmp = 1;
        int result = 0;
        String str = in.next();
        Stack<Character> stk = new Stack<>();


        for(int i = 0; i < str.length(); i++){

            if(str.charAt(i) == '('){
                tmp *= 2;
                stk.push('(');
                System.out.println("실행됨");
            }
            else if(str.charAt(i) == '['){
                tmp *= 3;
                stk.push('[');
            }
            else if(str.charAt(i) == ')'){
                if(stk.isEmpty() || stk.peek() != '('){
                    result = 0;
                    break;
                }

                if(str.charAt(i - 1) == '('){
                    result += tmp;
                }
                stk.pop();
                tmp /= 2;
            }
            else if(str.charAt(i) == ']'){
                if(stk.isEmpty() || stk.peek() != '['){
                    result = 0;
                    break;
                }

                if(str.charAt(i - 1) == '['){
                    result += tmp;
                }
                stk.pop();
                tmp /= 3;
            }
        }
        System.out.print(!stk.isEmpty() ? 0 : result);
    }
}
