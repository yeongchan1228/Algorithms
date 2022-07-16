package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem5635 { // 생일
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());

        String[][] arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[3].equals(o2[3])) {
                if (o1[2].equals(o2[2])) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }
            return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
        });

        out.write(arr[N - 1][0] + "\n" + arr[0][0]);
        out.flush();
        out.close();
    }
}
