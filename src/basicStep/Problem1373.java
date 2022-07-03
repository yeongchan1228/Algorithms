package basicStep;

import java.io.*;

public class Problem1373 { // 2진수 8진수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

//        System.out.println(Integer.toOctalString(Integer.parseInt(in.readLine(), 2)));
        String str = in.readLine();
        StringBuilder sb = new StringBuilder();
        int val = str.length() % 3;
        if(val == 1) sb.append(str.charAt(0));
        else if (val == 2) sb.append((str.charAt(0) - '0') * 2 + (str.charAt(1) - '0'));

        for (int i = val; i < str.length(); i+=3) {
           sb.append((str.charAt(i) - '0') * 4 + (str.charAt(i+1) - '0') * 2 + (str.charAt(i+2) - '0'));
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
