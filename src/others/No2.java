package others;

import java.util.*;
import java.io.*;


public class No2 { // 이분탐색
    static int answer = 0;

    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int h = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, h + 1);
        Info[] tree = new Info[size];
        init(1, 0, h, tree);

        for (int i = (int) Math.pow(2, h); i < size; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < k; j++) {
                tree[i].jobs.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= r; i++) {
            work(1, 0, i, h, tree);
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    private static void work(int idx, int depth, int day, int h, Info[] tree) {
        if (depth > h) {
            return;
        }

        Info info = tree[idx];
        if (depth == h && !info.jobs.isEmpty()) {
            int job = info.jobs.poll();
            if (idx % 2 == 0) {
                tree[idx / 2].leftJobs.offer(job);
            } else {
                tree[idx / 2].rigthsJobs.offer(job);
            }
        } else if (depth < h && day % 2 == 0 && !info.rigthsJobs.isEmpty()) {
            int job = info.rigthsJobs.poll();
            if (depth == 0) {
                answer += job;
            } else {
                if (idx % 2 == 0) {
                    tree[idx / 2].leftJobs.offer(job);
                } else {
                    tree[idx / 2].rigthsJobs.offer(job);
                }
            }
        } else if (depth < h && day % 2 != 0 && !info.leftJobs.isEmpty()) {
            int job = info.leftJobs.poll();
            if (depth == 0) {
                answer += job;
            } else {
                if (idx % 2 == 0) {
                    tree[idx / 2].leftJobs.offer(job);
                } else {
                    tree[idx / 2].rigthsJobs.offer(job);
                }
            }
        }

        work(idx * 2, depth + 1, day, h , tree);
        work(idx * 2 + 1, depth + 1, day, h , tree);
    }

    private static void init(int idx, int depth, int h, Info[] tree) {
        if (depth > h) {
            return;
        }

        tree[idx] = new Info(depth, h);

        init(idx * 2, depth + 1, h, tree);
        init(idx * 2 + 1, depth + 1, h, tree);
    }

    public static class Info {
        int depth;
        Queue<Integer> leftJobs;
        Queue<Integer> rigthsJobs;
        Queue<Integer> jobs;

        public Info(int depth, int h) {
            this.depth = depth;
            if (depth == h) {
                jobs = new LinkedList<>();
            } else {
                leftJobs = new LinkedList<>();
                rigthsJobs = new LinkedList<>();
            }
        }
    }
}