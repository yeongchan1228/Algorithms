package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem9322 { // 철벽 보안 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        while (n --> 0) {
            int cnt = Integer.parseInt(in.readLine());

            StringTokenizer st = new StringTokenizer(in.readLine());
            HashMap<String , Integer> hashmap = new HashMap<>();
            for (int i = 0; i < cnt; i++) {
                hashmap.put(st.nextToken(), i);
            }

            String[] words = new String[cnt];
            st = new StringTokenizer(in.readLine());
            StringTokenizer st2 = new StringTokenizer(in.readLine());
            for (int i = 0; i < cnt; i++) {
                words[hashmap.get(st.nextToken())] = st2.nextToken();
            }

            Arrays.stream(words).forEach(word -> result.append(word + " "));
            result.append("\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
