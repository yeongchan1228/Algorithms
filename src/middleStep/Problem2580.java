package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2580 { // 스도쿠

    static int[][] map = new int[9][9];
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(0, 0);
    }

    static void calc(int x, int y) throws IOException {
        if(y == 9){
            calc(x + 1, 0);
            return;
        }

        if(x == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    out.write(map[i][j] + " ");
                }
                out.write("\n");
            }
            out.flush();
            out.close();
            System.exit(0);
        }

        if(map[x][y] == 0){
            for (int i = 1; i <= 9; i++) {
                if(check(x, y, i)){
                    map[x][y] = i;
                    calc(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }

        calc(x, y + 1);
    }

    static boolean check(int x, int y, int value){

        // 1. 행 검사
        for (int i = 0; i < 9; i++) {
            if(map[x][i] == value) return false;
        }

        // 2. 열 검사
        for (int i = 0; i < 9; i++) {
            if(map[i][y] == value) return false;
        }

        // 3. 3x3 검사
        int dx = x / 3 * 3;
        int dy = y / 3 * 3;
        for (int i = dx; i < dx + 3; i++) {
            for (int j = dy; j < dy + 3; j++) {
                if(map[i][j] == value) return false;
            }
        }

        return true;
    }
}
