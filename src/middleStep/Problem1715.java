package middleStep;

import java.io.*;
import java.util.PriorityQueue;

public class Problem1715 { // 카드 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(in.readLine()));
        }

        int result = 0;
        while (priorityQueue.size() > 1){
            int val1 = priorityQueue.poll();
            int val2 = priorityQueue.poll();
            result += val1 + val2;

            priorityQueue.offer(val1 + val2);
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
