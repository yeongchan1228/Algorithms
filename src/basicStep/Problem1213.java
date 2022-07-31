package basicStep;

import java.io.*;

public class Problem1213 { // 펠린드롬 만들기

//    static String front, mid, back;
    static int oddIdx = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[26];
        char[] chars = in.readLine().toCharArray();

        int length = chars.length;
        for (int i = 0; i < length; i++) {
            alphabet[chars[i] - 'A']++;
        }

        StringBuilder result = new StringBuilder();
        if(length % 2 == 0) {
//            calc(alphabet, true);
            calcHead(result, alphabet, true);
            calcLast(result, alphabet);
        } else {
//            calc(alphabet, false);
            calcHead(result, alphabet, false);
            result.append((char) ('A' + oddIdx));
            calcLast(result, alphabet);

        }

        print(result.toString());

//        if (mid.length() != 0) print(front + mid + back);
//        else print(front + back);
    }

    private static StringBuilder calcHead(StringBuilder sb, int[] alpha, boolean isOdd) throws IOException {
        for (int i = 0; i < alpha.length; i++) {
            if (isOdd && alpha[i] % 2 != 0) print("I'm Sorry Hansoo");
            else if (!isOdd && alpha[i] % 2 != 0) {
                if (oddIdx != -1) print("I'm Sorry Hansoo");
                else {
                    oddIdx = i;
                    alpha[i]--;
                }
            }

            sb.append(String.valueOf((char) ('A' + i)).repeat(alpha[i] / 2));

        }

        return sb;
    }

    private static StringBuilder calcLast(StringBuilder sb, int[] alpha) {
        for (int i = alpha.length - 1; i >= 0; i--) {
            sb.append(String.valueOf((char) ('A' + i)).repeat(alpha[i] / 2));
        }

        return sb;
    }

//    private static void calc(int[] alphabet, boolean isTrue) throws IOException {
//        front = back = mid = "";
//        for (int i = 0; i < 26; i++) {
//            if (isTrue && alphabet[i] % 2 != 0) {
//                print("I'm Sorry Hansoo");
//            }
//
//            int alphaLen = alphabet[i];
//            if (!isTrue && alphaLen % 2 != 0) {
//                alphaLen--;
//
//                if (mid.length() != 0) print("I'm Sorry Hansoo");
//                else mid += (char) ('A' + i);
//            }
//
//            for (int j = 0; j < alphaLen; j++) {
//                if (j % 2 == 0) {
//                    front += (char) ('A' + i);
//                } else {
//                    back = (char) ('A' + i) + back;
//                }
//            }
//        }
//    }

    static void print(String result) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        out.write(result);
        out.flush();
        out.close();
        System.exit(0);
    }
}
