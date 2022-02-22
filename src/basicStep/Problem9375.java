package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem9375 { // 패션왕 신해빈

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map;
        ArrayList<Integer> result = new ArrayList<>();

        int N = Integer.parseInt(in.readLine());
        int cnt, fin;

        for(int i = 0; i < N; i++){
            cnt = Integer.parseInt(in.readLine());
            fin = 1;
            map = new HashMap<>();
            for(int j = 0; j < cnt; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
                String str1 = stringTokenizer.nextToken();
                String str2 = stringTokenizer.nextToken();
                map.put(str2, map.getOrDefault(str2, 0) + 1);
            }
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                fin *= map.get(key) + 1;
            }
            fin -= 1;
            result.add(fin);
        }
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
