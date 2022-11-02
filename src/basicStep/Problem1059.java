package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1059 { // 좋은 구간
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        boolean flag = false;
        Integer[] integers = new Integer[cnt];
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < cnt; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val == n) {
                flag = true;
                break;
            }

            integers[i] = val;
        }

        int result = 0;
        if (!flag) {
            Arrays.sort(integers);

            int min = 0;
            int max = 0;
            for (int i = 0; i < cnt; i++) {
                int num = integers[i];
                if (num > n) {
                    max = num;

                    if (i - 1 >= 0) {
                        min = integers[i - 1] + 1;
                    } else {
                        min = 1;
                    }
                    break;
                }
            }

            for (int i = min; i <= n; i++) {
                for (int j = n; j < max; j ++) {
                    result++;
                }
            }
        }

        out.write(result == 0 ? "0" : String.valueOf(result - 1));
        out.flush();
        out.close();
    }
}
