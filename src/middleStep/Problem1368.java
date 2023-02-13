package middleStep;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1368 { // 물대기
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        parents = new int[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.offer(new Edge(0, i, Integer.parseInt(in.readLine())));
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= n; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (i < j) {
                    pq.offer(new Edge(i, j, weight));
                }
            }
            parents[i] = i;
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.from) == find(edge.to)) {
                continue;
            }

            union(edge.from, edge.to);

            answer += edge.weight;

        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    private static int find(int v) {
        if (parents[v] == v) return v;
        return find(parents[v]);
    }

    private static void union(int u, int v) {
        int uParent = find(u);
        int vParent = find(v);

        if (uParent > vParent) {
            parents[uParent] = vParent;
            return;
        }

        parents[vParent] = uParent;
    }

    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
