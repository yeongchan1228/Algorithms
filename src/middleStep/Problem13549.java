package middleStep;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13549 { // 숨바꼭질 3

    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(N, 0));

        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            visited[poll.p] = true;

            if(poll.p == K) return poll.t;

            if(poll.p > 0 && poll.p < K && poll.p * 2 < 100001 && !visited[poll.p * 2]) {
                pq.add(new Point(poll.p * 2, poll.t));
            }
            if (poll.p + 1 < 100001 && !visited[poll.p + 1]) {
                pq.add(new Point(poll.p + 1,  poll.t + 1));
            }
            if (poll.p - 1 > -1 && !visited[poll.p - 1]) {
                pq.add(new Point(poll.p - 1, poll.t + 1));
            }
        }

        return 0;
    }

    static class Point implements Comparable<Point>{
        int p;
        int t;

        public Point(int p, int t) {
            this.p = p;
            this.t = t;
        }

        @Override
        public int compareTo(Point o) {
            return t - o.t;
        }
    }
}
