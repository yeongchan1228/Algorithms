package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem3273 { // 두 수의 합
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(in.readLine());

        int result = 0;
        int start = 0;
        int end = cnt - 1;

        while (start != end) {
            if (arr[start] + arr[end] == x){
                result++;
            }

            if (arr[start] + arr[end] <= x) {
                start++;
            } else {
                end--;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
