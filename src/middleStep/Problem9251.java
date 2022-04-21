package middleStep;

import java.io.*;

public class Problem9251 { // LCS
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = in.readLine();
        String B = in.readLine();
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        out.write(String.valueOf(dp[A.length()][B.length()]));
        out.flush();
        out.close();
    }
}
