package basicStep;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2609 { // 최대공약수 최소공배수
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N1 = in.nextInt();
        int N2 = in.nextInt();
        int gcf = 1; // 최대 공약수
        int lcm = 0; // 최소 공배수
        ArrayList<Integer> ans = new ArrayList<>();

        if(N1 > N2){
            for(int i = 2; i <= N1; i++){
                if(N1 % i == 0 && N2 % i == 0){
                    N1 = N1 / i;
                    N2 = N2 / i;
                    ans.add(i);
                    i = 1;
                }
            }
            for(int j = 0; j < ans.size(); j++){
                gcf = gcf * ans.get(j);
            }
            System.out.println(gcf);
            lcm = gcf * N1 * N2;
            System.out.print(lcm);
        }
        else{
            for(int i = 2; i <= N2; i++){
                if(N1 % i == 0 && N2 % i == 0){
                    N1 = N1 / i;
                    N2 = N2 / i;
                    ans.add(i);
                    i = 1;
                }
            }
            for(int j = 0; j < ans.size(); j++){
                gcf = gcf * ans.get(j);
            }
            System.out.println(gcf);
            lcm = gcf * N1 * N2;
            System.out.print(lcm);
        }
    }
}
