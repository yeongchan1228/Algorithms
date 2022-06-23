package basicStep;

import java.io.*;
import java.util.*;

public class Problem11652 { // 카드
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        Map<Long, Integer> hashMap = new HashMap<>();

        int max = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(in.readLine());

            int count = hashMap.getOrDefault(val, 0) + 1;
            hashMap.put(val, count);

            if(max < count){
                max = count;
                result = val;
            }else if(max == count && result > val){
                result = val;
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
