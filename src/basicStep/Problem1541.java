package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1541 { // 잃어버린 괄호
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine(), "-");

        int result = Integer.MAX_VALUE;
        int size = st.countTokens();
        for (int i = 0; i < size; i++) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            int st2Count = st2.countTokens();
            int var = 0;
            for (int j = 0; j < st2Count; j++) {
                var += Integer.parseInt(st2.nextToken());
            }
            if(result == Integer.MAX_VALUE) result = var;
            else result -= var;
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
