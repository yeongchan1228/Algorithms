package basicStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/18.
 */
public class Problem2004 { // 조합 0의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long twoCount = calc(2, n) - calc(2, m) - calc(2, n - m);
        long fiveCount = calc(5, n) - calc(5, m) - calc(5, n - m);

        out.write(String.valueOf(Math.min(twoCount, fiveCount)));
        out.flush();
        out.close();
    }

    static long calc(int n, long num) {
        long val = 0;
        for (long i = n; i <= num; i *= n) {
            val += num / i;
        }

        return val;
    }
}
