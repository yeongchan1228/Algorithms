package basicStep;

import java.io.*;
import java.util.Arrays;

public class Problem1431 { // 시리얼 번호
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        String[] arr = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = in.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            else if (o1.length() == o2.length()) {
                int o1Sum = 0, o2Sum = 0;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < o1.length(); j++) {
                        if (i == 0 && o1.charAt(j) >= '1' && o1.charAt(j) <= '9') {
                            o1Sum += o1.charAt(j) - '0';
                        } else if (i == 1 && o2.charAt(j) >= '1' && o2.charAt(j) <= '9') {
                            o2Sum += o2.charAt(j) - '0';
                        }
                    }
                }

                if (o1Sum != o2Sum) return o1Sum - o2Sum;
            }

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(arr[i] + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
