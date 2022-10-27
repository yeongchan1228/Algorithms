package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem8979 { // 올림픽
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Info[] infos = new Info[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            infos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(infos);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (infos[i].num == k) {
                cnt = i;
                break;
            }
        }

        int ranking = 1;
        Info a = infos[cnt];
        for (int i = 0; i < cnt; i++) {
            Info b = infos[i];
            if (a.gold == b.gold && a.silver == b.silver && a.bronze == b.bronze) {
                break;
            }
            ranking++;
        }

        out.write(String.valueOf(ranking));
        out.flush();
        out.close();
    }

    static class Info implements Comparable<Info> {
        int num;
        int gold;
        int silver;
        int bronze;

        public Info(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Info o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                }
                else return o.silver - this.silver;
            }
            else
                return o.gold - this.gold;
        }
    }
}
