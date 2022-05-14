package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15658 { // 연산자 끼워넣기 (2)

    static int N, max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int contPl, contMi, contMu, contDi = 0;
        st = new StringTokenizer(in.readLine());
        contPl = Integer.parseInt(st.nextToken());
        contMi = Integer.parseInt(st.nextToken());
        contMu = Integer.parseInt(st.nextToken());
        contDi = Integer.parseInt(st.nextToken());

        dfs(1, contPl, contMi,contMu, contDi, arr[0]);

        out.write(String.valueOf(max + "\n" + min));
        out.flush();
        out.close();

    }

    static void dfs(int depth, int contPl, int contMi, int contMu, int contDi, int result){
        if(depth == N){
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }



        if(contPl > 0){
            contPl--;
            dfs(depth + 1, contPl, contMi, contMu, contDi, result + arr[depth]);
            contPl++;
        }
        if(contMi > 0){
            contMi--;
            dfs(depth + 1, contPl, contMi, contMu, contDi, result - arr[depth]);
            contMi++;
        }
        if(contMu > 0){
            contMu--;
            dfs(depth + 1, contPl, contMi, contMu, contDi, result * arr[depth]);
            contMu++;
        }
        if(contDi > 0){
            contDi--;
            dfs(depth + 1, contPl, contMi, contMu, contDi, result / arr[depth]);
            contDi++;
        }
    }
}
