package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1946 { // 신입 사원
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(in.readLine());

            int[] arr = new int[cnt + 1];
            for (int j = 0; j < cnt; j++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

//            int[][] grades = new int[cnt][2];
//
//            for (int j = 0; j < cnt; j++) {
//                StringTokenizer st = new StringTokenizer(in.readLine());
//                grades[j][0] = Integer.parseInt(st.nextToken());
//                grades[j][1] = Integer.parseInt(st.nextToken());
//            }
//
//            Arrays.sort(grades, ((o1, o2) -> o1[0] - o2[0]));

            int passCnt = 1;
//            int min = grades[0][1];
            int min = arr[1];
//            for (int j = 1; j < cnt; j++) {
//                int secondScore = grades[j][1];
//                if (secondScore < min) {
//                    min = secondScore;
//                    passCnt++;
//                }
//            }
            for (int j = 2; j <= cnt; j++) {
                int secondScore = arr[j];
                if (secondScore < min) {
                    min = secondScore;
                    passCnt++;
                }
            }

            result.append(passCnt + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
