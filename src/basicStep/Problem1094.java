package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1094 { // 막대 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int bar = 64;
        int requiredBar = Integer.parseInt(in.readLine());

        ArrayList<Integer> result = new ArrayList<>();

        while(true){
            result.add(bar);
            int size = result.stream().mapToInt(Integer::intValue).sum();
            if(size > requiredBar){ // 크면
                int getBar = result.get(result.size() - 1); // 마지막 값
                bar = getBar / 2;
                result.remove(result.size() - 1);
            }else if(size == requiredBar){ // 같으면
                break;
            }else{ // 작으면
                bar /= 2;
            }
        }
        System.out.println(result.size());
    }
}
