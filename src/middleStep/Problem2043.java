package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2043 {
    static long[] arr, segmentTree;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        segmentTree = new long[n * 4];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(in.readLine());
        }

        init(0, n - 1, 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(0, n - 1, 1, b - 1, c - arr[b - 1]);
                continue;
            }

            result.append(sum(0, n - 1, 1, b - 1, c - 1) + "\n");
        }

        out.write(result.toString().trim());
        out.flush();
        out.close();
    }

    public static long init(int start, int end, int node) {
        if (start == end) {
            return segmentTree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static void update(int start, int end, int node, int index, long diff) {
        if (start > index || end < index) {
            return;
        }

        segmentTree[node] += diff;
        if (start == end) {
            arr[index] = segmentTree[node];
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }

    public static long sum(int start, int end, int node, long left, long right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}
