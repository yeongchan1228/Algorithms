package basicStep;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1292 { // 쉽게 푸는 문제
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N1 = in.nextInt();
        int N2 = in.nextInt();
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N2; i++){
            for(int j = 1; j <= i; j++) {
                if(list.size() == N2){
                    break;
                }
                list.add(i);
            }
        }

        for(int k = N1 - 1; k < N2; k++){
            sum = sum + list.get(k);
        }
        System.out.print(sum);
    }
}
