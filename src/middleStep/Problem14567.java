package middleStep;

import java.io.*;
import java.util.*;

public class Problem14567 { // 선수과목
    private static int[] answer;
    private static int[] indegree;
    private static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        answer = new int[n + 1];
        indegree = new int[n + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            indegree[to]++;
        }

        calc();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }

        out.write(sb.toString().trim());
        out.flush();
        in.close();
        out.close();
    }

    private static void calc() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                answer[i] = 1;
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int val = queue.poll();

            for (int nextVal : list.get(val)) {
                indegree[nextVal]--;

                if (indegree[nextVal] == 0) {
                    answer[nextVal] = answer[val] + 1;
                    queue.offer(nextVal);
                }
            }
        }
    }
}
