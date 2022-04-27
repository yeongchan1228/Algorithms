package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14503 { // 로봇 청소기

    static int[][] map;
    static int N, M, result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int show = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(x, y, show);

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void dfs(int x, int y, int show) {
        if(map[x][y] == 0) {
            map[x][y] = 2;
            result++;
        }

        boolean check = false;
        int nowShow = show;
        for (int i = 0; i < 4; i++) {
            int nextShow = (show + 3) % 4;
            int px = x + dx[nextShow];
            int py = y + dy[nextShow];
            if (px > 0 && px <= N && py > 0 && py <= M && map[px][py] == 0) {
                check = true;
                dfs(px, py, nextShow);
                break;
            }
            show = nextShow;
        }

        if (!check) {
            int nextShow = (nowShow + 2) % 4;
            int px = x + dx[nextShow];
            int py = y + dy[nextShow];
            if (px > 0 && px <= N && py > 0 && py <= M && map[px][py] != 1) {
                dfs(px, py, nowShow);
            }
        }
    }
}
