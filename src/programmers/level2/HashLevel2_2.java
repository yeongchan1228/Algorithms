package programmers.level2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashLevel2_2 { // 스파이

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
           map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }


        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            answer *= map.get(key) + 1;
        }
        answer = answer - 1;
        System.out.println("Answer : " + (answer - 1));
    }
}
