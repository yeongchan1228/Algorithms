package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem6581 { // HTML
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str, result = "";
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while ((str = in.readLine()) != null){
            st = new StringTokenizer(str);
            while (st.hasMoreTokens()){
                String token = st.nextToken();

                if(token.equals("<br>")) {
                    sb.append(result.trim() + "\n");
                    result = "";
                }
                else if(token.equals("<hr>")){
                    if(result.length() != 0) {
                        sb.append(result.trim() + "\n");
                        result = "";
                    }
                    sb.append("-".repeat(80) + "\n");
                }else {
                    if(result.length() + token.length() > 80){
                        sb.append(result.trim() + "\n");
                        result = "";
                    }
                    result += token + " ";
                }
            }
        }

        out.write(sb.toString() + result.trim());
        out.flush();
        out.close();
    }
}
