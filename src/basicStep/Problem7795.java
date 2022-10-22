package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7795 { // 먹을 것인가 먹힐 것인가
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] arrA = new int[a];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < a; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            int[] arrB = new int[b];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < b; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int cnt = 0;
            int checkA = 0, checkB = 0;
            while (checkB < b && checkA < a) {
                if (arrA[checkA] > arrB[checkB]) {
                    checkB++;
                    cnt += (a - checkA);
                } else {
                    checkA++;
                }
            }

            result.append(cnt + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
