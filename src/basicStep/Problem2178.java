package basicStep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2178 { // 미로탐색

    static int ROW, COL;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int []> queue;

    public static void bfs(int row, int col){
        queue = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new int[] {row, col});


        while(!queue.isEmpty()){
            int[] dot = queue.poll();

            if(dot[0] - 1 > -1 && !visited[dot[0] - 1][dot[1]] && map[dot[0] - 1][dot[1]] > 0){ // 위 탐색
                queue.add(new int[] {dot[0]-1, dot[1]});
                visited[dot[0]-1][dot[1]] = true;
                map[dot[0]-1][dot[1]] = map[dot[0]][dot[1]] + 1;
            }
            if(dot[0] + 1 < ROW && !visited[dot[0] + 1][dot[1]] && map[dot[0] + 1][dot[1]] > 0){ // 아래 탐색
                queue.add(new int[] {dot[0]+1, dot[1]});
                visited[dot[0]+1][dot[1]] = true;
                map[dot[0]+1][dot[1]] = map[dot[0]][dot[1]] + 1;
            }
            if(dot[1] + 1 < COL && !visited[dot[0]][dot[1] + 1] && map[dot[0]][dot[1]+1] > 0){ // 오른쪽 탐색
                queue.add(new int[] {dot[0], dot[1]+1});
                visited[dot[0]][dot[1] + 1] = true;
                map[dot[0]][dot[1]+1] = map[dot[0]][dot[1]] + 1;
            }
            if(dot[1] - 1 > -1 && !visited[dot[0]][dot[1] - 1] && map[dot[0]][dot[1] - 1] > 0){ // 왼쪽 탐색
                queue.add(new int[] {dot[0], dot[1] - 1});
                visited[dot[0]][dot[1] - 1] = true;
                map[dot[0]][dot[1]-1] = map[dot[0]][dot[1]] + 1;
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ROW = in.nextInt();
        COL = in.nextInt();

        map = new int[ROW][COL];
        visited = new boolean[ROW][COL];

        for(int i = 0; i < ROW; i++){
            String str = in.next();
            for(int j = 0; j < COL; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        bfs(0, 0);

        System.out.print(map[ROW-1][COL-1]);


    }
}
