package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by YC on 2022/09/14.
 */
public class Problem2822 { // 점수 계산
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int cnt = 8;
        final int limit = 5;

        int[][] nums = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            nums[i][0] = Integer.parseInt(in.readLine());
            nums[i][1] = i + 1;
        }

        Arrays.sort(nums, (o1, o2) -> o2[0] - o1[0]);

        int sum = 0;
        int[] arr = new int[limit];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            sum += nums[i][0];
            arr[i] = nums[i][1];
        }
        result.append(sum + "\n");

        Arrays.sort(arr);
        for (int i = 0; i < limit; i++) {
            result.append(arr[i] + " ");
        }

        System.out.println(result.toString());
    }
}
