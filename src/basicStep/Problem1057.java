package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1057 { // 토너먼트
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int result = 0;
        boolean isFinish = false;
        while (!isFinish && n > 1) {
            result++;
            int val = n / 2;
            for (int i = 0; i < val; i++) {
                int person1 = queue.poll();
                int person2 = queue.poll();

                if ((person1 == a && person2 == b) || (person2 == a && person1 == b)) {
                    isFinish = true;
                    break;
                }

                if (person1 == a || person1 == b) {
                    queue.offer(person1);
                    continue;
                }

                if (person2 == a || person2 == b) {
                    queue.offer(person2);
                    continue;
                }

                queue.offer(person1);
            }

            if (n % 2 == 1) {
                queue.offer(queue.poll());
                n = val + 1;
            } else {
                n = val;
            }
        }

        result = isFinish ? result : -1;
        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
