package middleStep;

import java.io.*;
import java.util.Arrays;

public class Problem11444 { // 피보나치 수 6

    static long mod = 1000000007L;
    static long N = 0L;
    static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(in.readLine());
        long[][] A = {{1, 1}, {1, 0}};

        out.write(String.valueOf(fibo(A, N - 1)[0][0]));
        out.flush();
        out.close();
    }

    static long[][] fibo(long[][] A, long N){
        if(N == 0 || N == 1) return A;

        long[][] tmp = fibo(A, N / 2);

        tmp = muti(tmp, tmp);

        if(N % 2 == 1L){
            tmp = muti(tmp, origin);
        }

        return tmp;
    }

    static long[][] muti(long[][] o1, long[][] o2){
        long tmp[][] = new long[2][2];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    tmp[i][j] += o1[i][k] * o2[k][j];
                    tmp[i][j] %= mod;
                }
            }
        }

        return tmp;
    }
}
