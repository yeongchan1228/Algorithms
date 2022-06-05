package basicStep;

import java.io.*;
import java.util.Stack;

public class Problem1406 { // 에디터
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

//        StringBuilder sb = new StringBuilder(in.readLine());

        Stack<Character> Lst = new Stack<>();
        Stack<Character> Rst = new Stack<>();
        String str = in.readLine();
        for (int i = 0; i < str.length(); i++) {
            Lst.push(str.charAt(i));
        }

        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            String cmd = in.readLine();
            if(cmd.charAt(0) =='P'){
                Lst.push(cmd.charAt(2));
            }else if(cmd.charAt(0) =='L'){
                if(!Lst.isEmpty()) Rst.push(Lst.pop());
            }else if(cmd.charAt(0) =='D'){
                if(!Rst.isEmpty()) Lst.push(Rst.pop());
            }else if(cmd.charAt(0) =='B'){
                if(!Lst.isEmpty()) Lst.pop();
            }
        }
        // 시간 초과...
//        int cursor = sb.length();
//        StringTokenizer st;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(in.readLine());
//            String cmd = st.nextToken();
//
//            if(cmd.equals("P")){
//
//                sb.insert(cursor, st.nextToken());
//                cursor++;
//
//            }else if(cmd.equals("L")){
//                if(cursor != 0) cursor -= 1;
//            }else if(cmd.equals("D")){
//                if(cursor != sb.length()) cursor += 1;
//            }else if(cmd.equals("B")){
//                if(cursor != 0) {
//                    sb.deleteCharAt(cursor - 1);
//                    cursor -= 1;
//                }
//            }
//        }
//
        while (!Lst.isEmpty()) Rst.push(Lst.pop());
        StringBuilder sb = new StringBuilder();

        while (!Rst.isEmpty()) sb.append(Rst.pop());
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
