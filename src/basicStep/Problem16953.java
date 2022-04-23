package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16953 { // A -> B

//    static int[] visited;
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
//        visited = new int[B + 1];

//        bfs();
        int result = 0;
        while (B != A){
            if (B < A){
                result = -1;
                break;
            }

            if(B % 10 == 1){
                B /= 10;
            }else if(B % 2 == 0){
                B /= 2;
            }else {
                result = -1;
                break;
            }
            result++;
        }


        if(result != -1) {
            out.write(String.valueOf(result + 1));
        }else{
            out.write(String.valueOf(result));
        }
        out.flush();
        out.close();
    }

//    static void bfs(){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(A);
//
//        while (!queue.isEmpty()){
//            Integer poll = queue.poll();
//
//            if(poll == B) break;
//
//            int multi = poll * 2;
//            if(multi <= B){
//                queue.offer(multi);
//                visited[multi] = visited[poll] + 1;
//            }
//
//            int plus = poll * 10 + 1;
//            if(plus <= B){
//                queue.offer(plus);
//                visited[plus] = visited[poll] + 1;
//            }
//        }

//    }
}
