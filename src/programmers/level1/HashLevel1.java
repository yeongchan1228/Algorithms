package programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashLevel1 { // 마라톤
    public static void main(String[] participant, String[] completion) {
        // 1번
        /*for(int i = 0; i < participant.length; i++){
            if(!participant[i].equals("0")) {
                for (int j = 0; j < completion.length; j++) {
                    if (participant[i].hashCode() == completion[j].hashCode()) {
                        participant[i] = "0";
                        completion[j] = "0";
                    }
                }
            }
        }

        String result = "";
        for(int i = 0; i < participant.length; i++){
            if(!participant[i].equals("0")){
                result = participant[i];
            }
        }
        System.out.println(result);*/

        //2번
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1); // 참가자가 없으면 0, 있으면 그 값을 반환해서 1을 더해줌
        }

        for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        String answer = "";

        while (iterator.hasNext()){
            String str = iterator.next();
            int value = map.get(str);
            if(value > 0){
                answer = str;
            }
        }
        System.out.println(answer);
    }
}
