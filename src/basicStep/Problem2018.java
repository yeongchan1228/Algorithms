package basicStep;

import java.io.*;

public class Problem2018 { // 수들의 합 5
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        int end = 2;
        int start = 1;
        int sum = start + end;
        int result = 1;
        while (start < end && end < n) {
            if (sum >= n) {
                if (sum == n) {
                    result++;
                }
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
