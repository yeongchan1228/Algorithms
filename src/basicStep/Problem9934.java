package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9934 { // 완전 이진 트리

    static int N;
    static int[] arr;
    static StringBuilder[] sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        sb = new StringBuilder[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            sb[i] = new StringBuilder();
        }

        int len = (int) Math.pow(2, N) - 1;
        arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        calc(0, len, 0);

        for (int i = 0; i < N; i++) {
            if(sb[i].length() != 0) {
                out.write(sb[i].toString() + "\n");
            }
        }

        out.flush();
        out.close();
    }

    static void calc(int start, int end, int floor) {
        if (floor == N) return;

        int mid = (start + end) / 2;
        sb[floor].append(arr[mid] + " ");

        calc(start, mid - 1, floor + 1);
        calc(mid + 1, end, floor + 1);
    }
}
