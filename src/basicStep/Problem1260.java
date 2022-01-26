package basicStep;

import java.util.*;

public class Problem1260 { // DFS와 BFS

    static Queue<Integer> queue = new LinkedList<>();
    static int[] visted;
    static int[][] map;
    static int N, M, V;
    static ArrayList<Integer> ansB;
    static ArrayList<Integer> ansD = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        V = in.nextInt();
        int st, ed = 0;

        map = new int[N+1][N+1];
        visted = new int[N+1];

        for(int i = 0; i < M; i++){
            st = in.nextInt();
            ed = in.nextInt();

            /* 양방향 */
            map[st][ed] = 1;
            map[ed][st] = 1;
        }

        DFS(V);
        for(int i = 0; i < ansD.size(); i++){
            if (i == ansD.size()-1)
                System.out.println(ansD.get(i));
            else
                System.out.print(ansD.get(i)+ " ");
        }

        for(int i = 0; i <= N; i++){ // visted 초기화
            visted[i] = 0;
        }

        BFS(V);

        for(int i = 0; i < ansB.size(); i++){
            if (i == ansB.size()-1)
                System.out.print(ansB.get(i));
            else
                System.out.print(ansB.get(i) + " ");
        }

    }

    public static void DFS(int n){
        ansD.add(n);
        visted[n] = 1;

        for (int i = 0; i <= N; i++) {
            if(map[n][i] == 1 && visted[i] == 0){
                DFS(i);
            }
        }
    }

    public static void BFS(int n){
        int k = 0;
        ansB = new ArrayList<>();
        queue.add(n);
        visted[n] = 1;

        while(!queue.isEmpty()) {
            ansB.add(queue.poll());
            k++;
            for (int i = 0; i <= N; i++) {
                if (map[ansB.get(k-1)][i] == 1 && visted[i] == 0) {
                    queue.add(i);
                    visted[i] = 1;
                }
            }
        }
    }
}
