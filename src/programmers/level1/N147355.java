package programmers.level1;

public class N147355 { // 크기가 작은 부분 문자열
    public static void main(String[] args) {
        String t = "500220839878";
        String p = "7";
        System.out.println(new Solution().solution(t, p));
    }

    static class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            int len = p.length();
            long num = Long.parseLong(p);
            for (int i = 0; i <= t.length() - len; i++) {
                if (Long.parseLong(t.substring(i, i + len)) <= num) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
