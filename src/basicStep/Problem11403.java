package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11403 { // 경로 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N][N];
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) { // 거쳐가는 점
            for (int i = 0; i < N; i++) { // 시작 점
                for (int j = 0; j < N; j++) { // 도착 점
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
