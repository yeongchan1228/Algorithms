package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1475 { // 방 번호
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        int[] set = new int[10];

        for (int i = 0; i < str.length(); i++) {
            set[Character.getNumericValue(str.charAt(i))]++;
        }

        set[6] = (int) Math.ceil((double) (set[6] + set[9]) / 2); // 6과 9는 동일, 2.5일 경우를 대비해 올림

        int max = 0;
        for (int i = 0; i < set.length - 1; i++) {
            if(set[i] > max){
                max = set[i];
            }
        }
        
        System.out.println(max);
    }
}
