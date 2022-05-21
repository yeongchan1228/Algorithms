package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11724 { // 연결 요소의 개수

    static int[][] map;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[V + 1][V + 1];


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1][v2] = map[v2][v1] = 1;
        }

        int result = 0;
        for (int i = 1; i <= V; i++) {
            if(map[i][0] == 0){
                dfs(i);
                result++;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void dfs(int v){
        if(map[v][0] == 1) return;

        map[v][0] = 1;

        for (int i = 1; i <= V; i++) {
            if(map[v][i] == 1){
                dfs(i);
            }
        }
    }
}
