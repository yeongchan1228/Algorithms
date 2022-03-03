package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1075 { // 나누기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int F = Integer.parseInt(in.readLine());


        int save = (N / 100) * 100; // -> N의 2자리를 0으로 만들기

        int result = 0;
        for(int i = 0; i < 100; i++){
            if(save % F == 0){
                result = i;
                break;
            }
            save++;
        }

        if(result < 10){
            System.out.print("0"+result);
        }else{
            System.out.print(result);
        }
    }
}
