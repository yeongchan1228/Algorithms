package middleStep;

import java.io.*;

public class Problem12919 { // A와 B (2)

    static String A, B;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        A = in.readLine();
        B = in.readLine();

        calc(B.length(), B);

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void calc(int depth, String str){
        if(result == 1) return;
        if(depth == A.length()){
            if(str.equals(A)) result = 1;
            return;
        }

        if(str.charAt(str.length() - 1) == 'A') calc(depth - 1, str.substring(0, str.length() - 1));
        if(str.charAt(0) == 'B') calc(depth - 1, new StringBuilder(str.substring(1)).reverse().toString());
    }
}
