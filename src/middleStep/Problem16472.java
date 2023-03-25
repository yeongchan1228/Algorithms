package middleStep;

import java.io.*;

public class Problem16472 { // 고냥이
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        char[] chars = in.readLine().toCharArray();

        int start = 0;
        int end = 0;
        int[] alpha = new int[26];

        int diff = 0;
        int answer = 0;
        while (end < chars.length) {
            int idx = chars[end++] - 'a';
            alpha[idx]++;

            if (alpha[idx] == 1) {
                diff++;
            }

            while (diff > n) {
                int saveIdx = chars[start++] - 'a';
                alpha[saveIdx]--;

                if (alpha[saveIdx] == 0) {
                    diff--;
                }
            }

            answer = Math.max(answer, end - start);
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }
}
