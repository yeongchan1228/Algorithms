package basicStep;

import java.io.*;

public class Problem1991 { // 트리 순회

    static Node[] nodes;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        nodes = new Node[N + 1];

        for(int i=1; i<N+1; i++) {
            String[] line = in.readLine().split(" ");
            int data = line[0].charAt(0) -'A'+1;
            int left = line[1].charAt(0) -'A'+1;
            int right = line[2].charAt(0) -'A'+1;
            Node newNode = new Node(right, left);
            nodes[data] = newNode;
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

    static void preorder(int start) {
        Node node = nodes[start];
        int left = node.getLeft();
        int right = node.getRight();

        sb.append((char)(start+'A'-1));
        if(left != -18) preorder(left);
        if(right != -18) preorder(right);

    }

    static void inorder(int start) {
        Node node = nodes[start];
        int left = node.getLeft();
        int right = node.getRight();

        if(left != -18) inorder(left);
        sb.append((char)(start+'A'-1));
        if(right != -18) inorder(right);
    }

    static void postorder(int start) {
        Node node = nodes[start];
        int left = node.getLeft();
        int right = node.getRight();

        if(left != -18) postorder(left);
        if(right != -18) postorder(right);
        sb.append((char)(start+'A'-1));
    }

    static class Node{
        private int right;
        private int left;

        public int getRight() {
            return right;
        }

        public int getLeft() {
            return left;
        }

        public Node(int right, int left) {
            this.right = right;
            this.left = left;
        }
    }
}
