package basicStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/10/05.
 */
public class Problem2961 { // 도영이가 만든 맛있는 음식

    static int n;
    static int[] sours, bitters;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());
        sours = new int[n];
        bitters = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            sours[i] = Integer.parseInt(st.nextToken());
            bitters[i] = Integer.parseInt(st.nextToken());
        }

        calc(0, 0, 1, 0);

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void calc(int depth, int inputCnt, int sourSum, int bitterSum) {
        if (depth == n) {
            int val = bitterSum - sourSum;
            if (inputCnt != 0) {
                result = Math.min(result, Math.abs(val));
            }
            return;
        }

        calc(depth + 1, inputCnt, sourSum, bitterSum);
        calc(depth + 1, inputCnt + 1, sourSum * sours[depth], bitterSum + bitters[depth]);
    }
}
