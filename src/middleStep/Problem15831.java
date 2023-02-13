package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15831 { // 준표의 조약돌
    private static final char BLACK_COBBLESTONE = 'B';

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int left = 0;
        int whiteCnt = 0;
        int blackCnt = 0;
        int answer = 0;
        char[] cobblestones = in.readLine().toCharArray();
        for (int right = 0; right < n; right++) {
            if (cobblestones[right] == BLACK_COBBLESTONE) {
                blackCnt++;
            } else {
                whiteCnt++;
            }

            if (blackCnt <= b) {
                if (whiteCnt >= w) {
                    answer = Math.max(answer, whiteCnt + blackCnt);
                }
                continue;
            }

            while (blackCnt > b) {
                if (cobblestones[left++] == BLACK_COBBLESTONE) {
                    blackCnt--;
                } else {
                    whiteCnt--;
                }
            }
        }

        out.write(String.valueOf(answer));
        out.flush();
        in.close();
        out.close();
    }
}
