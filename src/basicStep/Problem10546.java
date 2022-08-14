package basicStep;

import java.io.*;
import java.util.HashMap;

public class Problem10546 { // 배부른 마라토너
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = n - 1;

        HashMap<String, Integer> hashMap = new HashMap<>();
        while (n --> 0) {
            String name = in.readLine();
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        while (m --> 0) {
            String name = in.readLine();
            hashMap.put(name, hashMap.get(name) - 1);
        }

        for (String name : hashMap.keySet()) {
            if (hashMap.get(name) > 0) {
                System.out.println(name);
                break;
            }
        }
    }
}
