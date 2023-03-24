package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1895 { // 필터
    private static int r;
    private static int c;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < r - 2 ; i++) {
            for (int j = 0; j < c - 2; j++) {
                if (calcMiddleVal(i, j) >= t) {
                    answer++;
                }
            }
        }

        out.write(String.valueOf(answer));
        out.flush();
        in.close();
        out.close();
    }

    private static int calcMiddleVal(int x, int y) {
        int idx = 0;
        int[] selected = new int[9];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                selected[idx++] = arr[i][j];
            }
        }

        Arrays.sort(selected);

        return selected[4];
    }
}
