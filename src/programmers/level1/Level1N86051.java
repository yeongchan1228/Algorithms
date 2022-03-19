package programmers.level1;

import java.util.HashMap;

public class Level1N86051 {
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};

        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i], 1);
        }

        for (int i = 0; i < 10; i++) {
            boolean cotains = hashMap.containsKey(i);
            if(!cotains)
                answer += i;
        }

        System.out.println(answer);
    }
}
