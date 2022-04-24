package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11404 { // 플로이드
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int INF = 10000000;
        int V = Integer.parseInt(in.readLine());
        int E = Integer.parseInt(in.readLine());
        int[][] map = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], weight);
        }

        // 거쳐가는 노드
       for (int k = 1; k <= V; k++) {
            // 출발 노드
           for (int i = 1; i <= V; i++) {
               if(k == i) continue;
               // 도착 노드
               for (int j = 1; j <= V; j++) {
                   if(i == j || k == j) continue;
                   int value = map[i][k] + map[k][j];
                   map[i][j] = Math.min(value, map[i][j]);
               }
           }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(map[i][j] >= INF) map[i][j] = 0;
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

}
