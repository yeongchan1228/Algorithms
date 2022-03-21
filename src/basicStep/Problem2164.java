package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2164 { // 카드 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(in.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            queue.offer(i);
        }

        int cnt = 1;
        while (true){
            if(queue.size() == 1){
                System.out.println(queue.peek());
                return;
            }

            int value = queue.poll();
            if(cnt % 2 == 0) {
                queue.offer(value);
            }
            cnt++;
        }
    }
}
