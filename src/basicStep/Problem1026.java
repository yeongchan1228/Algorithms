package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1026 { // 보물
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());
        int[] a = new int[cnt];
        Integer[] b = new Integer[cnt];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            for (int j = 0; j < cnt; j++) {
                if (i == 0) a[j] = Integer.parseInt(st.nextToken());
                else b[j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(a);
        Arrays.sort(b, ((o1, o2) -> o2 - o1));

        int result = 0;
        for (int i = 0; i < cnt; i++) {
            result += a[i] * b[i];
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
