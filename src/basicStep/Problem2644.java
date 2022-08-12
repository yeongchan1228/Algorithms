package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem2644 { // 촌수 계산

    static int to, from, result;
    static boolean[] visited;
    static ArrayList<Integer>[] arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        visited = new boolean[n + 1];
        arrayList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(in.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(in.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(in.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            arrayList[parent].add(child);
            arrayList[child].add(parent);
        }

        visited[from] = true;
        dfs(0, from);
        System.out.print(result == 0 ? -1 : result);

    }

    static void dfs(int depth, int num) {
        if (num == to) {
            result = depth;
            return;
        }

        for (Integer person : arrayList[num]) {
            if (!visited[person]) {
                visited[person] = true;
                dfs(depth + 1, person);
            }
        }
    }
}
