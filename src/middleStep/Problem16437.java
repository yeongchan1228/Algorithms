package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem16437 { // 양 구출 작전
    private static long[] dp;
    private static List<List<Integer>> lists;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<Integer>());
        }

        int idx = 2;
        dp = new long[n + 1];
        for (int i = 0; i < n - 1; i++, idx++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String sheepInfo = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            lists.get(parent).add(idx);

            dp[idx] = sheepInfo.equals("S") ? cnt : -1 * cnt;
        }

        dfs(1, 0);

        out.write(String.valueOf(dp[1]));
        out.flush();
        out.close();
    }

    private static void dfs(int idx, int parentIdx) {
        for (int childIdx : lists.get(idx)) {
            dfs(childIdx, idx);
        }

        if (parentIdx != 0) {
            if (dp[idx] > 0){
                dp[parentIdx] += dp[idx];
            }
        }
    }
}
