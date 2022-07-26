package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1389 { // 케빈 베이컨의 6단계 법칙
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = 5001;

                if (i == j) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            dist[from][to] = dist[to][from] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dist[i][j] == 0) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int idx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;

            for (int j = 1; j <= n; j++) {
                tmp += dist[i][j];
            }

            if (tmp < min) {
                idx = i;
                min = tmp;
            }
        }

        out.write(String.valueOf(idx));
        out.flush();
        out.close();
    }
}
