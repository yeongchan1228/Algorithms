package middleStep;

import java.io.*;

public class Problem17609 { // 회문
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder answer = new StringBuilder();
        while (n --> 0) {
            char[] chars = in.readLine().toCharArray();

            Point point = new Point(0, chars.length - 1);
            if (check(point, chars)) {
                answer.append("0");
            } else {
                if (check(new Point(point.start + 1, point.end), chars) || check(new Point(point.start, point.end - 1), chars)) {
                    answer.append("1");
                } else {
                    answer.append("2");
                }
            }

            answer.append("\n");
        }

        out.write(answer.toString());
        out.flush();
        out.close();
    }

    private static boolean check(Point point, char[] chars) {
        while (point.start <= point.end) {
            if (chars[point.start] == chars[point.end]) {
                point.start++;
                point.end--;
                continue;
            }
            return false;
        }

        return true;
    }

    public static class Point {
        int start;
        int end;

        public Point(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }
}
