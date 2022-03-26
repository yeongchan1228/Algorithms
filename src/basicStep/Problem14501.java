package basicStep;

import java.io.*;
import java.util.Arrays;

public class Problem14501 { // 퇴사
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] day = new int[N];
        int[] money = new int[N];
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            String[] s = in.readLine().split(" ");
            day[i] = Integer.parseInt(s[0]);
            money[i] = Integer.parseInt(s[1]);
        }

        for (int i = 0; i < N; i++) {
            int calcDay = i + day[i];
            if (calcDay < N + 1) {
                dp[calcDay] = Math.max(dp[calcDay], dp[i] + money[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        out.write(String.valueOf(dp[N]));
        out.flush();
        out.close();
    }
}
