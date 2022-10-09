package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/10/09.
 */
public class Problem12101 { // 1, 2,3 더하기 2

    static int n, k, cnt = 0;
    static int[] save;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        save = new int[n];

        calc(0, 0);

        System.out.println("-1");
    }


    static void calc(int depth, int len) {
        if (depth > n) return;

        if (depth == n) {
            cnt++;
            if (cnt == k) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < len - 1; i++) {
                    result.append(save[i] + "+");
                }
                result.append(save[len - 1]);
                System.out.println(result.toString());
                System.exit(0);
            }

            return;
        }

        for (int i = 1; i <= 3; i++) {
            save[len] = i;
            calc(depth + i, len + 1);
        }
    }
}
