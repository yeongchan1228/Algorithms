package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2805 { // 나무 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = Arrays.stream(trees).max().getAsInt();
        while (min < max) {
            long sum = 0;
            int mid = (max + min) / 2;

            for (int i = 0; i < n; i++) {
                int cutLen = trees[i] - mid;

                if (cutLen > 0) {
                    sum += cutLen;
                }
            }


            if (m > sum) {
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
