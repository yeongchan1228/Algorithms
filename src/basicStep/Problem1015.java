package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1015 { // 수열 정렬
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        int[] result = new int[n];
        Integer[][] arr = new Integer[n][2];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        for (int i = 0; i < n; i++) {
            result[arr[i][1]] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num + " ");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
