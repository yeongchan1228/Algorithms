package middleStep;

import java.io.*;

public class Problem2749 { // 피보나치 수 3
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(in.readLine());
        int pisano = 100000 * 15; // 피사노 주기
        long[] arr = new long[pisano];
        arr[0] = 0;
        arr[1] = 1;
        if(N > pisano){
            N %= pisano;
        }

        if(N < 2){
            print(out, arr, (int) N);
            return;
        }else {
            for (int i = 2; i < pisano; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;
                if (i == N) {
                    print(out, arr, (int) N);
                    return;
                }
            }
        }
    }

    private static void print(BufferedWriter out, long[] arr, int N) throws IOException {
        out.write(String.valueOf(arr[N]));
        out.flush();
        out.close();
    }
}
