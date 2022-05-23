package middleStep;

import java.io.*;

public class Problem9252 { // LCS 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str1 = in.readLine();
        String str2 = in.readLine();

        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= length2; j++) {
                if(ch1 == str2.charAt(j - 1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int result = dp[length1][length2];

        while(length1 != 0 && length2 != 0){
            if(dp[length1][length2] == dp[length1 - 1][length2]) length1--;
            else if(dp[length1][length2] == dp[length1][length2 - 1]) length2--;
            else {
                sb.insert(0, str1.charAt(length1 - 1));
                length1--;
                length2--;
            }
        }

        sb.insert(0, result + "\n");
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
