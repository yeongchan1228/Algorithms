package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem11656 { // 접미사 배열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();
        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i);
        }
//        PriorityQueue<String> pq = new PriorityQueue<>();
//        for (int i = 0; i < str.length(); i++) {
//            pq.add(str.substring(i));
//        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
//        while (!pq.isEmpty()) {
//            sb.append(pq.poll() + "\n");
//        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
