package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11047 { // 동전 0
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(in.readLine());
        }

        int cnt = 0;

        //풀이 1
//        for (int i = 0; true; i++) {
//            if(K==0){
//                System.out.println(i);
//                break;
//            }
//
//            for (int j = N - 1; j >= 0; j--) {
//                if(K - coin[j] >= 0){
//                    K -= coin[j];
//                    break;
//                }
//            }
//        }

        //풀이 2
        for (int i = N-1; true; i--) {
            if(K == 0){
                System.out.println(cnt);
                break;
            }

            if(K - coin[i] >= 0){
                K -= coin[i];
                cnt++;
                i = N;
            }
        }

    }
}
