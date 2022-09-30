package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/30.
 */
public class Problem1005 { // ACM Craft

    static int[] times, indegree, result;
    static ArrayList<ArrayList<Integer>> roles;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int buildingCnt = Integer.parseInt(st.nextToken());
            int roleCnt = Integer.parseInt(st.nextToken());

            times = new int[buildingCnt];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < buildingCnt; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            roles = new ArrayList<>();
            for (int i = 0; i < buildingCnt; i++) {
                roles.add(new ArrayList<>());
            }

            indegree = new int[buildingCnt];
            for (int i = 0; i < roleCnt; i++) {
                st = new StringTokenizer(in.readLine());

                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;

                roles.get(from).add(to);
                indegree[to]++;
            }

            int target = Integer.parseInt(in.readLine());

            calc(buildingCnt);

            sb.append(result[target - 1] + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }

    private static void calc(int buildingCnt) {
        Queue<Integer> queue = new LinkedList<>();
        result = new int[buildingCnt];

        for (int i = 0; i < buildingCnt; i++) {
            result[i] = times[i];

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int building : roles.get(now)) {
                result[building] = Math.max(result[building], result[now] + times[building]);

                indegree[building]--;

                if (indegree[building] == 0) {
                    queue.offer(building);
                }
            }
        }
    }
}
