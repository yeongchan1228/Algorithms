package middleStep;

import java.io.*;

public class Problem10026 { // 적록 색약

    static int A, B, N = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    A++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
                if(map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    B++;
                }
            }
        }

        StringBuilder sb = new StringBuilder(A + " " + B);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];

            if(px > -1 && px < N && py > -1 && py < N && !visited[px][py] && map[px][py] == map[x][y]){
                dfs(px, py);
            }
        }
    }

}
