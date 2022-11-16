package basicStep;

import java.io.*;

public class Problem10994 { // 별 찍기 - 19

    static char[][] map;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        int size = ((n - 1) * 4) + 1;
        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = ' ';
            }
        }

        calcMap(0, size);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append(map[i][j]);
            }
            result.append("\n");
        }

        out.write(result.toString().trim());

        out.flush();
        out.close();
    }

    static void calcMap(int point, int size) {
        for (int i = point; i < size; i++) {
            map[point][i] = '*';
            map[i][point] = '*';
            map[i][size - 1] = '*';
            map[size - 1][i] = '*';
        }

        if (size == 1) {
            return;
        }

        calcMap(point + 2, size - 2);
    }
}
