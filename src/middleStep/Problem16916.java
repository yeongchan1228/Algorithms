package middleStep;

import java.io.*;

public class Problem16916 { // 부분 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();
        String pattern = in.readLine();

        out.write(String.valueOf(kmp(str, pattern)));
        out.flush();
        out.close();
    }

    static int kmp(String str, String pattern){
        int[] table = makeTable(pattern);
        int strLen = str.length();
        int patternLen = pattern.length();

        int cnt = 0;
        for (int i = 0; i < strLen; i++) {

            while (cnt > 0 && str.charAt(i) != pattern.charAt(cnt)){
                cnt = table[cnt - 1];
            }

            if(str.charAt(i) == pattern.charAt(cnt)){
                if(cnt == patternLen - 1) return 1;
                else cnt++;
            }
        }

        return 0;
    }

    static int[] makeTable(String pattern){
        int length = pattern.length();
        int[] table = new int[length];

        int cnt = 0;
        for (int i = 1; i < length; i++) {
            while (cnt > 0 && pattern.charAt(i) != pattern.charAt(cnt)){
                cnt = table[cnt - 1];
            }

            if(pattern.charAt(i) == pattern.charAt(cnt)){
                cnt++;
                table[i] = cnt;
            }
        }

        return table;
    }
}