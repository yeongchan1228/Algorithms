package basicStep;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2529 { // 부등호

    static int N;
    static char[] m;
    static boolean[] check = new boolean[10];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        m = new char[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = st.nextToken().charAt(0);
        }

        dfs("", 0);
        Collections.sort(list);

        out.write(list.get(list.size() - 1) + "\n" + list.get(0));
        out.flush();
        out.close();
    }

    static void dfs(String str, int depth){
        if(depth == N + 1){
            list.add(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!check[i]){
               if(depth == 0 || checkNum(str.charAt(depth - 1), i, m[depth - 1])){
                   check[i] = true;
                   dfs(str + i, depth + 1);
                   check[i] = false;
               }
            }
        }
    }

    private static boolean checkNum(char charAt, int i, char c) {
        if(c == '>'){
            if(Character.getNumericValue(charAt) > i) return true;
        }else{
            if(Character.getNumericValue(charAt) < i) return true;
        }
        return false;
    }
}
