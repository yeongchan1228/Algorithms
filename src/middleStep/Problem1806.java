package middleStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/10/01.
 */
public class Problem1806 { // 부분 합
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, result = Integer.MAX_VALUE;
        while (start <= end && end <= n) {
            if (sum < s) {
                sum += nums[end++];
            } else if (sum >= s) {
                result = Math.min(result, end - start);
                sum -= nums[start++];
            }
        }

        out.write(result == Integer.MAX_VALUE ? "0" : String.valueOf(result));
        out.flush();
        out.close();
        in.close();
    }
}
