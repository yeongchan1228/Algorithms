package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2630 { // 색종이 만들기
    static int blue = 0, white = 0;
    static int[][] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(0, 0, n);

        out.write(white + "\n" + blue);
        out.flush();
        out.close();
    }

    static void calc(int row, int col, int size) {
        if (check(row, col, size)) {
            if (maps[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        size /= 2;

        calc(row, col, size);
        calc(row + size, col, size);
        calc(row, col + size, size);
        calc(row + size, col + size, size);
    }

    static boolean check(int row, int col, int size) {
        int point = maps[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (maps[i][j] != point) {
                    return false;
                }
            }
        }

        return true;
    }
}
