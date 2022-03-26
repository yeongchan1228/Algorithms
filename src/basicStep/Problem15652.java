package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15652 { // N과 M (4)

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken()); // 1~N
        int[] selected = new int[N];
        boolean[] visited = new boolean[N + 1];

        int M = Integer.parseInt(st.nextToken()); // depth
        dfs(selected,1, 0, N, M);

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void dfs(int[] selected, int start, int depth,int num, int size){
        if(depth == size){
            for (int i = 0; i < size; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= num; i++) {
            selected[depth] = i;
            dfs(selected, i, depth + 1, num, size);
        }
    }

}
