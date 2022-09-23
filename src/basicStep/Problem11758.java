package basicStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/23.
 */
public class Problem11758 { // CCW
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int size = 3;
        int[] points1 = new int[size];
        int[] points2 = new int[size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            points1[i] = Integer.parseInt(st.nextToken());
            points2[i] = Integer.parseInt(st.nextToken());
        }

        out.write(String.valueOf(calc(points1, points2)));
        out.flush();
        out.close();
    }

    private static int calc(int[] points1, int[] points2) {
        int result = (points1[0] * points2[1] + points1[1] * points2[2] + points1[2] * points2[0])
                - (points1[1] * points2[0] + points1[2] * points2[1] + points1[0] * points2[2]);

        if (result > 0) {
            result = 1;
        } else if (result < 0) {
            result = -1;
        }

        return result;
    }
}
