package basicStep;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1789 { // 수 들의 합
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long S = in.nextLong();
        long up = 1;
        long tmp = 0;
        ArrayList<Long> arr = new ArrayList<>();

        while(true){
            S -= up;
            arr.add(up);

            if(S < 0){
                tmp = -S;
                for(int j = 0; j < arr.size(); j++){
                    if(arr.get(j) == tmp){
                        arr.remove(j);
                        break;
                    }
                }
                break;
            }
            up++;
        }

        System.out.print(arr.size());
    }
}
