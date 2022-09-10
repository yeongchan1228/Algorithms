package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/10.
 */
public class Problem1940 { // 주몽
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int result = 0;
        int start = 0, end = n - 1;
        while (start < end) {
            int plusCount = nums[start] + nums[end];
            if (plusCount == m) {
                end--;
                start++;
                result++;
            } else if (plusCount < m) {
                start++;
            } else {
                end--;
            }
        }

        if(nums[start] == m) result++;

        System.out.println(result);
    }
}
