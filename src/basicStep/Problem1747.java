package basicStep;

import java.io.*;

/**
 * Created by YC on 2022/09/28.
 */
public class Problem1747 { // 소수&팰린드롬

    final static int max = 1004002;

    public static void main(String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        boolean[] isNotPrime = calcPrime();

        int result = 0;
        for (int i = 0; i < max; i++) {
            if (!isNotPrime[i] && i >= n) {
                if (isPelin(String.valueOf(i))) {
                    result = i;
                    break;
                }
            }
        }

        out.write(String.valueOf(String.valueOf(result)));
        out.flush();
        out.close();
    }

    private static boolean[] calcPrime() {
        boolean[] isNotPrime = new boolean[max];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < Math.sqrt(max); i++) {
            for (int j = i * i; j < max; j += i) {
                isNotPrime[j] = true;
            }
        }
        return isNotPrime;
    }

    static boolean isPelin(String val) {
        int start = 0, end = val.length() - 1;
        while (start < end) {
            if (val.charAt(start) != val.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
