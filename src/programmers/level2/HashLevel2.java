package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class HashLevel2 { // 전화번호 목록

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = true;

        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], false);
        }

        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    answer = false;
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}
