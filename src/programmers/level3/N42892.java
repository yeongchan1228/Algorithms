package programmers.level3;

import java.util.Arrays;

public class N42892 { // 길 찾기 게임
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
        for (int[] answer : new Solution().solution(nodeinfo)) {
            System.out.println(Arrays.toString(answer));
        }
    }

    static class Solution {

        private static int idx;

        public int[][] solution(int[][] nodeinfo) {
            Node[] nodes = new Node[nodeinfo.length];
            for (int i = 0; i < nodeinfo.length; i++) {
                nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
            }

            Arrays.sort(nodes, ((o1, o2) -> {
                if (o1.y == o2.y) {
                    return o1.x - o2.x;
                }

                return o2.y - o1.y;
            }));

            Node root = nodes[0];
            for (int i = 1; i < nodes.length; i++) {
                setNode(root, nodes[i]);
            }

            int[][] answer = new int[2][nodeinfo.length];

            idx = 0;
            preorder(root, answer);
            idx = 0;
            postorder(root, answer);

            return answer;
        }

        public void preorder(Node node, int[][] answer) {
            if (node != null) {
                answer[0][idx++] = node.idx;
                preorder(node.left, answer);
                preorder(node.right, answer);
            }
        }

        public void postorder(Node node, int[][] answer) {
            if (node != null) {
                postorder(node.left, answer);
                postorder(node.right, answer);
                answer[1][idx++] = node.idx;
            }
        }

        public void setNode(Node parent, Node child) {
            if (parent.x > child.x) {
                if (parent.left == null) {
                    parent.left = child;
                } else {
                    setNode(parent.left, child);
                }
            } else {
                if (parent.right == null) {
                    parent.right = child;
                } else {
                    setNode(parent.right, child);
                }
            }
        }

        public class Node {
            int x;
            int y;
            int idx;
            Node left;
            Node right;

            public Node(int x, int y, int idx) {
                this.x = x;
                this.y = y;
                this.idx = idx;
            }
        }
    }
}
