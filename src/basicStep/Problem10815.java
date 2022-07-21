package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem10815 { // 숫자 카드
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        Set<Integer> cards = new HashSet<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(in.readLine());
        int[] arr = new int[m];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            if(cards.contains(Integer.parseInt(st.nextToken()))) arr[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(arr[i] + " ");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
