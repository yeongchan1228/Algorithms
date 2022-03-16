package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem6603 { // 로또

    static int count;
    static int[] S;
    static boolean[] visited;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

            count = Integer.parseInt(stringTokenizer.nextToken());
            if(count == 0){
                break;
            }
            S = new int[count];
            visited = new boolean[count];

            for (int i = 0; i < count; i++) {
                S[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            dfs(0,0);

            stringBuilder.append('\n');

        }

        System.out.println(stringBuilder);
    }

    static void dfs(int start, int depth){
        if (depth == 6){
            for (int i = 0; i < count; i++) {
                if(visited[i]){
                    stringBuilder.append(S[i]).append(" ");
                }
            }
            stringBuilder.append('\n');
            return;
        }

        for (int i = start; i < count; i++) {
            if(!visited[i]){
                visited[i] = true;

                dfs(i + 1,depth + 1);

                visited[i] = false;
            }
        }
    }
}
