package basicStep;

import java.io.*;
import java.util.Arrays;

public class Problem2751 { // 수 정렬하기 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).sorted().forEach(num -> sb.append(num + "\n"));

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
