package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem4963 { // 섬의 개수

    static int col, row, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(in.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());

            if(col == 0 && row == 0) break;

            map = new int[row][col];
            visited = new boolean[row][col];
            result = 0;

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        result++;
                    }
                }
            }

            out.write(String.valueOf(result) + "\n");
        }

        out.flush();
        out.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int px = dx[i] + x;
            int py = dy[i] + y;

            if (px > -1 && px < row && py > -1 && py < col && map[px][py] == 1 && !visited[px][py])
                dfs(px, py);
        }
    }

}
