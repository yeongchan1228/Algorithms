package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2578 { // 빙고

    static int[][] map;
    static boolean[][] visited;
    static int bingo = 0;
    static final int MAX = 5;

    public static void main(String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 5;
        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < MAX; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < MAX; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < MAX; j++) {
                result++;
                int num = Integer.parseInt(st.nextToken());
                for (int k = 0; k < MAX; k++) {
                    for (int l = 0; l < MAX; l++) {
                        if (num == map[k][l]) {
                            map[k][l] = -1;
                            checkBingo(k, l);

                            if (bingo > 2) {
                                out.write(String.valueOf(result));
                                out.flush();
                                out.close();

                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void checkBingo(int k, int l) {
        if (checkRow(k)) {
            bingo++;
            setRow(k);
        }

        if (checkCol(l)) {
            bingo++;
            setCol(l);
        }

        if (k == l && checkLeftDiagonal()) {
            bingo++;
            setLeftDiagonal();
        }

        if (k + l == 4 && checkRightDiagonal()) {
            bingo++;
            setRightDiagonal();
        }
    }

    static boolean checkRow(int x) {
        for (int i = 0; i < MAX; i++) {
            if (!visited[x][i] && map[x][i] != -1) {
                return false;
            }
        }
        return true;
    }

    static void setRow(int x) {
        for (int i = 0; i < MAX; i++) {
            visited[x][i] = true;
        }
    }

    static boolean checkCol(int y) {
        for (int i = 0; i < MAX; i++) {
            if (!visited[i][y] && map[i][y] != -1) {
                return false;
            }
        }
        return true;
    }

    static void setCol(int y) {
        for (int i = 0; i < MAX; i++) {
            visited[i][y] = true;
        }
    }

    static boolean checkLeftDiagonal() {
        for (int i = 0; i < MAX; i++) {
            if (!visited[i][i] && map[i][i] != -1) {
                return false;
            }
        }

        return true;
    }

    static void setLeftDiagonal() {
        for (int i = 0; i < MAX; i++) {
            visited[i][i] = true;
        }
    }

    static boolean checkRightDiagonal() {
        for (int i = 0, j = 4; i < MAX; i++, j--) {
            if (!visited[i][j] && map[i][j] != -1) {
                return false;
            }
        }

        return true;
    }

    static void setRightDiagonal() {
        for (int i = 0, j = 4; i < MAX; i++, j--) {
            visited[i][j] = true;
        }
    }
}