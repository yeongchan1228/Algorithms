package middleStep;

import java.io.*;
import java.util.*;

public class Problem1753 { // 최단 경로

    static Queue<Node> queue = new PriorityQueue<>();
    static ArrayList<Node>[] map;
    static int[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }
        min = new int[V+1];

        Arrays.fill(min, Integer.MAX_VALUE);

        int start = Integer.parseInt(in.readLine());
        min[start] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[s].add(new Node(e, w));
        }

        calc(start);

        for (int i = 1; i <= V; i++) {
            if(min[i] != Integer.MAX_VALUE) sb.append(min[i]).append('\n');
            else sb.append("INF").append('\n');
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void calc(int start){
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;

            if(min[v] < w) continue;

            for (int i = 0; i < map[v].size(); i++) {
                int nV = map[v].get(i).v;
                int nW = map[v].get(i).w + w;
                if(min[nV] > nW) {
                    min[nV] = nW;
                    queue.offer(new Node(nV, nW));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
