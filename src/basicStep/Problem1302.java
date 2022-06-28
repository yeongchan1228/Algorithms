package basicStep;

import java.io.*;
import java.util.*;

public class Problem1302 { // 베스트셀러
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = in.readLine();
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list, ((o1, o2) -> {
            if(hashMap.get(o2) == hashMap.get(o1)){
                return o1.compareTo(o2);
            }
            return hashMap.get(o2) - hashMap.get(o1);
        }));

        out.write(list.get(0));
        out.flush();
        out.close();
    }
}
