package basicStep;

import java.io.*;

public class Problem2447 { // 별 찍 10

    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        star = new char[N][N];

        draw(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            out.write(star[i]);
            out.write('\n');
        }
        out.flush();
        out.close();

    }

    static void draw(int x, int y, int N, boolean jump) {

        if(jump){
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if(N == 1){
            star[x][y] = '*';
            return;
        }

        int size = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1){
                    draw(x + i * size, y + j * size, size, true);
                }else{
                    draw(x + i * size, y + j * size, size, false);
                }
            }
        }
    }
}
