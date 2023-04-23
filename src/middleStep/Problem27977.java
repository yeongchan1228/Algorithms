package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem27977 { // 킥보드로 등교하기

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] chargers = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < chargers.length; i++) {
            chargers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = l;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (!check(mid, n, l, k, chargers)) {
                start = mid + 1;
                continue;
            }

            answer = mid;
            end = mid - 1;
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    private static boolean check(int mid, int n, int l, int k, int[] chargers) {
        int prev = 0;
        int used = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int distance = chargers[i] - prev;
            if (distance > mid) {
                return false;
            }

            used += distance;
            if (used == mid) {
                count++;
                used = 0;
            } else if (used > mid) {
                count++;
                used = distance;
            }

            prev = chargers[i];
        }

        int distance = l - prev;
        if (distance > mid) {
            return false;
        }

        if (used + distance > mid) {
            count++;
        }

        if (count > k) {
            return false;
        }

        return true;
    }
}
