package basicStep;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem10867 { // 중복 빼고 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        HashSet<Integer> integers = new HashSet<>();
        while (n --> 0) {
            integers.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder result = new StringBuilder();
        integers.stream().sorted().forEach(key -> result.append(key + " "));

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
