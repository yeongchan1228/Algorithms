package basicStep;

import java.io.*;
import java.util.Stack;

public class Problem3986 { // 좋은 단어
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        int cnt = Integer.parseInt(in.readLine());
        for (int i = 0; i < cnt; i++) {
            char[] chars = in.readLine().toCharArray();
            Stack<Character> characters = new Stack<>();

            for (int j = 0; j < chars.length; j++) {
                if (characters.isEmpty() || characters.peek() != chars[j]) {
                    characters.push(chars[j]);
                } else if (characters.peek() == chars[j]) {
                    characters.pop();
                }
            }

            if (characters.isEmpty()) result++;
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
