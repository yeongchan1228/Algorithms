package basicStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/27.
 */
public class Problem1080 { // 행렬

    static int[][] before, after;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        before = new int[n][m];
        init(in, n, m, before);

        after = new int[n][m];
        init(in, n, m, after);

        int cnt = 0;
        cnt = getCnt(n, m, cnt);

        cnt = checkArr(n, m, cnt);

        out.write(String.valueOf(String.valueOf(cnt)));
        out.flush();
        out.close();
    }

    private static int checkArr(int n, int m, int cnt) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    cnt = -1;
                }
            }
        }
        return cnt;
    }

    private static int getCnt(int n, int m, int cnt) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j] && i + 2 < n && j + 2 < m) {
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            before[k][l] = before[k][l] == 0 ? 1 : 0;
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void init(BufferedReader in, int n, int m, int[][] arr) throws IOException {
        for (int i = 0; i < n; i++) {
            char[] chars = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars[j] - '0';
            }
        }
    }
}
