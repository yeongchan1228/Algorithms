package middleStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem12851 { // 숨바꼭질 2

    static int N, K;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] value;
    static int min = Integer.MAX_VALUE;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue.offer(N);
        value = new int[100001];
        value[N] = 1;

        bfs();

        out.write(String.valueOf(min) + "\n" + String.valueOf(result));
        out.flush();
        out.close();
    }

    static void bfs(){
        if(N > K){
            min = N - K;
            result++;
            return;
        }

        if(N == K){
            min = 0;
            result++;
            return;
        }

        while (!queue.isEmpty()){
            Integer integer = queue.poll();

            if(value[integer] > min) return;

            for (int i = 0; i < 3; i++) {
                int next;

                if(i == 0) next = integer + 1;
                else if(i == 1) next = integer - 1;
                else next = integer * 2;

                if(next < 0 || next > 100000) continue;

                if(next == K){
                    min = value[integer];
                    result++;
                }

                if(value[next] == 0 || value[next] >= value[integer] + 1){
                    queue.offer(next);
                    value[next] = value[integer] + 1;
                }
            }
        }
    }
}
