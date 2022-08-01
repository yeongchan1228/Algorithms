package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11728 { // 배열 합치기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int aLen = Integer.parseInt(st.nextToken());
        int bLen = Integer.parseInt(st.nextToken());
        int[] result = new int[aLen + bLen];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < aLen; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for (int i = aLen; i < aLen + bLen; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).sorted().forEach(num -> sb.append(num + " "));

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
