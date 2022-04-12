package basicStep;

import java.io.*;

public class Problem12852 { // 1로 만들기 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[N+1];
        int[] trace = new int[N+1];
        trace[1] = -1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            trace[i] = i - 1;

            if(i % 2 == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
                trace[i] = i / 2;
            }

            if(i % 3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
                trace[i] = i / 3;
            }
        }

        out.write(String.valueOf(dp[N]));
        out.write("\n");

        for (int i = N; i > 0;) {
            sb.append(i + " ");
            i = trace[i];
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
