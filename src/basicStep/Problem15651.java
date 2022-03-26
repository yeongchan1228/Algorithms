package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15651 { // N과 M (3)

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] selected = new int[N];

        int M = Integer.parseInt(st.nextToken());

        dfs(selected, 0, N, M);

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void dfs(int[] selected, int depth, int N, int M){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            selected[depth] = i;
            dfs(selected, depth + 1, N, M);
        }
    }
}
