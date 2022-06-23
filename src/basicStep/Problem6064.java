package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem6064 { // 카잉 달력
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(in.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean isCheck = false;
            for (int j = x; j <= N * M; j += M) {
                if((j - y) % N == 0){
                    sb.append(j + "\n");
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck) sb.append("-1" + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

}
