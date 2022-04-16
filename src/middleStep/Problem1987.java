package middleStep;

import java.io.*;
//import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem1987 { // 알파벳

    static int[][] map;
    static boolean[] alpha;
    static int row, col;
    static int max = Integer.MIN_VALUE;
//    static HashMap<Character, Integer> hashMap = new HashMap<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        alpha = new boolean[26];

        for (int i = 0; i < row; i++) {
            String str = in.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0, map[0][0]);

        out.write(String.valueOf(max));
        out.flush();
        out.close();

    }

    static void dfs(int depth, int x, int y, int result){
//        if(hashMap.containsKey(map[x][y])){
//            max = Math.max(max, depth);
//            return;
//        }
//        else {
//            hashMap.put(map[x][y], 0);
//            for (int i = 0; i < 4; i++) {
//                int pX = x + dx[i];
//                int pY = y + dy[i];
//                if (pX > -1 && pX < row && pY > -1 && pY < col) {
//                    dfs(depth + 1, pX, pY);
//                }
//            }
//            hashMap.remove(map[x][y]);
//        }
        if(alpha[result]){
            max = Math.max(max, depth);
            return;
        }else{
            alpha[result] = true;
            for (int i = 0; i < 4; i++) {
                int pX = x + dx[i];
                int pY = y + dy[i];
                if(pX > -1 && pX < row && pY > -1 && pY < col){
                    dfs(depth + 1, pX, pY, map[pX][pY]);
                }
            }
            alpha[result] = false;
        }

    }

}
