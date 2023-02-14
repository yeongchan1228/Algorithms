package basicStep;

import java.io.*;

public class Problem2635 { // 수 이어가기
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        int n = Integer.parseInt(in.readLine());
        String list = null;
        for (int i = n / 2; i <= n; i++) {
            sb.append(n + " ");
            sb.append(i + " ");
            int cnt = calc(n, i) + 2;
            if (cnt >= answer) {
                list = sb.toString().trim();
                sb.setLength(0);
                answer = cnt;
                continue;
            }
            break;
        }

        out.write(answer + "\n" + list);
        out.flush();
        in.close();
        out.close();
    }

    private static int calc(int a, int b) {
        int c = a - b;
        if (c < 0) {
            return 0;
        }
        sb.append(c + " ");
        return calc(b, c) + 1;
    }
}
