package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem10845 { // 큐
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int lastIndex = 0;

        for (int i = 0; i < N; i++) {
            String[] str = in.readLine().split(" ");

            switch (str[0]){
                case "push" :
                    int num = Integer.parseInt(str[1]);
                    queue.offer(num);
                    lastIndex = num;
                    break;

                case "pop" :
                    if(queue.isEmpty())
                        sb.append("-1").append('\n');
                    else {
                        Integer poll = queue.poll();
                        sb.append(poll).append('\n');
                    }
                    break;

                case "size" :
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty" :
                    if(queue.isEmpty())
                        sb.append("1").append('\n');
                    else
                        sb.append("0").append('\n');
                    break;

                case "front" :
                    if(queue.isEmpty())
                        sb.append("-1").append('\n');
                    else
                        sb.append(queue.peek()).append('\n');
                    break;

                case "back" :
                    if(queue.isEmpty())
                        sb.append("-1").append('\n');
                    else
                        sb.append(lastIndex).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}
