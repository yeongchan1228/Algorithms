package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem2776 { // 암기왕
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());

            HashSet<Integer> memory = new HashSet<>();
            for (int j = 0; j < cnt; j++) {
                memory.add(Integer.parseInt(st.nextToken()));
            }

            cnt = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < cnt; j++) {
                if (memory.contains(Integer.parseInt(st.nextToken()))) result.append("1" + "\n");
                else result.append("0" + "\n");
            }
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
