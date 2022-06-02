package basicStep;

import java.io.*;
import java.util.HashMap;

public class Problem2002 { // 추월
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            hashMap.put(in.readLine(), i);
        }

        int result = 0;
        int[] pass = new int[N];
        for (int i = 0; i < N; i++) {
            pass[i] = hashMap.get(in.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(pass[i] > pass[j]) {
                    result++;
                    break;
                }
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
