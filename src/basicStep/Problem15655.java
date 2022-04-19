package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15655 { // N과 M (6)

    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void dfs(int start, int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = arr[i];

                dfs(i + 1, depth + 1);

                visited[i] = false;
            }
        }
    }
}
