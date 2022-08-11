package basicStep;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem2346 { // 풍선 터뜨리기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            deque.add(i + 1);
        }

        StringBuilder result = new StringBuilder();
        while (deque.size() > 1) {
            Integer val = deque.poll();
            int number = numbers[val - 1];
            result.append(val + " ");

            if (number > 0) {
                for (int j = 0; j < number - 1; j++) {
                    deque.addLast(deque.pollFirst());
                }

            } else {
                for (int j = 0; j > number; j--) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        out.write(result.append(deque.poll() + " ").toString());
        out.flush();
        out.close();
    }
}
