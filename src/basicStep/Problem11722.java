package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11722 { // 가장 긴 감소하는 수열
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(in.readLine());
//        int[] arr = new int[N];
//        int[] dp = new int[N];
//
//        StringTokenizer st = new StringTokenizer(in.readLine());
//        for (int i = 0; st.hasMoreTokens(); i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        dp[0] = 1;
//        for (int i = 1; i < N; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if(dp[j] + 1 > dp[i] && arr[i] < arr[j]){
//                    dp[i] = dp[j] + 1;
//                }
//            }
//        }
//
//        out.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));
//        out.flush();
//        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j] && value < dp[j]){
                    value = dp[j];
                }
            }
            dp[i] = value + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }

        out.write(String.valueOf(maxLength));
        out.flush();
        out.close();
    }
}
