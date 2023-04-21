package programmers.level3;

public class N12979 { // 숫자 게임
    public static void main(String[] args) {
        int N = 11;
        int[] stations = {4, 11};
        int W = 1;
        System.out.println(new Solution().solution(N, stations, W));
    }

    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int left = 1;
            int answer = 0;
            for (int station : stations) {
                int right = station - w - 1;
                answer += (right - left + 1) / (w * 2 + 1);
                if ((right - left + 1) % (w * 2 + 1) > 0) {
                    answer++;
                }
                left = station + w + 1;
            }

            if (n > stations[stations.length - 1] + w) {
                answer += (n - left + 1) / (w * 2 + 1);
                if ((n - left + 1) % (w * 2 + 1) > 0) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
