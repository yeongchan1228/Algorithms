package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem12738 { // 가장 긴 증가하는 부분 수열 3
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());

        int count = 0;
        dp[count] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value > dp[count]){
                count++;
                dp[count] = value;
            }else{
                int left = 0;
                int right = count;
                int mid = 0;
                while (left < right){
                    mid = (left + right) / 2;
                    if(dp[mid] < value) left = mid + 1;
                    else right = mid;
                }
                dp[right] = value;
            }
        }

        out.write(String.valueOf(count + 1));
        out.flush();
        out.close();
    }
}
