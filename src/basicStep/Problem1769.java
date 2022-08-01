package basicStep;

import java.io.*;

public class Problem1769 { // 3의 배수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        String str = in.readLine();

        while(true) {
            long sum = 0;
            if(str.length() == 1) {
                break;
            }
            for(int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            cnt++;
            str = String.valueOf(sum);
        }

        StringBuilder sb = new StringBuilder(String.valueOf(cnt) + "\n");
        sb.append(Integer.parseInt(str) % 3 == 0 ? "YES" : "NO");

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
