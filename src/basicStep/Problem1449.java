package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1449 { // 수리공 항승
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = 1;
        double len = arr[0] - 0.5 + l;
        for (int i = 1; i < n; i++) {
            if (len < arr[i] + 0.5) {
                len = arr[i] - 0.5 + l;
                min++;
            }
        }

        out.write(String.valueOf(min));
        out.flush();
        in.close();
    }
}
