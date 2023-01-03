package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N132266 { // 부대복귀
    public static void main(String[] args) {
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int destination = 1;
        for (int answer : new Solution().solution(n, roads, sources, destination)) {
            System.out.println(answer);
        }
    }

    static class Solution {

        static int[] distances;

        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            distances = new int[n + 1];
            Arrays.fill(distances, Integer.MAX_VALUE);

            dijkstra(destination, sources, createList(n, roads));

            int[] answer = new int[sources.length];
            for (int i = 0; i < sources.length; i++) {
                int val = distances[sources[i]];
                answer[i] = val == Integer.MAX_VALUE ? -1 : val;
            }

            return answer;
        }

        private void dijkstra(int destination, int[] sources, ArrayList<ArrayList<Node>> list) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(destination, 0));
            distances[destination] = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.cost > distances[node.idx]) {
                    continue;
                }

                for (Node nextNode : list.get(node.idx)) {
                    int totalCost = node.cost + nextNode.cost;
                    if (totalCost < distances[nextNode.idx]) {
                        distances[nextNode.idx] = totalCost;
                        queue.offer(new Node(nextNode.idx, totalCost));
                    }
                }
            }
        }

        private ArrayList<ArrayList<Node>> createList(int n, int[][] roads) {
            ArrayList<ArrayList<Node>> list = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<Node>());
            }

            for (int[] road : roads) {
                int from = road[0];
                int to = road[1];

                list.get(from).add(new Node(to, 1));
                list.get(to).add(new Node(from, 1));
            }

            return list;
        }

        public class Node {
            private int idx;
            private int cost;

            public Node(int idx, int cost) {
                this.idx = idx;
                this.cost = cost;
            }
        }
    }
}
