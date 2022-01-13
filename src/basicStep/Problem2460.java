package basicStep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2460 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int outP = 0;
        int inP = 0;
        int sum = 0;
        ArrayList<Integer> people = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            outP = in.nextInt();
            inP = in.nextInt();

            if(i == 0){
                sum = inP;
                people.add(sum);
                continue;
            }

            sum = sum - outP + inP;
            people.add(sum);

            if (i == 9) {
                sum = sum - outP;
                people.add(sum);
            }
        }
        int max = Collections.max(people);
        System.out.print(max);
    }
}
