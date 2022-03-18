package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem1920 { // 수 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] str = in.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            hashMap.put(str[i], 1);
        }

        int M = Integer.parseInt(in.readLine());
        int[] compare = new int[M];

        String[] str2 = in.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            boolean contains = hashMap.containsKey(str2[i]);
            if(contains)
                sb.append("1").append('\n');
            else
                sb.append("0").append('\n');
        }

        System.out.println(sb);
    }
}
