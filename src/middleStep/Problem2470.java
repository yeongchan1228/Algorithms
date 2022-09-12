package middleStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/12.
 */
public class Problem2470 { // 두 용액
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        int start = 0, end = n - 1, sum = Integer.MAX_VALUE, minVal = 0, maxVal = 0;
        while (start < end){
            int val = values[start] + values[end];
            if (Math.abs(val) < Math.abs(sum)) {
                sum = val;
                minVal = values[start];
                maxVal = values[end];
            }

            if (val > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(minVal + " " + maxVal);
    }
}
