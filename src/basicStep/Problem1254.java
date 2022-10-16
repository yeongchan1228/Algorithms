package basicStep;

import java.io.*;

public class Problem1254 { // 펠린드롬 만들기

    static char[] chars;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        chars = in.readLine().toCharArray();

        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isPalindrome(i)) {
                result = chars.length + i;
                break;
            }
        }

        out.write(String.valueOf(result == 0 ? chars.length * 2 : result));
        out.flush();
        out.close();
    }

    static boolean isPalindrome(int start) {
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
