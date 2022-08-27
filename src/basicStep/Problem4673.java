package basicStep;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Problem4673 { // 셀프 넘버
    private final static int MAX = 10000;
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] integers = new boolean[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            int sum = i;
            char[] digits = String.valueOf(i).toCharArray();
            for (char digit : digits) {
                int sum1 = digit - '0';
                sum += sum1;
            }

            if (sum <= MAX) {
                integers[sum] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= MAX; i++) {
            if (!integers[i]) {
                result.append(i + "\n");
            }
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
