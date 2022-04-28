package middleStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem12904 { // A와 B

    static StringBuilder A, B, sb;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        A = new StringBuilder(in.readLine());
        B = new StringBuilder(in.readLine());

        while (B.length() > A.length()){
            int lastIndex = B.length() - 1;
            if(B.charAt(lastIndex) == 'A') B.deleteCharAt(lastIndex);
            else if(B.charAt(lastIndex) == 'B'){
                B.deleteCharAt(lastIndex);
                B.reverse();
            }
        }

        if(B.compareTo(A) == 0) result = 1;

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

}
