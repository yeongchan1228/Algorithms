package basicStep;

import java.io.*;

public class Problem15904 { // UCPC는 무엇의 약자일까?
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();

        boolean isU = false, isFC = false, isP = false, isLC = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'U') {
                isU = true;
            } else if(!isP && isU && ch == 'C') {
                isFC = true;
            } else if(isFC && ch == 'P') {
                isP = true;
            } else if(isP && ch == 'C') {
                isLC = true;
                break;
            }
        }

        if(isU && isFC && isP && isLC) out.write("I love UCPC");
        else out.write("I hate UCPC");

        out.flush();
        out.close();
    }
}
