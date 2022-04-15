package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1182 { // 부분 수열 합

    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);


        if (S == 0) {
            result--;
        }
        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void dfs(int depth, int sum){
        if(depth == N){
            if(sum == S) result++;
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
