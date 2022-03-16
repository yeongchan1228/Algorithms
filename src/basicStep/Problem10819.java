package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem10819 { // 차이를 최대로

    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        arr = new int[N];
        visited = new boolean[N];
        selected = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(result);
    }

    /**
     * 6
     * 20 1 15 8 4 10
     */
    static void dfs(int depth){

        if(N == depth){
            int value = 0;

            for (int i = 0; i < (N-1); i++) {
                value += Math.abs(selected[i] - selected[i+1]);
            }

            result = Math.max(result, value);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;

                selected[depth] = arr[i];
                dfs(depth + 1);

                visited[i] = false;
            }
        }



    }
}
