package middleStep;

import java.io.*;
import java.util.*;

public class Problem1197 { // 최소 신장 트리

    static List<Node>[] nodeList;
    static int count = 0;
    static boolean[] checkV;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int V = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }
        checkV = new boolean[V + 1];
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end ,weight));
            nodeList[end].add(new Node(start ,weight));
        }

        prime(1);

        out.write(String.valueOf(count));
        out.flush();
        out.close();
    }

    // 정점으로 계산
    static void prime(int start){
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int end = node.end;
            int weight = node.weight;

            if(checkV[end]) continue;

            checkV[end] = true;
            count += weight;

            for (Node next : nodeList[end]) {
                if(!checkV[next.end]) queue.offer(next);
            }
        }
    }

    static class Node implements Comparable<Node>{

        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
