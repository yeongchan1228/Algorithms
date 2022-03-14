package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2331 { // 반복 수열

    static int A;
    static int P;
    static Map<Integer, Integer> arr = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

        A = Integer.parseInt(stringTokenizer.nextToken());
        P = Integer.parseInt(stringTokenizer.nextToken());

        arr.put(A, 0);
        System.out.println(dfs(A, 0));

    }

    static int dfs(int num, int depth){

        String str = String.valueOf(num);
        String[] split = str.split("");
        int calc = 0;
        for (int i = 0; i < split.length; i++) {
            int value = Integer.parseInt(split[i]);
            calc += (int) Math.pow(value, P);
        }

        if(arr.containsKey(calc)){
            return arr.get(calc);
        }

        arr.put(calc, depth + 1);
        return dfs(calc,depth + 1);
    }
}
