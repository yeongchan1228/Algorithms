package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem3067 { // Coins
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        StringBuilder answer = new StringBuilder();
        while (N --> 0) {
            int cnt = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            int money = Integer.parseInt(in.readLine());
            int[] coins = new int[cnt + 1];
            for (int i = 0; i < cnt; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[money + 1];

            dp[0] = 1;
            for (int i = 0; i < cnt; i++) {
                for (int j = coins[i]; j <= money; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            answer.append(dp[money] + "\n");
        }

        out.write(answer.toString());
        out.flush();
        out.close();
    }
}
