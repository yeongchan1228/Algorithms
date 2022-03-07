package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while(true){
            String str = in.readLine();
            if(str.equals("0")){
                break;
            }

            StringBuffer stringBuffer = new StringBuffer(str);
            if(str.equals(stringBuffer.reverse().toString())){
                stringBuilder.append("yes ");
            }else{
                stringBuilder.append("no ");
            }
        }

        StringTokenizer stringTokenizer = new StringTokenizer(stringBuilder.toString());
        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
    }
}
