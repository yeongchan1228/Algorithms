package basicStep;

import java.io.*;

public class Problem5525 { // IOIOI
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int sLen = Integer.parseInt(in.readLine());
        char[] chars = in.readLine().toCharArray();

        int pCnt = 0;
        int result = 0;
        for (int i = 0; i < sLen - 2; i++) {
            if(chars[i] == 'O') continue;

            if(chars[i] == 'I' && chars[i + 1] == 'O' && chars[i + 2] == 'I') {
                pCnt++;
                if(pCnt == N){
                    pCnt--;
                    result++;
                }
                i++;
            } else pCnt = 0;
        }

//        int result = 0;
//        for (int i = 0; i < sLen - (str.length() - 1); i++) {
//            if(S.startsWith(str, i)) result++;
//        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
