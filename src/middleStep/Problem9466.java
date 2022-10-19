package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9466 { // 팀 프로젝트
    static int[] arr;
    static int count;
    static boolean[] visited, done;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException { // 9466

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        while (n --> 0) {
            count = 0;
            int num = Integer.parseInt(in.readLine());
            arr = new int[num];
            visited = new boolean[num];
            done = new boolean[num];

            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int i = 0; i < num; i++) {
                dfs(i);
            }

            result.append((num - count) + "\n");
        }

        out.write(String.valueOf(result.toString()));
        out.flush();
        out.close();
    }

    static void dfs(int now) {
        if (visited[now]) {
            return;
        }

        visited[now] = true;
        int next = arr[now];
        if (visited[next]) {
            if (!done[next]) {
                count++;
                while (true) {
                    if (next == now) {
                        break;
                    }

                    count++;
                    next = arr[next];
                }
            }
        } else {
            dfs(next);
        }

        done[now] = true;
    }
}
