package middleStep;

import java.io.*;
import java.util.*;

public class Problem1916 { // 최소 비용 구하기

    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int[] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(in.readLine());
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        M = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(in.readLine());
        out.write(String.valueOf(calc(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1)));
        out.flush();
        out.close();
    }

    static int calc(int start, int end){
        Queue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N];

        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()){
            Node poll = queue.poll();
            int now = poll.to;
            if(now == end) break;

            if(!visited[now]){
                visited[now] = true;

                for (Node node : list.get(now)) {
                    int to = node.to;
                    if(!visited[to] && dist[to] > dist[now] + node.weight){
                        dist[to] = dist[now] + node.weight;
                        queue.offer(new Node(to, dist[to]));
                    }
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
