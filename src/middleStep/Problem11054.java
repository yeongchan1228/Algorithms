package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11054 { // 가장 긴 바이토닉 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N + 1];
        int[] dpA = new int[N + 1];
        int[] dpB = new int[N + 1];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dpA[i] = 1;

            for (int j = 1; j <= i; j++) {
                if(arr[j] < arr[i] && dpA[i] <= dpA[j]){
                    dpA[i] = dpA[j] + 1;
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            dpB[i] = 1;

            for (int j = N; j >= i; j--) {
                if(arr[i] > arr[j] && dpB[i] <= dpB[j]){
                    dpB[i] = dpB[j] + 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            dpA[i] = dpA[i] + dpB[i] - 1;
        }

        out.write(String.valueOf(Arrays.stream(dpA).max().getAsInt()));
        out.flush();
        out.close();
    }
}
