package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1822 { // 차집합
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int aLen = Integer.parseInt(st.nextToken());
        int bLen = Integer.parseInt(st.nextToken());
        HashSet<Integer> integers = new HashSet<>();

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < aLen; i++) {
            integers.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < bLen; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (integers.contains(val)) integers.remove(val);
        }


        StringBuilder result = new StringBuilder(String.valueOf(integers.size()));
        if (integers.size() != 0) {
            result.append("\n");
            integers.stream().sorted().forEach(key -> result.append(key + " "));
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
