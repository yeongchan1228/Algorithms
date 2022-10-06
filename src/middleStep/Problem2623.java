package middleStep;

import java.io.*;
import java.util.*;

/**
 * Created by YC on 2022/10/06.
 */
public class Problem2623 { // 음악 프로그램

    static int[] indegree;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        indegree = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());

            int save = -1;
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                int num = Integer.parseInt(st.nextToken()) - 1;

                if (save != -1) {
                    list.get(save).add(num);
                    indegree[num]++;
                }
                save = num;
            }
        }

        StringBuilder sb = calc(n);

        boolean isFinish = getFinish(n);

        out.write(isFinish ? sb.toString() : "0");
        out.flush();
        out.close();
    }

    private static StringBuilder calc(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            sb.append((poll + 1) + "\n");

            for (int val : list.get(poll)) {
                if (--indegree[val] == 0) {
                    queue.offer(val);
                }
            }
        }

        return sb;
    }

    private static boolean getFinish(int n) {
        boolean isFinish = true;
        for (int i = 0; i < n; i++) {
            if (indegree[i] != 0) {
                isFinish = false;
            }
        }
        return isFinish;
    }
}
