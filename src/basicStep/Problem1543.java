package basicStep;

import java.io.*;

public class Problem1543 { // 문서 검색
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();
        int strLen = str.length();
        String cp = in.readLine();
        int cpLen = cp.length();

        int cnt = 0;
        int result = 0;

        while (cpLen <= strLen && cnt + cpLen <= strLen) {
            String sub = str.substring(cnt, cnt + cpLen);
            if (sub.equals(cp)) {
                cnt += cpLen;
                result++;
            } else {
                cnt++;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
