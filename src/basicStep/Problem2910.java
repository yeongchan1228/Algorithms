package basicStep;

import java.io.*;
import java.util.*;

public class Problem2910 { // 빈도 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            hashMap.put(key, hashMap.getOrDefault(key,  0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        hashMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(entrySet -> {
            String str = entrySet.getKey() + " ";
            sb.append(str.repeat(entrySet.getValue()));
        });

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
