package basicStep;

import java.io.*;

public class Problem1992 { // 쿼드 트리

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        calc(0, 0, N);

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void calc(int x, int y, int N){

        if(search(x, y, N, map[x][y])){
            sb.append(map[x][y]);
            return;
        }

        int size = N / 2;

        sb.append("(");

        calc(x, y, size); // 왼쪽 위
        calc(x, y + size, size); // 오른쪽 위
        calc(x + size, y, size); // 왼쪽 아래
        calc(x + size, y + size, size); // 오른쪽 아래

        sb.append(")");
    }

    static boolean search(int x, int y, int size, int value) {
        for (int i = x; i < (x + size); i++) {
            for (int j = y; j < (y + size); j++) {
                if (map[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
