package basicStep;

import java.io.*;
import java.util.Arrays;

public class Problem1181 { // 단어 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        String[] arr = new String[N];


        for (int i = 0; i < N; i++) {
            arr[i] = in.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder(arr[0] + "\n");

        for (int i = 1; i < N; i++) {
            if(!arr[i].equals(arr[i - 1])){
                sb.append(arr[i] + "\n");
            }
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
