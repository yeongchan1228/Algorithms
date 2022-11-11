package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1783 { // 병든 나이트
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 1;
        if (n == 2) {
            int val = (m + 1) / 2;
            result = val > 4 ? 4 : val;
        } else if (n > 2) {
            if (m < 7) {
                result = m > 4 ? 4 : m;
            } else {
                result = m - 2;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
