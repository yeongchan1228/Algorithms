package others;

import java.util.*;
import java.io.*;

public class No4 { // 슈퍼컴퓨터 클러스터
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;
        long left = arr[0];
        long right = arr[n - 1] + (long) Math.sqrt(b);
        while (left <= right) {
            long mid = (left + right) / 2;

            if (isValid(mid, b, arr)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        out.write(String.valueOf(answer));
        out.flush();
        in.close();
        out.close();
    }

    private static boolean isValid(long mid, long b, int[] arr) {
        long totalPrice = 0;
        for (int val : arr) {
            if (val >= mid) {
                break;
            }

            totalPrice += (mid - val) * (mid - val);
            if (totalPrice > b) {
                return false;
            }
        }

        return true;
    }

}
