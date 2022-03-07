package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >='A' && ch <= 'Z'){ // 대문자
                alphabet[ch - 65]++;
            }else{ // 소문자
                alphabet[ch - 97]++;
            }
        }

        int max = -1;
        char ch = '.';
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] > max){
                max = alphabet[i];
                ch = (char) (i + 65);
            }else if(alphabet[i] == max){
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
