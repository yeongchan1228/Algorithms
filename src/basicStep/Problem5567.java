package basicStep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/22.
 */
public class Problem5567 { // 결혼식
    static int n;
    static boolean[] visited;
    static List<ArrayList<Integer>> list = new ArrayList();

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList());
        }

        while (m --> 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        visited[1] = true;
        calc(0, 1);

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
                count++;
            }
        }

        out.write(String.valueOf(count));
        out.flush();
        out.close();
    }

    static void calc(int depth, int idx) {
        if (depth == 2) return;
        for (Integer integer : list.get(idx)) {
            visited[integer] = true;
            calc(depth + 1, integer);
        }
    }
}
