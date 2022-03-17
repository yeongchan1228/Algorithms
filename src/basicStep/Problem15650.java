package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15650 { // M과 N(2)

    static StringBuilder sb = new StringBuilder();
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        /**
         * N : 1 ~ N까지
         * M : 길이가 M인 순열
         * 오름차, 중복X
         */
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        selected = new int[N];
        visited = new boolean[N];

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        dfs(0, 0, M, N, arr);

        System.out.println(sb);
    }

    static void dfs(int start, int depth , int size, int cnt, int[] arr){
        if(depth == size){
            for (int i = 0; i < size; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < cnt; i++) {

            if(!visited[i]){

                selected[depth] = arr[i];
                visited[i] = true;

                dfs(i + 1,depth + 1, size, cnt, arr);

                visited[i] = false;

            }
        }
    }
}
