package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2343 { // 기타레슨
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int[] lectures = new int[n];
        int total = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            total += lectures[i];
            max = Math.max(lectures[i], max);
        }

        int answer = Integer.MAX_VALUE;
        int start = 0, end = total + 1;
        while (start <= end) {
            int temp = 0;
            int count = 1;

            int mid = (start + end) / 2;
            for (int lecture : lectures) {
                temp += lecture;
                if (temp > mid) {
                    temp = lecture;
                    count++;
                }
            }

            if (count <= m) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }

        System.out.println(Math.max(answer, max));
    }
}
