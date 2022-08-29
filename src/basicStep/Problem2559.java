package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2559 { // 수열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        int[] ints = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

//        int len = n - k;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < len; i++, k++) {
//            int sum = 0;
//            for (int j = i; j <= k; j++) {
//                sum += ints[j];
//            }
//            max = Math.max(max, sum);
//        }

        int sum = 0, start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += ints[i];
            if (i >= k) {
                max = Math.max(max, sum);
                sum -= ints[start++];
            }
        }

        System.out.println(max);

    }
}
