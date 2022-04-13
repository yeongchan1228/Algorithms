package basicStep;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem1927 { // 최소 힙
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(in.readLine());
            if(num == 0){
                if(!queue.isEmpty()){
                    sb.append(queue.poll()).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else{
                queue.offer(num);
            }
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
