package programmers.level2;

public class N12911 { // 다음 큰 숫자
    public static void main(String[] args) {
        int n = 78;

        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int oneCnt = Integer.bitCount(n);
            while (true) {
                n++;
                int nowOneCnt = Integer.bitCount(n);

                if (oneCnt == nowOneCnt) {
                    return n;
                }
            }
        }
    }
}
