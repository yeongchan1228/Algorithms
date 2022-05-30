package basicStep;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem11286 { // 절댓값 힙
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)){
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });
        int N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int var = Integer.parseInt(in.readLine());
            if(var == 0) {
                if(!queue.isEmpty()) sb.append(queue.poll() + "\n");
                else sb.append("0" + "\n");
            }else queue.add(var);
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
