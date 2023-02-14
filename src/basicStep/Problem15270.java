package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15270 { // 친구 팰린드롬
    private static int answer = 0;
    private static int[][] relations;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        relations = new int[m][2];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            relations[i][0] = from;
            relations[i][1] = to;
        }

        dfs(0, 0, m);
        out.write(answer < n ? String.valueOf(++answer) : String.valueOf(answer));
        out.flush();
        in.close();
        out.close();
    }

    private static void dfs(int depth, int cnt, int m) {
        if (depth == m) {
            answer = Math.max(answer, cnt);
            return;
        }

        if (!visited[relations[depth][0]] && !visited[relations[depth][1]]) {
            visited[relations[depth][0]] = true;
            visited[relations[depth][1]] = true;

            dfs(depth + 1, cnt + 2, m);

            visited[relations[depth][0]] = false;
            visited[relations[depth][1]] = false;
        }

        dfs(depth + 1, cnt, m);
    }
}
