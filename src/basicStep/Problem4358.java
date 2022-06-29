package basicStep;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem4358 { // 생태학
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalCnt = 0;
        String tree;
        Map<String, Integer> hashMap = new HashMap<>();
        while ((tree = in.readLine()) != null){
            totalCnt++;
            hashMap.put(tree, hashMap.getOrDefault(tree, 0) + 1);
        }

        ArrayList<String> keys = new ArrayList<>(hashMap.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            Integer treeCnt = hashMap.get(key);
            sb.append(key + " " + String.format("%.4f", ((double) treeCnt / totalCnt) * 100) + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
