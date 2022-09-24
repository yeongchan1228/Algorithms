package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/24.
 */
public class Problem2531 { // 회전 초밥
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] eatCount = new int[d + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (eatCount[arr[i]] == 0) {
                count++;
            }
            eatCount[arr[i]]++;
        }

        int result = calc(n, k, c, arr, eatCount, count);

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    private static int calc(int n, int k, int c, int[] arr, int[] eatCount, int count) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (result == k + 1) {
                break;
            }

            if (count >= result) {
                result = count;
                if (eatCount[c] == 0) {
                    result++;
                }
            }

            eatCount[arr[i - 1]]--;
            if (eatCount[arr[i - 1]] == 0) {
                count--;
            }

            if (eatCount[arr[(i + k - 1) % n]] == 0) {
                count++;
            }
            eatCount[arr[(i + k - 1) % n]]++;
        }
        return result;
    }
}
