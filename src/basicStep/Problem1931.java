package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem1931 { // 회의실 배정

    static int arr[][];
    static boolean visited[];
    static int max, N, last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if(endTime <= arr[i][0]) {
                endTime = arr[i][1];
                max++;
            }
        }

        out.write(String.valueOf(max));
        out.flush();
        out.close();
    }
}
