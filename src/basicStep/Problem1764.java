package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1764 { // 듣보잡
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 듣도 못한 수
        int M = Integer.parseInt(stringTokenizer.nextToken()); // 보도 못한 수

        HashMap<String, Integer> init = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        /**
         * 풀이 1 -> 성능 굿.
         */
        for (int i = 0; i < N + M; i++) {
            String member = in.readLine();
            init.put(member, init.getOrDefault(member, - 1) + 1);
        }

        Set<Map.Entry<String, Integer>> entries = init.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if(next.getValue() > 0){
                result.add(next.getKey());
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        /**
         * 풀이 2
         */
        /*for (int i = 0; i < N; i++) {
            init.put(in.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String member = in.readLine();
            if(init.containsKey(member)){
                result.add(member);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }*/

    }

}
