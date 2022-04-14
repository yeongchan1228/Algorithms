package basicStep;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


public class Problem11279 { // 최대 힙
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(in.readLine());

            if(value == 0){
                if(!queue.isEmpty()){
                    sb.append(queue.poll()).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else{
                queue.offer(value);
            }
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

}
