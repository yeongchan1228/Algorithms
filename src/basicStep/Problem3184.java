package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3184 { // 양

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, col, resultW, resultS, cntS, cntW;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        visited = new boolean[row][col];

       /* fx = new int[row * col];
        fy = new int[row * col];

        cnt = 0;
        for (int i = 0; i < row; i++) {
            String str = in.readLine();
            for (int j = 0; j < col; j++) {
                char ch = str.charAt(j);
                if(ch == 'v' || ch == 'o'){
                    fx[cnt] = i;
                    fy[cnt] = j;
                    cnt++;
                }
                map[i][j] = ch;
            }
        }
        bfs();*/

        for (int i = 0; i < row; i++) {
            map[i] = in.readLine().toCharArray();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'o')){
                    cntS = 0;
                    cntW = 0;

                    bfs(i, j);

                    if(cntS > cntW)
                        resultS += cntS;
                    else
                        resultW += cntW;
                }
            }
        }

        System.out.print(resultS + " " + resultW);
        
    }

    static void bfs(int i, int j){
        queue = new LinkedList<>();
        if(map[i][j] == 'o')
            cntS++;
        else
            cntW++;
        queue.offer(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()){
            Point temp = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int mx = temp.x + dx[k];
                int my = temp.y + dy[k];

                if(mx >= 0 && mx < row && my >= 0 && my < col && !visited[mx][my] && map[mx][my] != '#'){
                    queue.offer(new Point(mx, my));
                    visited[mx][my] = true;

                    if(map[mx][my] == 'o') {
                        cntS++;
                    }
                    else if(map[mx][my] == 'v') {
                        cntW++;
                    }
                }
            }
        }

/*        for (int i = 0; i < (cnt - 1); i++) {
            int countW = 0;
            int countS = 0;
            queue = new LinkedList<>();

            if(!visited[fx[i]][fy[i]]) {

                queue.offer(new Point(fx[i], fy[i]));
                visited[fx[i]][fy[i]] = true;

                if (map[fx[i]][fy[i]] == 'v') {
                    countW++;
                } else {
                    countS++;
                }
                
            }

            while (!queue.isEmpty()){
                Point now = queue.poll();

                for (int j = 0; j < dx.length; j++) {
                    int mx = now.x + dx[j];
                    int my = now.y + dy[j];

                    if(mx >= 0 && mx < row && my >= 0 && my < col && !visited[mx][my] &&
                            map[mx][my] != '#'){

                        queue.offer(new Point(mx, my));
                        visited[mx][my] = true;

                        if(map[mx][my] == 'o'){
                            countS++;
                        }else if(map[mx][my] == 'v'){
                            countW++;
                        }
                    }
                }
            }

            if(countS > countW) {
                resultS += countS;
            }
            else {
                resultW += resultW;
            }
        }*/
    }

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
