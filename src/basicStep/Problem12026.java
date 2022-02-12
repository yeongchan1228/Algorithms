package basicStep;

import java.util.Scanner;

public class Problem12026 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        char[] map = new char[N];
        long[] dp = new long[N];

        String str = in.next();
        for(int i = 0; i < N; i++){
            map[i] = str.charAt(i);
        }

        dp[0] = 0;
        for(int i = 1; i < N; i++){
            dp[i] = Long.MAX_VALUE;
        }

        long cnt = Long.MAX_VALUE;
        int num = -1;

        for(int i = 0; i < N; i++){
            char p = map[i];
            if(i == N - 1)
                 break;

            if(dp[i] == Long.MAX_VALUE)
                continue;

            if(p == 'B'){
                for(int j = i+1; j < N; j++){
                    char m = map[j];
                    if(m == 'O'){
                        cnt = j - i;
                        dp[j] = Math.min(dp[j], dp[i] + cnt*cnt);
                    }
                }
                cnt = 0;
            }
            else if(p == 'O'){
                for(int j = i+1; j < N; j++){
                    char m = map[j];
                    if(m == 'J'){
                        cnt = j - i;
                        dp[j] = Math.min(dp[j], dp[i] + cnt*cnt);
                    }
                }
                cnt = 0;
            }
            else if (p == 'J') {
                for(int j = i+1; j < N; j++){
                    char m = map[j];
                    if(m == 'B'){
                        cnt = j - i;
                        dp[j] = Math.min(dp[j], dp[i] + cnt*cnt);
                    }
                }
                cnt = 0;
            }
        }

        if(dp[N-1] == Long.MAX_VALUE)
            System.out.print("-1");
        else
            System.out.print(dp[N-1]);

    }
}
