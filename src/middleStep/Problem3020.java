package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem3020 { // 개똥벌레
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] up = new int[h + 1];
        int[] down = new int[h + 1];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(in.readLine());
            if (i % 2 == 0) {
                up[val]++;
                continue;
            }

            down[h - val + 1]++;
        }

        for (int i = h - 1; i > 0; i--) {
            up[i] += up[i + 1];
        }

        for (int i = 1; i <= h; i++) {
            down[i] += down[i - 1];
        }

        int cnt = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= h; i++) {
            int val = up[i] + down[i];

            if (val < min) {
                cnt = 1;
                min = val;
            } else if (val == min) {
                cnt++;
            }
        }

        out.write(min + " " + cnt);
        out.flush();
        in.close();
        out.close();
    }
}
