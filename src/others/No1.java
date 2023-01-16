package others;

import java.util.*;
import java.io.*;


public class No1 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        Info[] infos = new Info[n];
        Info[] sumInfos = new Info[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] splits = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                infos[j] = new Info(Integer.parseInt(splits[j]), j);

                if (i == 0) {
                    sumInfos[j] = new Info(Integer.parseInt(splits[j]), j);
                } else {
                    sumInfos[j].val += Integer.parseInt(splits[j]);
                }
            }

            calc(infos, sb);
        }

        calc(sumInfos, sb);

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void calc(Info[] infos, StringBuilder sb) {
        Arrays.sort(infos, ((o1, o2) -> o2.val - o1.val));

        int score = 1;
        int saveIdx = 0;
        int[] answer = new int[infos.length];
        for (int j = 0; j < infos.length; j++) {
            Info nowInfo = infos[j];
            if (j != 0 && infos[j - 1].val != nowInfo.val) {
                if (saveIdx != 0) {
                    score += saveIdx;
                } else {
                    score++;
                }
            } else {
                saveIdx++;
            }

            answer[nowInfo.idx] = score;
        }

        for (int j = 0; j < answer.length; j++) {
            if (j == answer.length - 1) {
                sb.append(answer[j] + "\n");
                break;
            }
            sb.append(answer[j] + " ");
        }
    }

    public static class Info {
        int val;
        int idx;

        public Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}