package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem9372 { // 상근이의 여행

    static int n;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        while (cnt --> 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            visited = new boolean[n];
            while (m --> 0) {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;

                arr[from][to] = 1;
                arr[to][from] = 1;
            }

            result.append((bfs() - 1) + "\n");
        }
        out.write(result.toString());
        out.flush();
        out.close();
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            result++;
            for (int i = 0; i < n; i++) {
                if (arr[poll][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return result;
    }
}
