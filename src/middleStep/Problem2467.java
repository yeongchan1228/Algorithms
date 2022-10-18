package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2467 { // 용액
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = n - 1, min = Integer.MAX_VALUE;
        int resultA = 0, resultB = 0;
        while (start < end) {
            int val = arr[start] + arr[end];
            int absVal = Math.abs(val);

            if (val == 0) {
                resultA = arr[start];
                resultB = arr[end];
                break;
            }
            else if (min > absVal) {
                min = absVal;
                resultA = arr[start];
                resultB = arr[end];
            } else if (val >= 0) {
                end--;
            } else {
                start++;
            }
        }

        out.write(String.format("%d %d", resultA, resultB));
        out.flush();
        out.close();
    }
}
