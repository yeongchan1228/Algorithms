package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2491 { // 수열
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        int ascCnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                ascCnt = 1;
            } else {
                ascCnt++;
            }

            result = Math.max(result, ascCnt);
        }

        int descCnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                descCnt = 1;
            } else {
                descCnt++;
            }

            result = Math.max(result, descCnt);
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
