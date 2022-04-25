package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1759 { // 암호 만들기

    static char[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb;
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 문자 수
        arr = new char[C];
        selected = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);

        out.flush();
        out.close();
    }

    static void dfs(int start, int depth) throws IOException {
        if(depth == L){
            boolean checkC = false;
            int countC = 0;
            sb = new StringBuilder();

            for (int i = 0; i < L; i++) {
                char ch = selected[i];
                if(set.contains(selected[i]))  checkC = true;
                else countC++;
                sb.append(selected[i]);
            }

            if(checkC && countC > 1){
                out.write(sb.toString());
                out.write("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = arr[i];

                dfs(i + 1, depth + 1);

                visited[i] = false;
            }
        }
    }
}
