package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem7576 { // 토마토

    static Queue<Point> queue = new LinkedList<>();
//    static boolean[][] visited;
    static int count = 0;
//    static ArrayList<Integer> searchX = new ArrayList<>();
//    static ArrayList<Integer> searchY = new ArrayList<>();
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = in.readLine().split(" ");
        int row = Integer.parseInt(str[1]);
        int col = Integer.parseInt(str[0]);
//        visited = new boolean[row][col];
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] value = in.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(value[j]);
                if (value[j].equals("1")) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        out.write(String.valueOf(bfs(row, col) - 1));
        out.flush();
        out.close();
    }

    static int bfs(int row, int col){
        while (!queue.isEmpty()){
            Point point = queue.poll();
            int nowX = point.x;
            int nowY = point.y;

            for (int i = 0; i < 4; i++) {
                int pX = nowX + dx[i];
                int pY = nowY + dy[i];
                if(pX < row && pX > -1 && pY < col && pY > -1){
                    if(map[pX][pY] == 0) {
                        queue.offer(new Point(pX, pY));
                        map[pX][pY] = map[nowX][nowY] + 1;
                    }
                }
            }
        }

        int result = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j] == 0){
                    return 0;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        if(result == 1)
            return 1;
        else
            return result;
    }


// 시간 초과, 메모리 초과
//        for (int i = 0; i < row; i++) {
//            String[] value = in.readLine().split(" ");
//            for (int j = 0; j < col; j++) {
//                map[i][j] = Integer.parseInt(value[j]);
//            }
//        }
//
//        search(row, col);
//
//        boolean check = false;
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if(!visited[i][j]){
//                    check = true;
//                    break;
//                }
//            }
//        }
//
//        if(check) {
//            bfs(row, col);
//
//            for (int i = 0; i < row; i++) {
//                for (int j = 0; j < col; j++) {
//                    if (!visited[i][j]) {
//                        out.write("-1");
//                        out.flush();
//                        out.close();
//                        return;
//                    }
//                }
//            }
//            out.write(String.valueOf(count - 1));
//            out.flush();
//            out.close();
//
//        }else{
//            out.write("0");
//            out.flush();
//            out.close();
//        }
//
//    }
//
//    static void bfs(int row, int col){
//        if(!searchX.isEmpty()){
//            for (int i = 0; i < searchX.size(); i++) {
//                Integer x = searchX.get(i);
//                Integer y = searchY.get(i);
//                queue.offer(new Point(x, y));
//                visited[y][x] = true;
//            }
//        }else {
//            return;
//        }
//
//        while (true){
//            if(searchX.size() == 0) break;
//            searchX.remove(0);
//            searchY.remove(0);
//        }
//
//        while (!queue.isEmpty()){
//            Point point = queue.poll();
//            int nowX = point.x;
//            int nowY = point.y;
//
//            for (int i = 0; i < 4; i++) {
//                int pX = nowX + dx[i];
//                int pY = nowY + dy[i];
//                if(pX < col && pX > -1 && pY < row && pY > -1 && !visited[pY][pX]){
//                    searchX.add(pX);
//                    searchY.add(pY);
//                }
//            }
//        }
//        count++;
//        bfs(row, col);
//    }
//
//    static void search(int row, int col){
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if(map[i][j] == 1){
//                    searchX.add(j);
//                    searchY.add(i);
//                    visited[i][j] = true;
//                }
//
//                if(map[i][j] == -1){
//                    visited[i][j] = true;
//                }
//            }
//        }
//    }

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
