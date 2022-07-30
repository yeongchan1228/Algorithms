package basicStep;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem13305 { // 주유소

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine()) - 1;
        int[] price = new int[cnt];
        int[] km = new int[cnt];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < cnt; i++) {
            km[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < cnt; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (i > 0 && price[i - 1] < val) price[i] = price[i - 1];
            else price[i] = val;
        }

        BigInteger result = new BigInteger("0");
        for (int i = 0; i < cnt; i++) {
            BigInteger multiply = BigInteger.valueOf(price[i]).multiply(BigInteger.valueOf(km[i]));
            result = result.add(multiply);
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
