package basicStep;

import java.util.Scanner;

public class Problem1303 {

    static char[][] map;
    static boolean[][] visited;
    static int N, M = 0;
    static int count = 0;
    static int result1, result2 = 0;

    public static void dfs(char c, int n, int m){
        visited[n][m] = true;
        count++;

        if(n - 1 > -1 && map[n-1][m] == c && !visited[n-1][m]){ // 위 탐색
            dfs(c, n-1, m);
        }
        if(n + 1 < N && map[n+1][m] == c && !visited[n+1][m]){ // 아래 탐색
            dfs(c, n+1, m);
        }
        if(m + 1 < M && map[n][m+1] == c && !visited[n][m+1]){ // 오른쪽 탐색
            dfs(c, n, m+1);
        }
        if(m - 1 > -1 && map[n][m-1] == c && !visited[n][m-1]){ // 왼쪽 탐색
            dfs(c, n, m-1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        M = in.nextInt(); // 세로
        N = in.nextInt(); // 가로

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = in.next();
            for(int j =0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'W' && !visited[i][j]){
                    dfs('W', i, j);
                    result1 += count * count;
                    count = 0;
                }else if(map[i][j] == 'B' && !visited[i][j]){
                    dfs('B', i, j);
                    result2 += count * count;
                    count = 0;
                }
            }
        }

        System.out.print(result1 + " "+ result2);
    }
}
