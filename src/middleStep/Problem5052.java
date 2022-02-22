package middleStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem5052 { // 전화번호 목록
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map;
        String[] str;
        ArrayList<String> result = new ArrayList<>();

        int N = Integer.parseInt(in.readLine());
        int cnt;
        boolean check = false;
        for(int i = 0; i < N; i++) {
            map = new HashMap<>();
            cnt = Integer.parseInt(in.readLine());
            str = new String[cnt];
            check = false;
            for (int j = 0; j < cnt; j++) {
                String col = in.readLine();
                str[j] = col;
                map.put(col, j);
            }

            for(int j = 0; j < str.length; j++){
                for(int k = 1; k < str[j].length(); k++){
                    if(map.containsKey(str[j].substring(0, k))){
                        result.add("NO");
                        check = true;
                        break;
                    }
                }
                if(check)
                    break;
            }
            if(!check)
                result.add("YES");
        }

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

    }

}
