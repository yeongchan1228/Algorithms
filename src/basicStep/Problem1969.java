package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1969 { // DNA
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        String[] arr = new String[n];
        char[] dna = {'A', 'T', 'G', 'C'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = in.readLine();
        }

        for (int i = 0; i < m; i++) {
            int[] cnt = new int[4];
            for (int j = 0; j < n; j++) {
                switch (arr[j].charAt(i)) {
                    case 'A' :
                        cnt[0]++;
                        break;
                    case 'T' :
                        cnt[1]++;
                        break;
                    case 'G' :
                        cnt[2]++;
                        break;
                    case 'C' :
                        cnt[3]++;
                        break;
                }
            }

            char minCh = dna[0];
            int max = cnt[0];
            for (int j = 1; j < 4; j++) {
                if(cnt[j] > max || (cnt[j] == max && dna[j] - minCh < 0)) {
                    max = cnt[j];
                    minCh = dna[j];
                }
            }
            sb.append(minCh);
            result += (n - max);
        }

        out.write(sb.toString() + "\n" + result);
        out.flush();
        out.close();
    }
}
