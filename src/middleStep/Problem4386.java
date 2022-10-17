package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem4386 { // 별자리 만들기

    static int n;
    static int[] parents;
    static ArrayList<Info> list;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(in.readLine());
        Star[] stars = new Star[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            stars[i] = new Star(Double.parseDouble(st.nextToken()), (Double.parseDouble(st.nextToken())));
        }

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new Info(i, j, calcDistance(stars[i], stars[j])));
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.price < o2.price) {
                return -1;
            }
            return 1;
        });

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        out.write(String.valueOf(kruskal()));
        out.flush();
        out.close();
    }

    private static double kruskal() {
        double result = 0;
        for (Info info : list) {
            int from = info.from;
            int to = info.to;
            double price = info.price;

            if (find(from) != find(to)) {
                union(from, to);
                result += price;
            }
        }

        return result;
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }

    static double calcDistance(Star star1, Star star2) {
        return Math.sqrt(Math.pow(star2.x - star1.x, 2) + Math.pow(star2.y - star1.y, 2));
    }

    static class Info {
        int from;
        int to;
        double price;

        public Info(int from, int to, double price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "from=" + from +
                    ", to=" + to +
                    ", price=" + price +
                    '}';
        }
    }

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
