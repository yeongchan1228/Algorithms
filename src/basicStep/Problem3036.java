package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/09.
 */
public class Problem3036 { // 링
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        int first = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            int gcd = calcGcd(first, next);
            result.append((first / gcd) + "/" + (next / gcd) + "\n");
        }

        System.out.println(result.toString());
    }

    static int calcGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
