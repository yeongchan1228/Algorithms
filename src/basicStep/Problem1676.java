package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1676 { // 팩토리얼 0의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(in.readLine());
        int count = 0;

        while (num >= 5){
            count += num / 5;
            num = num / 5;
        }

        System.out.println(count);
    }

}
