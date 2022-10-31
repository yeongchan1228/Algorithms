package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1049 { // 기타줄

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int PACKAGE_CNT = 6;

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minPriceSet = Integer.MAX_VALUE;
        int minPriceOnce = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            minPriceSet = Math.min(minPriceSet, Integer.parseInt(st.nextToken()));
            minPriceOnce = Math.min(minPriceOnce, Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        if (minPriceSet > minPriceOnce * PACKAGE_CNT) {
            result = minPriceOnce * n;
        } else {
            int d = n / PACKAGE_CNT;
            int r = n % PACKAGE_CNT;

            result = (d * minPriceSet) + (r * minPriceOnce);
            if (r > 0) {
                result = Math.min(result, (d + 1) * minPriceSet);
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

}