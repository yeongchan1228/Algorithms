package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1946 { // 통나무 건너뛰기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(in.readLine());
            int[] arr = new int[num];

            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] result = new int[num];
            int left = 0;
            int right = num - 1;
            for (int j = 0; j < num; j++) {
                if(j % 2 == 0){
                    result[left] = arr[j];
                    left++;
                }else {
                    result[right] = arr[j];
                    right--;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < num - 1; j++) {
                max = Math.max(max, Math.abs(result[j] - result[j + 1]));
            }

            sb.append(max + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
