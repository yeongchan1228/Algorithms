package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2089 { // -2 진수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringBuilder result = new StringBuilder();
        if (n == 0) {
            result.append("0");
        } else {
            while (n != 1) {
                result.append(Math.abs(n % -2));

                n = (int) Math.ceil((double) n / -2);
            }

            result.append(n);
        }

        System.out.println(result.reverse());
    }
}
