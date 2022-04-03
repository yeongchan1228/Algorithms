package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1629 { // 곱셈
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        out.write(String.valueOf(calc(A, B, C)));
        out.flush();
        out.close();
    }

    static long calc(long A, long B, long C){
        if(B == 1){
            return A % C;
        }

        long size = B / 2;
        long pow = calc(A, size, C);
        if(B % 2 != 0){
            return pow * pow % C * A % C;
        }else{
            return pow * pow % C;
        }
    }
}
