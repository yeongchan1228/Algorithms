package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10451 { // 순열 사이클

    static int[] map;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int result;

        for (int i = 0; i < N; i++) {
            int var = Integer.parseInt(in.readLine());
            check = new boolean[var];
            map = new int[var];
            result = 0;
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < var; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < var; j++) {
                if(!check[j]){
                    dfs(j);
                    result++;
                }
            }

            out.write(result + "\n");
        }
        out.flush();
        out.close();
    }

    static void dfs(int start){
        check[start] = true;

        if(!check[map[start] - 1]) dfs(map[start] - 1);
    }
}
