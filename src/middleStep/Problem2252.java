package middleStep;

import java.io.*;
import java.util.*;

public class Problem2252 { // 줄 세우기

    static int V, E;
    static List<Integer>[] lists;
    static int[] inDegree;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        V = Integer.parseInt(st.nextToken());
        lists = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }
        inDegree = new int[V + 1];
        visited = new boolean[V + 1];
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            inDegree[end]++;
        }

        for (int i = 1; i <= V; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
                visited[i] = true;
            }
        }

        bfs();

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void bfs(){
        while (!queue.isEmpty()){
            Integer v = queue.poll();
            sb.append(v).append(" ");

            for (int i = 0; i < lists[v].size(); i++) {
                Integer number = lists[v].get(i);
                inDegree[number]--;
                if(!visited[number] && inDegree[number] == 0){
                    queue.offer(number);
                    visited[number] = true;
                }
            }
        }
    }
}
