package basicStep;

import java.util.Scanner;

public class Problem2606 { // 바이러스

    static int N;
    static int M;
    static int[][] map;
    static boolean[] visited;
    static int result = 0;


    public static void dfs(int x){
        visited[x] = true;

        for(int i = 0; i < N; i++){
            if(!visited[i] && map[x][i] == 1){
                result++;
                dfs(i);
            }
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        map = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < M; i++){
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            map[num1 - 1][num2 - 1] = map[num2 - 1][num1 - 1] = 1;
        }

        dfs(0);

        System.out.print(result);

    }
}
