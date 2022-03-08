package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1065 { // 한수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if(i <= 99){
                count++;
            }
            else{
                String str = String.valueOf(i);
                int saveNum = 0;
                count++;
                for (int j = str.length() - 1; j > 0; j--) {
                    int getValue = Character.getNumericValue(str.charAt(j))
                            - Character.getNumericValue(str.charAt(j - 1)); // 자리 수 차이
                    if(saveNum != getValue && j != str.length() - 1){
                        count--;
                        break;
                    }
                    saveNum = getValue;
                }
            }
        }

        System.out.println(count);
    }
}
