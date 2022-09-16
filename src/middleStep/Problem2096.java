package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/16.
 */
public class Problem2096 { // 내려가기
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int row = 3;
        int n = Integer.parseInt(in.readLine());

        int[] maxDp = new int[row];
        int[] minDp = new int[row];
        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int val1 = Integer.parseInt(st.nextToken());
            int val2 = Integer.parseInt(st.nextToken());
            int val3 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = val1;
                maxDp[1] = minDp[1] = val2;
                maxDp[2] = minDp[2] = val3;
            } else {
                int prevMax = Arrays.stream(maxDp).max().getAsInt();
                int prevMin = Arrays.stream(minDp).min().getAsInt();

                maxDp[0] = val1 + Math.max(maxDp[0], maxDp[1]);
                minDp[0] = val1 + Math.min(minDp[0], minDp[1]);

                maxDp[2] = val3 + Math.max(maxDp[1], maxDp[2]);
                minDp[2] = val3 + Math.min(minDp[1], minDp[2]);

                maxDp[1] = val2 + prevMax;
                minDp[1] = val2 + prevMin;
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            max = Math.max(max, maxDp[i]);
            min = Math.min(min, minDp[i]);
        }

        out.write(max + " " + min);
        out.flush();
        out.close();
    }
}
