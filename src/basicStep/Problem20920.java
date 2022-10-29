package basicStep;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem20920 { // 영단어 암기는 어려워
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        while (n --> 0) {
            String word = in.readLine();
            if (word.length() >= m) {
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            }
        }

        List<String> keys = hashMap.keySet().stream().collect(Collectors.toList());
        Collections.sort(keys, (o1, o2) -> {
            if (hashMap.get(o1) == hashMap.get(o2)) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }

                return o2.length() - o1.length();
            }

            return hashMap.get(o2) - hashMap.get(o1);
        });

        StringBuilder result = new StringBuilder();
        keys.forEach(entry -> result.append(entry + "\n"));

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
