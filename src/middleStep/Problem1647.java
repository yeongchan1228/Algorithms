package middleStep;

import java.io.*;
import java.util.*;

public class Problem1647 { // 도시 분할 계획

    static int[] parents;
    static ArrayList<Edge> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            list.add(new Edge(from, to, price));
        }

        Collections.sort(list, (o1, o2) -> o1.price - o2.price);

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int result = 0;
        int maxCost = 0;
        for (int i = 0; i < m; i++) {
            Edge edge = list.get(i);

            int from = edge.from;
            int to = edge.to;
            if (find(from) != find(to)) {
                int price = edge.price;
                result += price;
                union(from, to);

                maxCost = price;
            }
        }

        out.write(String.valueOf((result - maxCost)));
        out.flush();
        out.close();
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }

    static class Edge {
        int from;
        int to;
        int price;

        public Edge(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
}
