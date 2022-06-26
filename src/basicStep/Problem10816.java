package basicStep;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem10816 { // 숫자 카드 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        Map<Integer, Integer> hashmap = new HashMap<>();

        int N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            hashmap.put(val, hashmap.getOrDefault(val, 0 ) + 1);
        }

        N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if(hashmap.containsKey(val)) sb.append(hashmap.get(val) + " ");
            else sb.append("0 ");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
