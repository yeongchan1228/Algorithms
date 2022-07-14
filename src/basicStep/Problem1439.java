package basicStep;

import java.io.*;

public class Problem1439 { // 뒤집기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();

        out.write(String.valueOf(Math.min(getVal(str, '0'), getVal(str, '1'))));
        out.flush();
        out.close();
    }

    private static int getVal(String str, char val) {
        int cnt = 0;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == val) {
                cnt++;
            } else {
                if(cnt > 0) {
                    num++;
                    cnt = 0;
                }
            }
        }

        if(cnt > 0) num++;

        return num;
    }
}
