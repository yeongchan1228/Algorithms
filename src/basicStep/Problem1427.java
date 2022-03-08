package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Problem1427 { // 소트인사이드
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        String[] strings = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            strings[i] = String.valueOf(str.charAt(i));
        }

        // 풀이 1
//        Arrays.sort(strings);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < strings.length; i++) {
//            stringBuilder.append(strings[i]);
//        }
//
//        System.out.println(stringBuilder.reverse().toString());

        // 풀이 2
        Arrays.sort(strings, Collections.reverseOrder());
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }

    }
}
