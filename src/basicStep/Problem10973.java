package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10973 { // 이전 순열
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        if (np(n - 1, arr)) {
            for (int i = 0; i < n; i++) {
                result.append(arr[i] + " ");
            }
        } else {
            result.append("-1");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }

    private static boolean np(int n, int arr[]) {
        int start = n;
        while (start > 0 && (arr[start] > arr[start - 1])) {
            start--;
        }

        if (start == 0) {
            return false;
        }

        int end = n;
        while (arr[start - 1] < arr[end]) end--;
        swap(arr, start - 1, end);

        while (start < n) {
            swap(arr, start++, n--);
        }

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
