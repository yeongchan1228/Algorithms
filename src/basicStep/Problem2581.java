package basicStep;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2581 { // 소수
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        int M = in.nextInt();
        int N = in.nextInt();

        for (int i = M; i <= N; i++){
            for(int j = 2; j <= i; j++){
                if(i % j == 0 && j != i){
                    break;
                }
                if(i % j == 0 && j == i){
                    ans.add(i);
                }
            }
        }

        if(ans.isEmpty()){
            System.out.print("-1");
        }
        else {
            for(int k = 0; k < ans.size(); k++){
                sum = sum + ans.get(k);
            }
            System.out.println(sum);
            System.out.print(ans.get(0));
        }
    }
}
