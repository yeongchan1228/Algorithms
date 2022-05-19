package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1012 { // 유기농 배추

    static int col, row;
    static int[][] map;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;

        int result;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());

            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            map = new int[row][col];
            result = 0;

            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if(map[j][k] == 1){
                        dfs(j, k);
                        result++;
                    }
                }
            }

            out.write(String.valueOf(result) + "\n");
        }
        out.flush();
        out.close();
    }

    static void dfs(int x, int y){
        map[x][y]++;

        for (int i = 0; i < 4; i++) {
            int px = dx[i] + x;
            int py = dy[i] + y;

            if(px > -1 && px < row && py > -1 && py < col && map[px][py] == 1){
                dfs(px, py);
            }
        }
    }
}
