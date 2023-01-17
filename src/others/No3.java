package others;

import java.util.*;
import java.io.*;

public class No3 { // 금고 털이
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            pq.offer(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int idx = 0;
        long answer = 0;
        while (true) {
            Info info = pq.poll();

            int calcW = w - info.w;
            if (calcW <= 0) {
                answer += w * info.p;
                break;
            }
            idx++;
            w = calcW;
            answer += info.w * info.p;
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    public static class Info implements Comparable<Info> {
        int w;
        int p;

        public Info(int w, int p) {
            this.w = w;
            this.p = p;
        }

        @Override
        public int compareTo(Info o) {
            return o.p - this.p;
        }
    }

}
