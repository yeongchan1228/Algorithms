package basicStep;

import java.io.*;
import java.util.*;

public class Problem1713 { // 후보 추천하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int idx = Integer.parseInt(in.readLine());
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return o2.idx - o1.idx;
            }

            return o1.cnt - o2.cnt;
        });

        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        while (idx --> 0) {
            int num = Integer.parseInt(st.nextToken());
            if (!set.contains(num) && pq.size() == n) {
                Info removeInfo = pq.poll();
                set.remove(removeInfo.num);
            }

            int savedCnt = 0;
            int savedIdx = idx;
            if (set.contains(num)) {
                for (Iterator<Info> iterator = pq.iterator(); iterator.hasNext();) {
                    Info next = iterator.next();
                    if (next.num == num) {
                        savedCnt = next.cnt;
                        savedIdx = next.idx;
                        iterator.remove();
                        break;
                    }
                }
            }

            set.add(num);
            pq.offer(new Info(num, savedIdx, savedCnt + 1));
        }

        StringBuilder sb = new StringBuilder();
        set.stream().sorted().forEach(i -> sb.append(i + " "));

        out.write(sb.toString().trim());
        out.flush();
        out.close();
    }

    public static class Info {
        int num;
        int idx;
        int cnt;

        public Info(final int num, final int idx, final int cnt) {
            this.num = num;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
