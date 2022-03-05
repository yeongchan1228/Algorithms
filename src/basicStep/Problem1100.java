package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1100 { // 하얀 칸
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int result = 0;
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(in.readLine());
            if(i % 2 == 0){
                for (int j = 0; j < stringBuilder.length(); j++) {
                    if(stringBuilder.charAt(j) == 'F' && j % 2 == 0){
                        result++;
                    }
                }
            }else{
                for (int j = 0; j < stringBuilder.length(); j++) {
                    if(stringBuilder.charAt(j) == 'F' && j % 2 == 1){
                        result++;
                    }
                }
            }

            stringBuilder.setLength(0);
        }

        System.out.println(result);
    }

}
