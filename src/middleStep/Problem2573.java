package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2573 { // 빙산
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    private static int[][] map;
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int cnt = calcIce();
            if (cnt >= 2) {
                break;
            }

            if (cnt == 0) {
                year = 0;
                break;
            }

            year++;
            removeIce();
        }

        out.write(String.valueOf(year));
        out.flush();
        out.close();
    }
    
    private static int calcIce() {
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j, visited);
                }
            }
        }

        return cnt;
    }
    
    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int px = dx[i] + x;
            int py = dy[i] + y;
            
            if (isValid(px, py, visited)) {
                dfs(px, py, visited);
            }
        }
    }

    private static boolean isValid(int px, int py, boolean[][] visited) {
        return px > -1 && px < n && py > -1 && py < m && !visited[px][py] && map[px][py] != 0;
    }

    private static void removeIce() {
        boolean[][] nowIce = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    nowIce[i][j] = true;
                    map[i][j] -= calcZero(i, j, nowIce);
                    if (map[i][j] < 0) {
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int calcZero(int x, int y, boolean[][] nowIce) {
        int cnt = 0;
        for (int i = 0; i < dx.length; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (map[px][py] == 0 && !nowIce[px][py]) {
                cnt++;
            }
        }
        return cnt;
    }
}
