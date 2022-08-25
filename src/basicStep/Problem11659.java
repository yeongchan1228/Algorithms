package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11659 { // 구간 합 구하기 4
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            numbers[i] = numbers[i - 1] + val;
        }

        StringBuilder result = new StringBuilder();
        while (m --> 0) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            result.append((numbers[e] - numbers[s - 1]) + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
