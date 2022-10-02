package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/10/02.
 */
public class Problem1766 { // 문제집

    static int n, m;
    static int[] indegree;
    static List<ArrayList<Integer>> list;
    static StringBuilder result = new StringBuilder();


    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        while (m --> 0) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            list.get(from).add(to);
            indegree[to]++;
        }

        calc();

        out.write(result.toString());
        out.flush();
        out.close();
        in.close();
    }

    private static void calc() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int poll = pq.poll();

            for (int num : list.get(poll)) {
                if (--indegree[num] == 0) {
                    pq.add(num);
                }
            }
            result.append((poll + 1) + " ");
        }
    }
}
