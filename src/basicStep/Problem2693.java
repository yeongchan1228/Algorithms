package basicStep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2693 { // 3번 째로 큰 수
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        for(int i = 0; i < T; i++){
            for(int j = 0; j < 10; j ++){
                ans.add(in.nextInt());
            }
            Collections.sort(ans);
            ans2.add(ans.get(7));
            ans.clear();
        }
        for(int k = 0; k < ans2.size(); k++){
            if(k == ans2.size() - 1){
                System.out.print(ans2.get(k));
            }
            else
                System.out.println(ans2.get(k));
        }
    }
}
