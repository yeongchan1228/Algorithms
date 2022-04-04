package basicStep;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem2407 { // 조합
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        for (int i = 0; i < M; i++) {
            n1 = n1.multiply(new BigInteger(String.valueOf(N - i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(M - i)));
        }

        out.write(String.valueOf(n1.divide(n2)));
        out.flush();
        out.close();

    }
}
