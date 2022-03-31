package basicStep;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1697 { // 숨바꼭질

    static int result, N, K = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = in.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        visited = new int[100001];

        queue.offer(N);

        bfs();

        out.write(String.valueOf(visited[K]));
        out.flush();
        out.close();
    }

    static void bfs(){
        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            if (value == K) {
                break;
            }

            int num1 = value + 1;
            int num2 = value - 1;
            int num3 = value * 2;

            if(num1 < 100001 && visited[num1] == 0){
                visited[num1] = visited[value] + 1;
                queue.offer(num1);
            }
            if(num2 > -1 && visited[num2] == 0){
                visited[num2] = visited[value] + 1;
                queue.offer(num2);
            }
            if(num3 < 100001 && visited[num3] == 0){
                visited[num3] = visited[value] + 1;
                queue.offer(num3);
            }
        }
    }
}
