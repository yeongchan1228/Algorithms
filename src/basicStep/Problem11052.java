package basicStep;

import java.io.*;

public class Problem11052 { // 카드 구매하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cardNum = Integer.parseInt(in.readLine());

        int[] pay = new int[cardNum + 1];
        String[] str = in.readLine().split(" ");
        for (int i = 1; i <= cardNum; i++) {
            pay[i] = Integer.parseInt(str[i - 1]);
        }

        int[] dp = new int[cardNum + 1];
        dp[0] = 0;
        dp[1] = pay[1];

        for (int i = 2; i <= cardNum; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + pay[j]);
            }
        }

        out.write(String.valueOf(dp[cardNum]));
        out.flush();
        out.close();
    }
}
