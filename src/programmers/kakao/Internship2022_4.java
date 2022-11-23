package programmers.kakao;

import java.util.*;

public class Internship2022_4 {
    public static void main(String[] args) {
        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};

        Solution solution = new Solution();
        for (int answer : solution.solution(n, paths, gates, summits)) {
            System.out.println(answer);
        }
    }

    static class Solution {

        static int[] intensities;
        static HashSet<Integer> summitSet;
        static ArrayList<ArrayList<Node>> graph;
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            createGraph(n, paths);

            createIntensities(n);

            createSummitSet(summits);

            calc(gates);

            int idxAnswer = 0;
            int maxAnswer = Integer.MAX_VALUE;
            Arrays.sort(summits);
            for (int summit : summits) {
                if (intensities[summit] < maxAnswer) {
                    maxAnswer = intensities[summit];
                    idxAnswer = summit;
                }
            }

            return new int[]{idxAnswer, maxAnswer};
        }

        private void calc(int[] gates) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int gate : gates) {
                pq.offer(new Node(gate, 0));
                intensities[gate] = 0;
            }

            while (!pq.isEmpty()) {
                Node now = pq.poll();

                if (summitSet.contains(now.idx)) {
                    continue;
                }

                if (intensities[now.idx] < now.intensity) {
                    continue;
                }

                for (Node next : graph.get(now.idx)) {
                    int maxIntensity = Math.max(now.intensity, next.intensity);
                    if (intensities[next.idx] > maxIntensity) {
                        intensities[next.idx] = maxIntensity;
                        pq.offer(new Node(next.idx, maxIntensity));
                    }
                }
            }
        }

        private void createSummitSet(int[] summits) {
            summitSet = new HashSet<>();
            for (int summit : summits) {
                summitSet.add(summit);
            }
        }

        private void createIntensities(int n) {
            intensities = new int[n + 1];
            Arrays.fill(intensities, Integer.MAX_VALUE);
        }

        private void createGraph(int n, int[][] paths) {
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] path : paths) {
                int from = path[0];
                int to = path[1];
                int intensity = path[2];
                graph.get(from).add(new Node(to, intensity));
                graph.get(to).add(new Node(from, intensity));
            }
        }


        public class Node implements Comparable<Node> {
            int idx;
            int intensity;

            public Node(int idx, int intensity) {
                this.idx = idx;
                this.intensity = intensity;
            }

            @Override
            public int compareTo(Node o) {
                return this.intensity - o.intensity;
            }
        }
    }
}
