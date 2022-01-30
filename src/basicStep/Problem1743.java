package basicStep;

import java.util.Scanner;

public class Problem1743 { // 음식물 피하기

    static int ROW, COL, COUNT;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int sum = 0;
    static int result = 0;

    public static void dfs(int row, int col){
        if(!visited[row][col]) {
            visited[row][col] = true;
            if (map[row][col] == 1) {
                sum++;
            }

            for (int i = 0; i < 4; i++) {
                int colX = col + dx[i];
                int rowY = row + dy[i];

                if (colX < 0 || colX > COL - 1 || rowY < 0 || rowY > ROW - 1)
                    continue;

                if (!visited[rowY][colX] && map[rowY][colX] == 1) {
                    dfs(rowY, colX);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ROW = in.nextInt();
        COL = in.nextInt();
        COUNT = in.nextInt();

        map = new int[ROW][COL];
        visited = new boolean[ROW][COL];

        for(int i = 0; i < COUNT; i++){
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            map[num1-1][num2-1] = 1;
        }

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                dfs(i, j);
                result = Math.max(sum, result);
                sum = 0;
            }
        }

        System.out.print(result);

    }
}
