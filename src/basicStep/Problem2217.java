package basicStep;

import java.io.*;
import java.util.Arrays;

public class Problem2217 { // 로프
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        int[] arr= new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        int tmp = 1;
        for (int i = cnt - 1; i >= 0; i--, tmp++) {
            max = Math.max(max, arr[i] * tmp);
        }

        out.write(String.valueOf(max));
        out.flush();
        out.close();
    }
}
