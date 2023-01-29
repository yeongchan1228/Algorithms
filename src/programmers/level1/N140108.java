package programmers.level1;

public class N140108 { // 문자열 나누기
    public static void main(String[] args) {
        String s = "banana";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;
            int firstCnt = 0;
            char firstCh = '0';
            int anotherCnt = 0;
            for (char ch : s.toCharArray()) {
                if (firstCnt == 0) {
                    firstCh = ch;
                    firstCnt++;
                    continue;
                }

                if (firstCh == ch) {
                    firstCnt++;
                } else {
                    anotherCnt++;
                }

                if (firstCnt == anotherCnt) {
                    answer++;
                    firstCh = '0';
                    firstCnt = 0;
                    anotherCnt = 0;
                }
            }
            return firstCnt == 0 ? answer : answer + 1;
        }
    }
}
