package basicStep;

import java.io.*;

public class Problem2839 { // 설탕 배달
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int val = Integer.parseInt(in.readLine());

        int result = -1;
        if(val == 4 || val == 7) result = -1;
        else if (val % 5 == 0) result = val / 5;
        else if (val % 5 == 1 || val % 5 == 3) result = (val / 5) + 1;
        else if (val % 5 == 2 || val % 5 == 4) result = (val / 5) + 2;

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
