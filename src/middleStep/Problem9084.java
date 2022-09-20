package middleStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/20.
 */
public class Problem9084 { // 동전
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        while (n --> 0) {
            int cnt = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            int price = Integer.parseInt(in.readLine());

            int[] coins = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[price + 1];
            dp[0] = 1;
            for (int i = 0; i < cnt; i++) {
                for (int j = coins[i]; j <= price; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            result.append(dp[price] + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
