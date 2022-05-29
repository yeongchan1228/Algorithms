package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1024 { // 수열의 합
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(st.nextToken());
        int minLen = Integer.parseInt(st.nextToken());

        int start = 0;
        while(true){
            int len = minLen - 1;
            int result = num - (len * (len + 1)) / 2;

            if(result < 0 || minLen > 100){
                print(out, "-1");
                return;
            }

            if(result % minLen == 0){
                start = result / minLen;
                break;
            }else{
                minLen++;
            }
        }

        for (int i = start; i < start + minLen; i++) {
            sb.append(i + " ");
        }
        print(out, sb.toString());
    }

    private static void print(BufferedWriter out, String result) throws IOException {
        out.write(result);
        out.flush();
        out.close();
    }
}
