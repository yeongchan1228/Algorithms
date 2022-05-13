package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15665 { // N과 M (11)

    static int N, M;
    static int[] arr, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

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
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int save = 0;
        for (int i = 0; i < N; i++) {
            if(save != arr[i]) {
                selected[depth] = arr[i];
                save = arr[i];
                dfs(depth + 1);
            }
        }
    }
}
