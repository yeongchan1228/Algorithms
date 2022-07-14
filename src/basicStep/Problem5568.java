package basicStep;

import java.io.*;
import java.util.HashSet;

public class Problem5568 { // 카드 놓기

    static int[] cards;
    static boolean[] visited;
    static int N, K;
    static HashSet<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        K = Integer.parseInt(in.readLine());

        cards = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(in.readLine());
        }

        calc(0, "");

        out.write(String.valueOf(result.size()));
        out.flush();
        out.close();
    }

    static void calc(int depth, String str) {
        if(depth == K) {
            if(!result.contains(str)) {
                result.add(str);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                calc(depth + 1, str + cards[i]);
                visited[i] = false;
            }
        }
    }
}
