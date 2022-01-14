package basicStep;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1978 { // 소수 찾기
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < N; i++){
            ans.add(in.nextInt());
        }

        for(int j = 0; j < ans.size(); j++){
            int test = ans.get(j);
            for(int k = 2; k <= test; k++){
                if(test % k == 0 && k != test){
                    break;
                }
                if(test % k == 0 && k == test){
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
