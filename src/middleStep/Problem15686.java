package middleStep;

import java.io.*;
import java.util.*;

public class Problem15686 { // 치킨 배달

    static int[][] map;
    static boolean[] visited;
    static int N, M = 0;
    static int result = Integer.MAX_VALUE;
//    static Queue<Point> queue = new LinkedList<>();
//    static Map<Point, Integer> find = new HashMap<>();
    static ArrayList<Point> p = new ArrayList<>();
    static ArrayList<Point> c = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
//                    find.put(new Point(i, j), Integer.MAX_VALUE);
                    p.add(new Point(i, j));
                }
                if(value == 2){
                    c.add(new Point(i, j));
                }
                map[i][j] = value;
            }
        }

        visited = new boolean[c.size()];
        dfs(0, 0);

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    static void dfs(int start ,int depth){
        if(depth == M){
            int temp = 0;
            for (int i = 0; i < p.size(); i++) {
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < c.size(); j++) {
                    if(visited[j]){
                        int d = Math.abs(p.get(i).x - c.get(j).x) + Math.abs(p.get(i).y - c.get(j).y);
                        min = Math.min(min, d);
                    }
                }

                temp += min;
            }
            result = Math.min(result, temp);
        }

        for (int i = start; i < c.size(); i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

//    static void dfs(int x, int depth){
//        if(depth == M){
//            bfs();
//            return;
//        }
//
//        for (int i = x; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if(map[i][j] == 2 && !visited[i][j]){
//                    queue.offer(new Point(i, j));
//                    visited[i][j] = true;
//                    dfs(i, depth + 1);
//                    visited[i][j] = false;
//                    queue.poll();
//                }
//            }
//        }
//    }

//    static void bfs(){
//        int sizeC = queue.size();
//        int temp = 0;
//        for (int t = 0; t < sizeC; t++) {
//            Point point = queue.poll(); // 치킨집 위치
//            int chickenX = point.x;
//            int chickenY = point.y;
//
//            Iterator<Point> iterator = find.keySet().iterator();
//            while (iterator.hasNext()){
//                Point next = iterator.next();
//                Integer number = find.get(next);
//                int min = Math.min(number, (Math.abs(next.x - chickenX) + Math.abs(next.y - chickenY)));
//                find.put(next, min);
//            }
//            queue.offer(point);
//        }
//
//        Iterator<Point> iterator = find.keySet().iterator();
//        while (iterator.hasNext()){
//            Point next = iterator.next();
//            Integer integer = find.get(next);
//            temp += integer;
//            find.put(next, Integer.MAX_VALUE);
//        }
//
//        if(temp < result){
//            result = temp;
//        }
//    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
