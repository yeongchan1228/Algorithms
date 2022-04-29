package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem2565 { // 전기줄(dp)
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int line[][] = new int[N + 1][2];
        int dp[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int maxValue = 0;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if(max < dp[j] && line[i][1] > line[j][1]){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            maxValue = Math.max(maxValue, dp[i]);
        }

        out.write(String.valueOf(N - maxValue));
        out.flush();
        out.close();
    }
}
