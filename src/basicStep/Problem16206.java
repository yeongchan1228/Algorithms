package basicStep;

import java.io.*;
import java.util.*;

public class Problem16206 { // 롤케이크
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> cakes1 = new ArrayList<>();
        List<Integer> cakes2 = new ArrayList<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            int cake = Integer.parseInt(st.nextToken());
            if (cake % 10 == 0) {
                cakes1.add(cake);
                continue;
            }

            cakes2.add(cake);
        }

        Collections.sort(cakes1);

        int answer = 0;
        for (int cake : cakes1) {
            if (cake == 10) {
                answer++;
                continue;
            }

            int cnt = cake / 10;
            int cutCnt = cnt - 1;
            if (cutCnt >= m) {
                answer += m;
                if(cake - (m * 10) == 10) {
                    answer++;
                }
                m = 0;
                break;
            }

            answer += cnt;
            m -= cutCnt;
        }

        if (m != 0) {
            for (int cake : cakes2) {
                if (cake < 10) {
                    continue;
                }

                int cnt = cake / 10;
                if (cnt >= m) {
                    answer += m;
                    break;
                }

                answer += cnt;
                m -= cnt;
            }
        }

        out.write(String.valueOf(answer));
        out.flush();
        in.close();
        out.close();
    }

}
