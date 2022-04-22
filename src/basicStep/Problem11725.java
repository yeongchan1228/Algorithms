package basicStep;

import java.io.*;
import java.util.*;

public class Problem11725 { // 트리의 부모 찾기

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        visited = new boolean[N + 1];
        list = new List[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(in.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        bfs();

        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append('\n');
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void bfs(){
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < list[1].size(); i++) {
            Integer value = list[1].get(i);
            parent[value] = 1;
            visited[value] = true;
            queue.offer(value);
        }

        while (!queue.isEmpty()){
            Integer value = queue.poll();

            for (int i = 0; i < list[value].size(); i++) {
                Integer integer = list[value].get(i);
                if(!visited[integer]){
                    parent[integer] = value;
                    visited[integer] = true;
                    queue.offer(integer);
                }
            }
        }
    }
}
