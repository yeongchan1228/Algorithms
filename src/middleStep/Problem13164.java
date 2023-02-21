package middleStep;

import java.io.*;
import java.util.*;

public class Problem13164 { // 행복 유치원

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = getAnswer(n, k, arr);

        out.write(String.valueOf(answer));
        out.flush();
        in.close();
        out.close();
    }

    private static int getAnswer(final int n, final int k, final int[] arr) {
        int[] diff = new int[n - 1];
        for (int i = 1; i < n; i++) {
            diff[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < n - k; i++) {
            answer += diff[i];
        }

        return answer;
    }

}
