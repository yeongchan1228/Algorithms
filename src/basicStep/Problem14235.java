package basicStep;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem14235 { // 크리스마스 선물
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        StringBuilder result = new StringBuilder();
        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            if (a != 0) {
                while (a --> 0) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            } else {
                if (pq.isEmpty()) {
                    result.append("-1" + "\n");
                } else {
                    result.append(pq.poll() + "\n");
                }
            }
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
