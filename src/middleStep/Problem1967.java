package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1967 { // 트리의 지름

    static boolean[] visited;
    static ArrayList<Node>[] list;
    static int maxIdx = 0, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        list = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[n1 - 1].add(new Node(n2 - 1, w));
            list[n2 - 1].add(new Node(n1 - 1, w));
        }

        visited[0] = true;
        dfs(0, 0);

        visited = new boolean[N];
        visited[maxIdx] = true;
        dfs(maxIdx, 0);

        out.write(String.valueOf(max));
        out.flush();
        out.close();
    }

    static void dfs(int nodeInx, int cnt) {
        if(max < cnt) {
            max = cnt;
            maxIdx = nodeInx;
        }

        for (Node node : list[nodeInx]) {
            if(!visited[node.n]) {
                visited[node.n] = true;
                dfs(node.n, cnt + node.w);
            }
        }
    }

    static class Node {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}
