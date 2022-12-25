package programmers.level3;

import java.util.*;

public class N72413 { // 합승 택시 요금
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(new Solution().solution(n, s, a, b, fares));
    }

    static class Solution {
        static List<List<Info>> list = new ArrayList<>();

        public int solution(int n, int s, int a, int b, int[][] fares) {
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int[] fare : fares) {
                int from = fare[0];
                int to = fare[1];
                int weight = fare[2];

                list.get(from).add(new Info(to, weight));
                list.get(to).add(new Info(from, weight));
            }

            int[] minWeightByA = new int[n + 1];
            int[] minWeightByB = new int[n + 1];
            int[] minWeightByS = new int[n + 1];

            Arrays.fill(minWeightByA, Integer.MAX_VALUE);
            Arrays.fill(minWeightByB, Integer.MAX_VALUE);
            Arrays.fill(minWeightByS, Integer.MAX_VALUE);

            minWeightByA = dijkstra(a, minWeightByA);
            minWeightByB = dijkstra(b, minWeightByB);
            minWeightByS = dijkstra(s, minWeightByS);

            int answer = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                answer = Math.min(answer, minWeightByA[i] + minWeightByB[i] + minWeightByS[i]);
            }

            return answer;
        }

        private int[] dijkstra(int start, int[] minWeights) {
            Queue<Info> pq = new PriorityQueue<>();
            pq.offer(new Info(start, 0));
            minWeights[start] = 0;

            while (!pq.isEmpty()) {
                Info info = pq.poll();

                if (minWeights[info.to] < info.weight) {
                    continue;
                }

                List<Info> toList = list.get(info.to);
                for (Info nextInfo : toList) {
                    int weight = minWeights[info.to] + nextInfo.weight;
                    if (weight < minWeights[nextInfo.to]) {
                        minWeights[nextInfo.to] = weight;
                        pq.offer(new Info(nextInfo.to, weight));
                    }
                }
            }

            return minWeights;
        }

        public class Info implements Comparable<Info> {
            int to;
            int weight;

            public Info(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }

            @Override
            public int compareTo(Info o) {
                return this.weight - o.weight;
            }
        }
    }
}
