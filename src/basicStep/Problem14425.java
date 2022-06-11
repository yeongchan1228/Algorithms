package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem14425 { // 문자열 집합
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            S.add(in.readLine());
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            if(S.contains(in.readLine())) result++;
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
