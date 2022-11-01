package basicStep;

import java.io.*;

public class Problem5555 { // 반지
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] pattern = in.readLine().toCharArray();

        int result = 0;
        int cnt = Integer.parseInt(in.readLine());
        while (cnt --> 0) {
            char[] chars = in.readLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                boolean isFail = false;
                for (int j = 0; j < pattern.length; j++) {
                    if (chars[(i + j) % chars.length] != pattern[j]) {
                        isFail = true;
                        break;
                    }
                }

                if (!isFail) {
                    result++;
                    i += (pattern.length - 1);
                    break;
                }
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
