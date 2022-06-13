package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14490 { // 백대열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine(), ":");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int gcd = gcd(n, m);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d:%d", n/gcd, m/gcd));
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static int gcd(int n, int m){
        if(m == 0) return n;
        return gcd(m, n % m);
    }
}
