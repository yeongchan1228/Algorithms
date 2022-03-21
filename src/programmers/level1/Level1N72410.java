package programmers.level1;

import java.util.Locale;

public class Level1N72410 { // 신규 아이디 추천
    public static void main(String[] args) {
        String new_id = "123_.def";

        new_id = new_id.toLowerCase(Locale.ROOT);

        new_id = new_id.replaceAll("[^a-z0-9-._]","");

        new_id = new_id.replaceAll("[.]{2,}", ".");

        if(new_id.length() > 0 && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1, new_id.length());
        }

        if(new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.'){
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        if(new_id.isEmpty()){
            new_id = "a";
        }

        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);

            if(new_id.charAt(14) == '.'){
                new_id = new_id.substring(0, 14);
            }
        }

        if(new_id.length() <= 2){
            char c = new_id.charAt(new_id.length() - 1);

            while (new_id.length() <= 2){
                new_id = new_id.concat(String.valueOf(c));
            }
        }

        System.out.println(new_id);
    }
}
