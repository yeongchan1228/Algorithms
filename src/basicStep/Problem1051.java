package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1051 { // 숫자 정사각형
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            char[] chars = in.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cnt = 0;
                int num = map[i][j];
                for (int k = 0; k < row; k++) {
                    if ((k + i) >= row || (k + j) >= col) {
                        break;
                    }

                    if (isValid(map, i, j, num, k)) {
                        cnt = (k + 1) * (k + 1);
                    }
                }

                result = Math.max(result, cnt);
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    private static boolean isValid(int[][] map, int i, int j, int num, int k) {
        return num == map[i + k][j] && num == map[i][j + k] && num == map[i + k][j + k];
    }
}
