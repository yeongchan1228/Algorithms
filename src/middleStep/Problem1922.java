package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1922 { // 네트워크 연결

    static ArrayList<Node>[] lists;
    static boolean[] check;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int V = Integer.parseInt(in.readLine());
        int E = Integer.parseInt(in.readLine());
        lists = new ArrayList[V];
        check = new boolean[V];

        for (int i = 0; i < V; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start - 1].add(new Node(end - 1, weight));
            lists[end- 1].add(new Node(start - 1, weight));
        }

        prime(0);

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void prime(int from){
        Queue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(from, 0));

        while (!queue.isEmpty()){
            Node poll = queue.poll();
            int to = poll.to;
            int weight = poll.weight;

            if(check[to]) continue;

            check[to] = true;
            result += weight;

            for (Node node : lists[to]) {
               if(!check[node.to]) queue.offer(node);
            }
        }
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
