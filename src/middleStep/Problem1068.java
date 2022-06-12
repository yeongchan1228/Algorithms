package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1068 { // 트리

    static int[] parent;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        parent = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) root = i;
        }

        int delete = Integer.parseInt(in.readLine());
        deleteNode(delete);

        visited = new boolean[N];
        dfs(root);

        out.write(String.valueOf(count));
        out.flush();
        out.close();
    }

    static void deleteNode(int num){
        parent[num] = -2;
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == num) deleteNode(i);
        }
    }

    static void dfs(int node){
        boolean isLeaf = true;
        visited[node] = true;

        if(parent[node] != -2) {
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == node && !visited[i]) {
                    dfs(i);
                    isLeaf = false;
                }
            }

            if (isLeaf) count++;
        }
    }
}
