package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2503 { // 숫자 야구

    static int n;
    static Info[] infos;
    static final int MIN_VAL = 123;
    static final int MAX_VAL = 987;
    static final int MAX_CNT = 3;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());
        infos = new Info[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            infos[i] = new Info(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        out.write(String.valueOf(calc()));
        out.flush();
        out.close();
    }

    static int calc() {
        int result = 0;

        for (int i = MIN_VAL; i <= MAX_VAL; i++) {
            if (checkValue(i)) {
                continue;
            }

            int cnt = 0;
            for (Info info : infos) {
                int strikeCnt = checkStrike(info.number, String.valueOf(i));
                int ballCnt = checkBall(info.number, String.valueOf(i));

                if (strikeCnt == info.strike && ballCnt == info.ball) {
                    cnt++;
                } else {
                    break;
                }
            }

            if (cnt == n) {
                result++;
            }
        }

        return result;
    }

    static int checkStrike(String number, String answer) {
        int cnt = 0;

        for (int i = 0; i < MAX_CNT; i++) {
            if (number.charAt(i) == answer.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    static int checkBall(String number, String answer) {
        int cnt = 0;

        for (int i = 0; i < MAX_CNT; i++) {
            if (number.charAt(i) == answer.charAt((i + 1) % 3) || number.charAt(i) == answer.charAt((i + 2) % 3)) {
                cnt++;
            }
        }

        return cnt;
    }

    static boolean checkValue(int num) {
        char[] chars = String.valueOf(num).toCharArray();

        for (int i = 0; i < MAX_CNT; i++) {
            if (chars[i] == '0') {
                return true;
            }
        }

        for (int i = 0; i < MAX_CNT; i++) {
            for (int j = 0; j < MAX_CNT; j++) {
                if (i == j) continue;

                if (chars[i] == chars[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    static class Info {
        String number;
        int strike;
        int ball;

        public Info(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
