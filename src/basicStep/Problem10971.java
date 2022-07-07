package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10971 { // 외판원 순회 2

    static int[][] maps;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE, N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        maps = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(result);
    }

    static void dfs(int depth, int start, int val) {
        if(depth == N - 1) {
            if(maps[start][0] != 0) result = Math.min(result, val + maps[start][0]);
            return;
        }

        for (int to = 1; to < N; to++) {
            if(visited[to] || maps[start][to] == 0) continue;

            visited[to] = true;
            dfs(depth + 1, to, val + maps[start][to]);
            visited[to] = false;
        }
    }
}
