package basicStep;

import java.util.Scanner;

public class Problem1463 { // 1로 만들기

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count[] = new int[N + 1];
        count[0] = count[1] = 0;

        for(int i = 2; i <= N; i++){
            count[i] = count[i - 1] + 1;
            if(i % 6 == 0){
                count[i] = Math.min(count[i], Math.min(count[i/2] + 1, count[i/3] + 1));
            }
            else if(i % 3 == 0){
                count[i] = Math.min(count[i], count[i/3] + 1);
            }
            else if(i % 2 == 0){
                count[i] = Math.min(count[i], count[i/2] + 1);
            }
        }
        System.out.print(count[N]);

    }
}
