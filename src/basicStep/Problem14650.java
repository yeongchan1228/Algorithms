package basicStep;

import java.io.*;

/**
 * Created by YC on 2022/09/26.
 */
public class Problem14650 { // 걷다보니 신천역 삼

    static int n, result = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());

        calc(0, 0);

        out.write(String.valueOf(String.valueOf(result)));
        out.flush();
        out.close();
    }

    public static void calc(int depth, int sum) {
        if (depth == n) {
            if (sum % 3 == 0) {
                result++;
            }
            return;
        }

        for(int i = 0; i < 3; i++) {
            if (depth == 0 && i == 0) {
                continue;
            }

            calc(depth + 1, sum + i);
        }
    }
}
