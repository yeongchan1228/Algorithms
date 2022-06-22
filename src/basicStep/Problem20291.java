package basicStep;

import java.io.*;
import java.util.*;

public class Problem20291 { // 파일 정리
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        Map<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
//            String[] strings = in.readLine().split("\\.");
//            treeMap.put(strings[1], treeMap.getOrDefault(strings[1], 0) + 1);
            String str = in.readLine();
            String ext = str.substring(str.lastIndexOf(".") + 1);
            treeMap.put(ext, treeMap.getOrDefault(ext, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : treeMap.keySet()) {
            sb.append(str + " " + treeMap.get(str) + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
