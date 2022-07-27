package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11650 { // 좌표 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(in.readLine());

        Point[] arr = new Point[cnt];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        });

        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(point -> sb.append(point.x + " " + point.y + "\n"));

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
