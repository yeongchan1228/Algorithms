package basicStep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem1991 { // 트리 순회

    static List<Node>[] nodes;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        nodes = new ArrayList[N + 1];

        for(int i=1; i<N+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i=1; i<N+1; i++) {
            String[] line = in.readLine().split(" ");
            int data = line[0].charAt(0) -'A'+1;
            int left = line[1].charAt(0) -'A'+1;
            int right = line[2].charAt(0) -'A'+1;
            nodes[data].add(new Node(right, left));
        }

        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    // 전위 순회 root > left > right
    static void preorder(int start) {
        for(Node node : nodes[start]) {
            int l = node.left;
            int r = node.right;

            sb.append((char)(start+'A'-1));
            if(l != -18) preorder(l);
            if(r != -18) preorder(r);
        }
    }

    // 중위 순회 left > root > right
    static void inorder(int start) {
        for(Node node : nodes[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) inorder(l);
            sb.append((char)(start+'A'-1));
            if(r != -18) inorder(r);
        }
    }

    // 후위 순회 left > right > root
    static void postorder(int start) {
        for(Node node : nodes[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) postorder(l);
            if(r != -18) postorder(r);
            sb.append((char)(start+'A'-1));
        }
    }

    static class Node{
        private int right;
        private int left;

        public Node(int right, int left) {
            this.right = right;
            this.left = left;
        }
    }
}
