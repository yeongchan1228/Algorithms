package programmers.level2;

public class N161989 { // 덧칠하기

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};
        System.out.println(new Solution().solution(n, m ,section));
    }

    static class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 1;
            int idx = section[0];
            for (int i = 1; i < section.length; i++) {
                if (idx + m - 1 < section[i]) {
                    answer++;
                    idx = section[i];
                }
            }
            return answer;
        }
    }
}
