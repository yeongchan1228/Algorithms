package programmers.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LevelTest2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Arrays.toString(solution(in.readLine())));
    }

    private static int[] solution(String s) {
        int[] answer = {0, 0};

        while (true) {
            String replace = s.replaceAll("0", "");
            answer[0]++;
            answer[1] += s.length() - replace.length();

            String lenBinary = Integer.toString(replace.length(), 2);

            if(lenBinary.equals("1")) break;
            else s = lenBinary;
        }

        return answer;
    }
}
