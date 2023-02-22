package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2110 { // 공유기 설치
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1] - arr[0];
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (calc(mid, arr) >= c) {
                answer = mid;
                left = mid + 1;
                continue;
            }

            right = mid - 1;
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    private static int calc(int distance, int[] arr) {
        int cnt = 1;
        int location = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - location >= distance) {
                cnt++;
                location = arr[i];
            }
        }
        return cnt;
    }
}
