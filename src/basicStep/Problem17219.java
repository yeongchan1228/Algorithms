package basicStep;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem17219 { // 비밀번호 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            hashMap.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(hashMap.get(in.readLine()) + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
