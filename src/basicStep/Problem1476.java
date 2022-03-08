package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1476 { // 날짜 계산
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 1 <= E <= 15
         * 1 <= S <= 28
         * 1 <= M <= 19
         */

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

        int E = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int e = 0;
        int s = 0;
        int m = 0;

        for (int i = 1; true; i++) {
            e = i % 15;
            if(e == 0) e = 15;
            s = i % 28;
            if(s == 0) s = 28;
            m = i % 19;
            if(m == 0) m = 19;

            if(E == e && s == S && m == M){
                System.out.println(i);
                break;
            }
        }
    }
}
