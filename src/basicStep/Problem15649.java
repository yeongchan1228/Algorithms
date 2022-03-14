package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15649 { // N과 M

    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[N + 1];
        arr = new int[M];

        dfs(0);

        System.out.println(stringBuilder.toString());
    }

    static void dfs(int depth){
        if(depth == M){
            for (int i : arr) {
                stringBuilder.append(i + " ");
            }
            stringBuilder.append('\n');
            return;
        }

        for (int i = 1; i <= N ; i++) {

            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}
