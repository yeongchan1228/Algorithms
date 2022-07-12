package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2960 { // 에라스테네스의 체
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0, result = -1;
        boolean[] arr = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if(result != -1) break;

            for (int j = i; j <= N; j += i) {
                if(arr[j]) continue;

                cnt++;
                arr[j] = true;
                if(cnt == K) result = j;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
