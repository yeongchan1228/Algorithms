package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16926 { // 배열 돌리기 1
    static int map[][];
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int roll = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < roll; i++) {
            calc(0, row, col);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result.append(map[i][j] + " ");
            }
            result.append("\n");
        }

        out.write(result.toString().trim());
        out.flush();
        out.close();
    }

    static void calc(int start, int row, int col) {
        if (start >= row || start >= col) {
            return;
        }

        int save = map[start][start];

        // 위
        for (int i = start + 1; i < col; i++) {
            map[start][i - 1] = map[start][i];
        }

        // 오른쪽
        for (int i = start + 1; i < row; i++) {
            map[i - 1][col - 1] = map[i][col - 1];
        }

        // 아래
        for (int i = col - 2; i >= start; i--) {
            map[row - 1][i + 1] = map[row - 1][i];
        }

        // 왼쪽
        for (int i = row - 2; i >= start; i--) {
            map[i + 1][start] = map[i][start];
        }

        map[start + 1][start] = save;

        calc(start + 1, row - 1, col - 1);
    }
}
