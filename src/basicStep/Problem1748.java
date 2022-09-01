package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1748 { // 수 이어 쓰기 1
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int result = 0;
        for (int i = 1; i <= n; i *= 10) {
            result += n - i + 1;
        }

        System.out.println(result);
    }
}
