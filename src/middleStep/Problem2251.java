package middleStep;

import java.io.*;
import java.util.*;

/**
 * Created by YC on 2022/09/25.
 */
public class Problem2251 { // 물통
    static int a, b, c;
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int totalSize = 3;
        StringTokenizer st = new StringTokenizer(in.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bfs();

        StringBuilder sb = new StringBuilder();
        result.forEach(num -> sb.append(num + " "));

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void bfs() {
        Queue<Bottle> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[a + 1][b + 1][c + 1];

        queue.add(new Bottle(0, 0, c));
        while (!queue.isEmpty()) {
            Bottle poll = queue.poll();

            if (visited[poll.a][poll.b][poll.c]) {
                continue;
            }

            if (poll.a == 0) {
                result.add(poll.c);
            }

            visited[poll.a][poll.b][poll.c] = true;


            // b -> a
            if (poll.a + poll.b <= a) {
                queue.add(new Bottle(poll.a + poll.b, 0, poll.c));
            } else {
                queue.add(new Bottle(a, poll.a + poll.b - a, poll.c));
            }

            // c -> a
            if (poll.a + poll.c <= a) {
                queue.add(new Bottle(poll.a + poll.c, poll.b, 0));
            } else {
                queue.add(new Bottle(a, poll.b, poll.a + poll.c - a));
            }

            //  a -> b
            if (poll.a + poll.b <= b) {
                queue.add(new Bottle(0, poll.a + poll.b, poll.c));
            } else {
                queue.add(new Bottle(poll.a + poll.b - b, b, poll.c));
            }

            // c -> b
            if (poll.c + poll.b <= b) {
                queue.add(new Bottle(poll.a, poll.c + poll.b, 0));
            } else {
                queue.add(new Bottle(poll.a, b, poll.c + poll.b - b));
            }

            // a -> c
            if (poll.a + poll.c <= c) {
                queue.add(new Bottle(0, poll.b, poll.a + poll.c));
            } else {
                queue.add(new Bottle(poll.a + poll.c - c ,poll.b, c));
            }

            // b -> c
            if (poll.a + poll.c <= c) {
                queue.add(new Bottle(poll.a, 0,  poll.b + poll.c));
            } else {
                queue.add(new Bottle(poll.a, poll.b + poll.c - c,  c));
            }
        }
    }

    static class Bottle {
        int a;
        int b;
        int c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
