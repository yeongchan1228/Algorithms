package middleStep;

import java.io.*;

public class Problem1644 { // 소수의 연속합

    static int n;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());
        isNotPrime = new boolean[n + 1];
        calcPrime();

        int start = 2, end = 2, result = 0, saveNum = 0;
        while (start != n + 1 && end <= n + 1) {
            if (isNotPrime[start]) {
                start++;
                continue;
            }

            if (end != n + 1 && isNotPrime[end]) {
                end++;
                continue;
            }

            if (saveNum >= n) {
                if (saveNum == n){
                    result++;
                }
                saveNum -= start++;
            } else if (saveNum < n) {
                saveNum += end++;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();

    }

    static int calcPrime() {
        isNotPrime[0] = isNotPrime[1] = true;
        int totalPrimeCount = n - 2;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isNotPrime[j] = true;
                    totalPrimeCount--;
                }
            }
        }

        return totalPrimeCount;
    }
}
