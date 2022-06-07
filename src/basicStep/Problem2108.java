package basicStep;

import java.io.*;
import java.util.*;

public class Problem2108 { // 통계학
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(Arrays.stream(arr).average().getAsDouble()) + "\n");

        Arrays.sort(arr);
        sb.append(arr[N/2] + "\n");

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        Integer max = Collections.max(map.values());
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue().intValue() == max.intValue()){
                list.add(entry.getKey());
            }
        }

        if(list.size() == 1) sb.append(list.get(0) + "\n");
        else if(list.size() > 1) {
            sb.append(list.get(1) + "\n");
        }

        sb.append(arr[N - 1] - arr[0]);

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
