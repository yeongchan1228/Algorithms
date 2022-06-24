package middleStep;

import java.io.*;
import java.util.*;

public class Problem7662 { // 이중 우선순위 큐
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int cnt = Integer.parseInt(in.readLine());
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(in.readLine());
                char order = st.nextToken().charAt(0);
                int val = Integer.parseInt(st.nextToken());

                if (order == 'I'){
                    treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
                } else if (order == 'D' && !treeMap.isEmpty()){
                    if (val == 1) {
                        Integer maxKey = treeMap.lastKey();
                        Integer maxVal = treeMap.get(maxKey);
                        if(maxVal > 1) treeMap.put(maxKey, maxVal - 1);
                        else treeMap.remove(maxKey);
                    }
                    else if (val == -1) {
                        Integer minKey = treeMap.firstKey();
                        Integer minVal = treeMap.get(minKey);
                        if(minVal > 1) treeMap.put(minKey, minVal - 1);
                        else treeMap.remove(minKey);
                    }
                }
            }

            if(treeMap.isEmpty()) sb.append("EMPTY" + "\n");
            else sb.append(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
