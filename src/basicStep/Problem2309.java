package basicStep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2309 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        ArrayList<Integer> talls = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            talls.add(in.nextInt());
        }

        for(int i = 0; i < 9; i++) {
            sum = sum + talls.get(i);
        }

        for(int j = 0; j < talls.size() - 1; j++){
            for(int k = j + 1; k < talls.size(); k++){
                if(sum - talls.get(j) - talls.get(k) == 100){
                    talls.set(j, 0);
                    talls.set(k, 0);
                    Collections.sort(talls);
                    for(int f = 0; f < talls.size(); f++){
                        if(talls.get(f) > 0) {
                            if (f == talls.size() - 1) {
                                System.out.print(talls.get(f));
                            } else {
                                System.out.println(talls.get(f));
                            }
                        }
                    }
                    return;
                }
            }
        }
    }
}
