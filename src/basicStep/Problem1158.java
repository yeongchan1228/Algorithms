package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1158 { // 요세푸스 문제
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        StringBuilder sb = new StringBuilder("<");
        int num = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (!queue.isEmpty()){
            cnt++;
            Integer integer = queue.poll();
            if(cnt % num == 0){
                if(queue.size() == 0) sb.append(integer);
                else sb.append(integer+", ");
            }else queue.offer(integer);
        }
        out.write(sb.toString() + ">");
        out.flush();
        out.close();

    }
}
