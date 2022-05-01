package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11055 { // 가장 큰 증가 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(max < dp[j] && arr[i] > arr[j]){
                    max = dp[j];
                }
            }
            dp[i] = max + arr[i];
            maxValue = Math.max(maxValue, dp[i]);
        }


        out.write(String.valueOf(maxValue));
        out.flush();
        out.close();
    }
}
