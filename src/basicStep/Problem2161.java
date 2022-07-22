package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2161 { // 카드1
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            sb.append(queue.poll() + " ");

            queue.add(queue.poll());
        }

        out.write(sb.toString() + queue.peek());
        out.flush();
        out.close();
    }
}
