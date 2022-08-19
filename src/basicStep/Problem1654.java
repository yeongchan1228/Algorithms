package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1654 { // 랜선 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lens = new int[k];
        for (int i = 0; i < k; i++) {
            lens[i] = Integer.parseInt(in.readLine());

        }

        long min = 0;
        long max = Arrays.stream(lens).max().getAsInt();
        max++;
        while (min < max) {
            long sum = 0;
            long mid = (min + max) / 2;

            for (int len : lens) {
                sum += (len / mid);
            }

            if (sum < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        out.write(String.valueOf(min - 1));
        out.flush();
        out.close();
    }
}
