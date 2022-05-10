package middleStep;

import java.io.*;
import java.util.*;

public class Problem14002 { // 가장 긴 증가하는 부분 수열 4
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 1;
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        int save = maxLen;
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if(dp[i] == save){
                stack.push(arr[i]);
                save--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLen + "\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
