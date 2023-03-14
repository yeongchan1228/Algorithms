package middleStep;

import java.io.*;
import java.util.*;

public class Problem14938 { // 서강그라운드

    private static List<List<Node>> lists;
    private static int n;
    private static int m;
    private static int[] dist;
    private static int[] counts;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<Node>());
        }

        counts = new int[n + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists.get(from).add(new Node(to, weight));
            lists.get(to).add(new Node(from, weight));
        }

        int answer = 0;
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    private static int dijkstra(int idx) {
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[idx] = 0;

        PriorityQueue<Node> pq = new PriorityQueue();
        pq.offer(new Node(idx, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.to]) {
                continue;
            }
            visited[idx] = true;

            for (Node nextNode : lists.get(node.to)) {
                int val = nextNode.weight + dist[node.to];

                if (val >= dist[nextNode.to]) {
                    continue;
                }

                dist[nextNode.to] = val;
                pq.offer(new Node(nextNode.to, val));
            }
        }

        return getCnt(dist);
    }

    private static int getCnt(final int[] dist) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > m) {
                continue;
            }

            cnt += counts[i];
        }
        return cnt;
    }

    public static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(final int to, final int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
