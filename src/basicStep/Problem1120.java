package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1120 { // 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if(B.charAt(j + i) != A.charAt(j)) cnt++;
            }
            result = Math.min(result, cnt);
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

}
