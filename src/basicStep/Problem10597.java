package basicStep;

import java.io.*;

public class Problem10597 { // 순열 장난

    static int len;
    static String str;
    static boolean[] visited = new boolean[51];
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        str = in.readLine();
        len = str.length();

        dfs(0, 0, "");
    }

    static void dfs(int depth, int max, String ans) throws IOException {
        if(depth == len){
            for (int i = 1; i <= max; i++) {
                if(!visited[i]) return;
            }
            out.write(ans);
            out.flush();
            out.close();
            System.exit(0);
        }

        int parseInt = Character.getNumericValue(str.charAt(depth));
        if(parseInt > 0 && !visited[parseInt]){
            visited[parseInt] = true;
            dfs(depth + 1, Math.max(max, parseInt), ans + parseInt + " ");
            visited[parseInt] = false;
        }

        if(depth < len - 1){
            int parseInt2 = Integer.parseInt(str.substring(depth, depth + 2));
            if(parseInt > 0 && parseInt2 < 51 && !visited[parseInt2]){
                visited[parseInt2] = true;
                dfs(depth + 2, Math.max(max, parseInt), ans + parseInt2 + " ");
                visited[parseInt2] = false;
            }
        }
    }
}
