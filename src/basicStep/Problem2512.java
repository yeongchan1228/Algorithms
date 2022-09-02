package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2512 { // 예산
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int max = Integer.MIN_VALUE;
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            nums[i] = val;

            max = Math.max(max, val);
        }
        int target = Integer.parseInt(in.readLine());

        int min = 0;
        while (min <= max) {
            int mid = (max + min) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > mid) {
                    sum += mid;
                } else {
                    sum += nums[i];
                }
            }

            if (sum <= target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min - 1);
    }
}
