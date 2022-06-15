package basicStep;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem1620 { // 포켓몬 마스터 이다솜
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] names = new String[N + 1];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            names[i + 1] = str;
            map.put(str, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String str = in.readLine();
//            if(str.matches("^[0-9]*")){
//                sb.append(names[Integer.parseInt(str)] + "\n");
            if(str.charAt(0) >= 49 && str.charAt(0) <= 57){
                sb.append(names[Integer.parseInt(str)] + "\n");
            }else{
                sb.append(map.get(str) + "\n");
            }
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
