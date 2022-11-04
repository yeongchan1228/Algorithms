package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2563 { // 색종이
    public static void main(String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 101;
        int cnt = Integer.parseInt(in.readLine());
        int[][] paper = new int[MAX][MAX];

        int result = 0;
        while (cnt --> 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if (paper[i][j] == 0) {
                        paper[i][j] = 1;
                        result++;
                    }
                }
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
