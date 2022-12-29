package programmers.level3;

public class N86053 { // 금과 은 운반하기

    public static void main(String[] args) {
        int a = 90;
        int b = 500;
        int[] g = {70, 70, 0};
        int[] s = {0, 0, 500};
        int[] w = {100, 100,2};
        int[] t = {4, 8, 1};
        System.out.println(new Solution().solution(a, b, g, s, w, t));
    }

    static class Solution {
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long start = 0;
            long end = (long) (Math.pow(10, 9) * Math.pow(10, 5) * 4);
            int size = g.length;

            long answer = end;
            while (start <= end) {
                long mid = (start + end) / 2;
                int gold = 0;
                int silver = 0;
                int finishedVal = 0;

                for (int i = 0; i < size; i++) {
                    int nowGold = g[i];
                    int nowSilver = s[i];
                    int nowWeight = w[i];
                    int nowTime = t[i];

                    long moveCnt = mid / (nowTime * 2);
                    if (mid % (nowTime * 2) >= nowTime) {
                        moveCnt++;
                    }

                    gold += Math.min(nowGold, nowWeight * moveCnt);
                    silver += Math.min(nowSilver, nowWeight * moveCnt);
                    finishedVal += Math.min(nowGold + nowSilver, moveCnt * nowWeight);
                }

                if (a <= gold && b <= silver && a + b <= finishedVal) {
                    end = mid - 1;
                    answer = Math.min(mid, answer);
                    continue;
                }

                start = mid + 1;
            }
            return answer;
        }
    }
}
