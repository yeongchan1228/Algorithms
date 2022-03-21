package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2941 { // 크로티아 알파벳
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] alpha = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        StringBuilder sb = new StringBuilder(in.readLine());

        int length = sb.length();
        for (int i = 0; i < 8; i++) {
            int index = sb.indexOf(alpha[i]);
            while (index != -1){
                if(i == 0){
                    sb.replace(index, index+3, "...");
                    length -= 2;
                }else {
                    sb.replace(index, index+2, "..");
                    length -= 1;
                }
                index = sb.indexOf(alpha[i]);
            }

        }

        System.out.println(length);
    }
}
