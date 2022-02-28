package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11726 { // 2xn 타일링
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int[] dp = new int[N + 1];

        for(int i = 0; i < dp.length; i++){
            if(i == 3){
                break;
            }
            dp[i] = i;
        }

        for(int i = 3; i <= N; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N]);
        
    }
}
