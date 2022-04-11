package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15663 { // N과 M (9)

    static int N, M;
    static int[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void dfs(int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        int save = 0;
        for (int i = 0; i < N; i++) {
            if(save == arr[i]) continue;

            if(!visited[i]){
                visited[i] = true;
                selected[depth] = arr[i];
                save = arr[i];
                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}
