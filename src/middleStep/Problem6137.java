package middleStep;

import java.io.*;

public class Problem6137 { // 문자열 생성
    private static final int CHANGE_LINE_NUMBER = 80;
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(in.readLine());
        }

        char[] s = sb.toString().toCharArray();
        int left = 0;
        int right = s.length - 1;
        int idx = 0;
        sb.setLength(0);
        while (left <= right) {
            if (s[left] - 'A' < s[right] - 'A') {
                sb.append(s[left++]);
            } else if (s[left] - 'A' == s[right] - 'A') {
                int start = left;
                int end = right;

                boolean isFinish = true;
                while (s[start] == s[end]) {
                    start++;
                    end--;

                    if (start == s.length || end < 0 || start == end) {
                        isFinish = false;
                        sb.append(s[left++]);
                        break;
                    }
                }

                if (isFinish) {
                    if (s[start] - 'A' < s[end] - 'A') {
                        sb.append(s[left++]);
                    } else {
                        sb.append(s[right--]);
                    }
                }
            } else {
                sb.append(s[right--]);
            }

            idx++;
            if (idx % CHANGE_LINE_NUMBER == 0) {
                sb.append("\n");
            }
        }

        out.write(sb.toString());
        out.flush();
        in.close();
        out.close();
    }
}
