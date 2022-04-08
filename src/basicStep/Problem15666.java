package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15666 { // N과 M (12)

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr, selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken()); // 개수
        arr = new int[N];
        selected = new int[N];
        M = Integer.parseInt(st.nextToken()); // 길이

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
            for (int i = 0; i < depth; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');

            return;
        }

        int num = 0;
        for (int i = start; i < N; i++) {
            if(num == arr[i]) continue;

            selected[depth] = num = arr[i];

            dfs(i, depth + 1);
        }
    }
}
