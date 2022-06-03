package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Problem11478 { // 서로 다른 부분 문자의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }

        out.write(String.valueOf(set.size()));
        out.flush();
        out.close();
    }
}
