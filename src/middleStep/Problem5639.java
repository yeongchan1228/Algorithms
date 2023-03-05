package middleStep;

import java.io.*;

public class Problem5639 { // 이진 검색 트리
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = in.readLine();
        Node root = new Node(Integer.parseInt(input));
        while ((input = in.readLine()) != null) {
            setNode(root, new Node(Integer.parseInt(input)));
        }

        StringBuilder answer = new StringBuilder();
        postOrder(root, answer);

        out.write(answer.toString());
        out.flush();
        out.close();
    }

    private static void setNode(final Node node, final Node nextNode) {
        if (node.val > nextNode.val) {
            if (node.left == null) {
                node.left = nextNode;
            } else {
                setNode(node.left, nextNode);
            }
        } else {
            if (node.right == null) {
                node.right = nextNode;
            } else {
                setNode(node.right, nextNode);
            }
        }
    }

    private static void postOrder(final Node node, final StringBuilder answer) {
        if (node != null) {
            postOrder(node.left, answer);
            postOrder(node.right, answer);
            answer.append(node.val + "\n");
        }
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(final int val) {
            this.val = val;
        }
    }
}
