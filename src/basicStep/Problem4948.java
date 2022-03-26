package basicStep;

import java.io.*;
import java.util.Arrays;

public class Problem4948 { // 베르트랑 공주
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int result;

        while (true) {
            result = 0;
            int N = Integer.parseInt(in.readLine());
            boolean[] check = new boolean[2 * N + 1];

            if (N == 0) {
                break;
            }
            check[0] = check[1] = true;
            int sqrt = (int) Math.sqrt(2 * N);
            for (int i = 2; i <= sqrt; i++) {
                if (!check[i]) {
                    check[i] = true;
                    for (int j = i * i; j <= 2 * N; j += i) {
                        check[j] = true;
                    }
                }
            }
            for (int i = N + 1; i <= 2 * N; i++) {
                if (!check[i]) {
                    result++;
                }
            }
            sb.append(result).append('\n');
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}