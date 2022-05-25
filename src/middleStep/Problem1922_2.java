package middleStep;

import java.io.*;
import java.util.*;

public class Problem1922_2 { // 네트워크 연결(크루스칼)

    static Queue<Node> queue = new PriorityQueue<>();
//    static List<Node> list = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int V = Integer.parseInt(in.readLine());
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int E = Integer.parseInt(in.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.offer(new Node(start, end, weight));
//            list.add(new Node(start, end, weight));
        }

//        Collections.sort(list);
//
//        int result = 0;
//        for (int i = 0; i < list.size(); i++) {
//            Node node = list.get(i);
//
//            int sP = find(node.start);
//            int eP = find(node.end);
//
//            if(sP != eP){
//                union(sP, eP);
//                result += node.weight;
//            }
//        }

        int result = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();

            int sP = find(node.start);
            int eP = find(node.end);

            if(sP != eP){
                union(sP, eP);
                result += node.weight;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static int find(int var){
        if(parent[var] == var) return var;

        return find(parent[var]);
    }

    static void union(int x, int y){
        if(x != y) parent[y] = x;
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
