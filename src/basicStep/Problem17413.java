package basicStep;

import java.io.*;
import java.util.Stack;

public class Problem17413 { // 단어 뒤집기 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();

        StringBuilder result = new StringBuilder();
        boolean check = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '<'){
                check = true;

                print(result, sb);
                sb = new StringBuilder();
                result.append("<");
            }else if(ch == '>'){
                check = false;
                result.append(">");
            }else{
                if(!check){
                    if(ch == ' ') {
                        print(result, sb);
                        sb = new StringBuilder();
                        result.append(" ");
                    }
                    else sb.append(ch);
                }else{
                    result.append(ch);
                }
            }
        }

        if(sb.length() != 0) print(result, sb);

        out.write(result.toString());
        out.flush();
        out.close();
    }

    private static void print(StringBuilder result, StringBuilder sb) {
        result.append(sb.reverse());
    }
}
