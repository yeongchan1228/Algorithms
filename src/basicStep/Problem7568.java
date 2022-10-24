package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem7568 { // 덩치
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        Info[] infos = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            infos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int ranking = 1;
            Info info1 = infos[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                Info info2 = infos[j];
                if (info1.x < info2.x && info1.y < info2.y) {
                    ranking++;
                }
            }
            result.append(ranking + " ");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }

    static class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
