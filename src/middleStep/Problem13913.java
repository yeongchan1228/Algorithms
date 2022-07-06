package middleStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem13913 { // 숨바꼭질 4

    static int N, K;
    private static final int max = 100001;
    static boolean[] visited = new boolean[max];
    static int[] path = new int[max];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int time = 0;
        while (K != N) {
            K = path[K];
            stack.push(K);
            time++;
        }

        StringBuilder sb = new StringBuilder(time + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll == K) return;

            int num1 = poll * 2;
            int num2 = poll + 1;
            int num3 = poll - 1;

            if (num1 < max && poll != 0 && poll < K && !visited[num1]) {
                queue.add(num1);
                visited[num1] = true;
                path[num1] = poll;
            }

            if (num2 < max && !visited[num2]) {
                queue.add(num2);
                visited[num2] = true;
                path[num2] = poll;
            }

            if (num3 > -1 && !visited[num3]) {
                queue.add(num3);
                visited[num3] = true;
                path[num3] = poll;
            }
        }
    }

}
