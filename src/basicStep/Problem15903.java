package basicStep;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem15903 { // 카드 합체 놀이
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            Long val1 = pq.poll();
            Long val2 = pq.poll();
            long addNum = val1 + val2;

            pq.offer(addNum);
            pq.offer(addNum);
        }

        long result = 0;
        while (!pq.isEmpty()){
            result += pq.poll();
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
