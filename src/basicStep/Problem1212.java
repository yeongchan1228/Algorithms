package basicStep;

import java.io.*;

public class Problem1212 { // 8진수 2진수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String binaryString = Integer.toBinaryString(str.charAt(i) - '0');
            if(i > 0 && binaryString.length() % 3 == 1) binaryString = "00" + binaryString;
            else if(i > 0 && binaryString.length() % 3 == 2) binaryString = "0" + binaryString;
            sb.append(binaryString);
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
