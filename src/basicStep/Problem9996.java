package basicStep;

import java.io.*;
import java.util.regex.Pattern;

public class Problem9996 { // 한국이 그리울 땐 서버에 접속하지
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        String regex = "^" + in.readLine().replaceAll("\\*", ".*") + "$";
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            boolean isTrue = Pattern.matches(regex, str);

            if (isTrue) result.append("DA" + "\n");
            else result.append("NE" + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
