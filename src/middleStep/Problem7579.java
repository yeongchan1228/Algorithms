package middleStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/10/04.
 */
public class Problem7579 { // 앱
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int MAX = 10001;

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][MAX];
        App[] apps = new App[n];
        StringTokenizer bytes = new StringTokenizer(in.readLine());
        StringTokenizer costs = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            apps[i] = new App(Integer.parseInt(bytes.nextToken()), Integer.parseInt(costs.nextToken()));
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int memory = apps[i].memory;
            int cost = apps[i].cost;

            for (int j = 0; j < MAX; j++) {
                if (i == 0) {
                    if (cost <= j) {
                        dp[i][j] = memory;
                    }
                } else {
                    if (cost <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                if (m <= dp[i][j]) {
                    result = Math.min(result, j);
                }
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static class App {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }
}
