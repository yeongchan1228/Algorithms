package programmers.level2;

public class N172927 { // 광물 캐기
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(new Solution().solution(picks, minerals));
    }

    static class Solution {
        public static int answer = Integer.MAX_VALUE;
        public int solution(int[] picks, String[] minerals) {
            calc(0, picks[0], picks[1], picks[2], 0, minerals);
            return answer;
        }

        private void calc(int idx, int diamondPickCount, int ironPickCount, int stonePickCount, int totalFatigue, String[] minerals) {
            if ((diamondPickCount == 0 && ironPickCount == 0 && stonePickCount == 0) || idx == minerals.length) {
                answer = Math.min(answer, totalFatigue);
                return;
            }

            if (diamondPickCount > 0) {
                int cnt = 0;
                int sum = 0;
                for (int i = idx; i < idx + 5 && i < minerals.length; i++, cnt++) {
                    sum += 1;
                }
                calc(idx + cnt, diamondPickCount - 1, ironPickCount, stonePickCount, totalFatigue + sum, minerals);
            }

            if (ironPickCount > 0) {
                int cnt = 0;
                int sum = 0;
                for (int i = idx; i < idx + 5 && i < minerals.length; i++, cnt++) {
                    if (minerals[i].equals("diamond")) {
                        sum += 5;
                    } else {
                        sum += 1;
                    }
                }
                calc(idx + cnt, diamondPickCount, ironPickCount - 1, stonePickCount, totalFatigue + sum, minerals);
            }

            if (stonePickCount > 0) {
                int cnt = 0;
                int sum = 0;
                for (int i = idx; i < idx + 5 && i < minerals.length; i++, cnt++) {
                    if (minerals[i].equals("diamond")) {
                        sum += 25;
                    } else if (minerals[i].equals("iron")) {
                        sum += 5;
                    } else {
                        sum += 1;
                    }
                }
                calc(idx + cnt, diamondPickCount, ironPickCount, stonePickCount - 1, totalFatigue + sum, minerals);
            }
        }
    }
}
