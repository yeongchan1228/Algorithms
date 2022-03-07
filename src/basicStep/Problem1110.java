package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String first = in.readLine();
        if(first.length() == 1){
            first = "0"+first;
        }
        String result = "";
        result = first;

        for (int i = 0; i > -1; i++) {
            if (first.equals(result) && i != 0) {
                System.out.println(i);
                break;
            }

            int save = 0;
            for (int j = 0; j < result.length(); j++) {
                save += Character.getNumericValue(result.charAt(j));
            }
            String str2 = String.valueOf(save);
            if(str2.length() == 1){
                str2 = "0"+str2;
            }

            result = String.valueOf(result.charAt(1)) + String.valueOf(str2.charAt(1));
        }
    }
}
