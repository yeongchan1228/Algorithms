package basicStep;

import java.io.*;
import java.util.Arrays;

public class Problem10610 { // 30

    static char[] chars;
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        chars = in.readLine().toCharArray();
        Arrays.sort(chars);

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += chars[i] - '0';
            sb.append(chars[i]);
        }

        if (chars[0] != '0' || sum % 3 != 0){
            print("-1");
            return;
        }

        print(sb.toString());
    }

    static void print(String result) throws IOException {
        out.write(result);
        out.flush();
        out.close();
    }
}
