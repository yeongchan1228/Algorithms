package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem5800 { // 성적 통계
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            result.append("Class " + i + "\n");
            int cnt = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[cnt];
            for (int j = 0; j < cnt; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Collections.reverseOrder());
            result.append("Max " + arr[0] + ", ");
            result.append("Min " + arr[cnt - 1] + ", ");
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < cnt - 1; j++) {
                max = Math.max(max, arr[j] - arr[j + 1]);
            }
            result.append("Largest gap " + max + "\n");
        }

        out.write(result.toString().trim());
        out.flush();
        out.close();

    }
}
