package programmers.level1;

public class N12901 { // 2016년
    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        System.out.println(new Solution().solution(a, b));
    }

    static class Solution {
        public String solution(int a, int b) {
            int[] dayCnts = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String[] answer = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

            int days = b;
            for (int i = 1; i < a; i++) {
                days += dayCnts[i - 1];
            }

            return answer[(days - 1) % 7];
        }
    }
}
