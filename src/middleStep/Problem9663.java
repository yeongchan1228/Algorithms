package middleStep;

import java.io.*;

public class Problem9663 { // N-Queen

    static int[] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        map = new int[N];

        dfs(0, N);

        out.write(String.valueOf(count));
        out.flush();
        out.close();

    }

    static void dfs(int depth, int size){
        if(depth == size){
            count++;
            return;
        }

        for (int i = 0; i < size; i++) {
            map[depth] = i;

            boolean check = false;
            for (int j = 0; j < depth; j++) {
                if(map[depth] == map[j]){
                    check = true;
                    break;
                }
                else if(Math.abs(depth - j) == Math.abs(map[j] - map[depth])){
                    check = true;
                    break;
                }

            }

            if(!check)
                dfs(depth + 1, size);
        }

    }
}
