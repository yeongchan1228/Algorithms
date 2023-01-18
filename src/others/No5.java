package others;

import java.util.*;
import java.io.*;

public class No5 { // 장애물 인식 프로그램
    private static char[][] map;
    private static int answer = 0;
    private static int[] di = {1, -1, 0, 0};
    private static int[] dj = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    answer = 0;
                    visited[i][j] = true;
                    dfs(i, j, n);
                    list.add(answer);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder(list.size() + "\n");
        for (int val : list) {
            sb.append(val + "\n");
        }

        out.write(sb.toString());
        out.flush();

        in.close();
        out.close();
    }

    private static void dfs(int i, int j, int n) {
        answer++;

        for (int k = 0; k < 4; k++) {
            int pi = i + di[k];
            int pj = j + dj[k];

            if (isValid(pi, pj, n)) {
                visited[pi][pj] = true;
                dfs(pi, pj, n);
            }
        }
    }

    private static boolean isValid(int pi, int pj, int n) {
        return pi > -1 && pi < n && pj > -1 && pj < n && map[pi][pj] == '1' && !visited[pi][pj];
    }
}
