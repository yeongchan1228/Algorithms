package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1072 { // 게임
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = getPc(x, y);

        int result = -1;
        int left = 0;
        int right = 1000000000;

        while (left <= right) {
            if(z > 98) break;

            int mid = (left + right) / 2;
            if(getPc(x + mid, y + mid) == z) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static int getPc(int x, int y) {
        return (int) (100 * (long) y / x);
    }
}
