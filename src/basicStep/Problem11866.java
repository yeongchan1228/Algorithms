package basicStep;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11866 { // 요세푸스 문제 0
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int cnt = 1;
        StringBuilder sb = new StringBuilder("<");
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(cnt % k == 0) {
                sb.append(poll + ", ");
            }else {
                queue.add(poll);
            }
            cnt++;
        }

        String result = sb.substring(0, sb.length() - 2) + ">";
        out.write(result);
        out.flush();
        out.close();
    }
}
